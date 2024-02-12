package com.vet.services;

import com.vet.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public Page<UserEntity> getAllUsers(int page, int size, String[] sort);

    public UserEntity saveUser(UserEntity userEntity);

    public Optional<UserEntity> updateUser(UserEntity userEntity);

    public Optional<UserEntity> getUserById(int id);

    public Optional<UserEntity> deleteUserById(int id);

    public Page<UserEntity> getAllUsersByFilter(String name,
                                                                String lastName,
                                                                String email,
                                                                String phone,
                                                                int page,
                                                                int size,
                                                                String[] sort);

}
