package com.vet.services;

import com.vet.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<UserEntity> getAllUsers();

    public UserEntity saveUser(UserEntity userEntity);

    public Optional<UserEntity> editUser(UserEntity userEntity);

    public Optional<UserEntity> getUserById(int id);

    public Optional<UserEntity> deleteUserById(int id);

}
