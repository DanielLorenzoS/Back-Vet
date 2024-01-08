package com.vet.services;

import com.vet.entities.UserEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public Page<UserEntity> getAllUsers(int page, int size, String[] sort);

    public UserEntity saveUser(UserEntity userEntity);

    public Optional<UserEntity> editUser(UserEntity userEntity);

    public Optional<UserEntity> getUserById(int id);

    public List<UserEntity> getUsersByFilter(
            String name,
            String lastName,
            String email,
            String phone);

    public Optional<UserEntity> deleteUserById(int id);

}
