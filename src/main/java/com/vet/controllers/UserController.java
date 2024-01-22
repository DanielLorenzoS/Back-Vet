package com.vet.controllers;

import com.vet.entities.UserEntity;
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
    public Page<UserEntity> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name,asc") String[] sort) {
        return userService.getAllUsers(page, size, sort);
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/filter")
    public Page<UserEntity> getUsersByFilter(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String phone,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name,asc") String[] sort) {
        System.out.println(lastName);
        return userService.getAllUsersByFilter(name, lastName, email, phone, page, size, sort);
    }

    @PostMapping
    public UserEntity saveUser(@RequestBody UserEntity userEntity) {
        return userService.saveUser(userEntity);
    }

    @PutMapping("/{id}")
    public Optional<UserEntity> editUser(@PathVariable int id, @RequestBody UserEntity userEntity) {
        return userService.editUser(userEntity);
    }

    @DeleteMapping("/{id}")
    public Optional<UserEntity> deleteUserById(@PathVariable int id) {
        return userService.deleteUserById(id);
    }
}
