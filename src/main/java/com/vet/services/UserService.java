package com.vet.services;

import com.vet.entities.users.UserEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Page<UserEntity> getAllUsers(int page, int size, String[] sort);

    UserEntity saveUser(UserEntity userEntity);

    Optional<UserEntity> updateUser(UserEntity userEntity);

    Optional<UserEntity> getUserById(int id);

    Optional<UserEntity> deleteUserById(int id);

    Page<UserEntity> getAllUsersByFilter(String name, String lastName, String email,
                                         String phone, int page, int size, String[] sort);

    List<UserEntity> autoCompleteByNameAndByIdRole(String name, Integer idRole);

}
