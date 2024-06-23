package com.vet.controllers;

import com.vet.entities.users.UserEntity;
import com.vet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserEntity>> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name,asc") String[] sort) {
        return ResponseEntity.ok(userService.getAllUsers(page, size, sort));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserEntity>> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<UserEntity>> getUsersByFilter(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name,asc") String[] sort) {
        return ResponseEntity.ok(userService.getAllUsersByFilter(name, lastName, email, phone, page, size, sort));
    }

    @GetMapping("/autocomplete")
    public ResponseEntity<List<UserEntity>> autoCompleteByName(@RequestParam String name, @RequestParam Integer idRole) {
        return ResponseEntity.ok(userService.autoCompleteByNameAndByIdRole(name, idRole));
    }

    @PostMapping
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity userEntity) {
        System.out.println(userEntity.getIdRole());
        return ResponseEntity.ok(userService.saveUser(userEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable int id, @RequestBody UserEntity userEntity) {
        return ResponseEntity.ok(userService.updateUser(userEntity).get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<UserEntity>> deleteUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.deleteUserById(id));
    }
}
