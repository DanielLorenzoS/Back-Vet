package com.vet.services.Impl;

import com.vet.entities.users.UserEntity;
import com.vet.repositories.UserRepository;
import com.vet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public Page<UserEntity> getAllUsers(int page, int size, String[] sort) {
        Sort sortable = Sort.by(sort[0]);
        PageRequest pageable = PageRequest.of(page, size, sortable);

        return userRepository.findAll(pageable);
    }

    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public Optional<UserEntity> updateUser(UserEntity userEntity) {
        Optional<UserEntity> user = userRepository.findById(userEntity.getId());
        if (user.isPresent()) {
            user.get().setName(userEntity.getName());
            user.get().setLastName(userEntity.getLastName());
            user.get().setEmail(userEntity.getEmail());
            user.get().setPhone(userEntity.getPhone());
            user.get().setCity(userEntity.getCity());
            user.get().setMunicipality(userEntity.getMunicipality());
            user.get().setStreet(userEntity.getStreet());
            user.get().setNumber(userEntity.getNumber());
            return Optional.of(userRepository.save(user.get()));
        } else {
            return Optional.empty();
        }
    }

    public Optional<UserEntity> getUserById(int id) {
        return userRepository.findById((long) id);
    }

    public Optional<UserEntity> deleteUserById(int id) {
        Optional<UserEntity> user = userRepository.findById((long) id);
        if (user.isPresent()) {
            userRepository.deleteById((long) id);
            return user;
        } else {
            return Optional.empty();
        }
    }

    public Page<UserEntity> getAllUsersByFilter(String name,
                                              String lastName,
                                              String email,
                                              String phone,
                                              int page,
                                              int size,
                                              String[] sort) {
        Sort sortable = Sort.by(sort[0]);
        PageRequest pageable = PageRequest.of(page, size, sortable);
        if (name != null) {
            System.out.println(userRepository.findAllByNameStartingWith(name, pageable));
            return userRepository.findAllByNameStartingWith(name, pageable);
        } else if (lastName != null) {
            return userRepository.findAllByLastNameStartingWith(lastName, pageable);
        } else if (email != null) {
            return userRepository.findAllByEmailStartingWith(email, pageable);
        } else if (phone != null) {
            return userRepository.findAllByPhoneStartingWith(phone, pageable);
        } else {
            return userRepository.findAll(pageable);
        }
    }
}
