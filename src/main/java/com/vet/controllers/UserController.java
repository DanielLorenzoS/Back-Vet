package com.vet.controllers;

import com.vet.entities.UserEntity;
import com.vet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/")
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
