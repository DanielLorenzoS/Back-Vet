package com.vet.services.Impl;

import com.vet.entities.UserEntity;
import com.vet.repositories.UserRepository;
import com.vet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public Optional<UserEntity> editUser(UserEntity userEntity) {
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
        return Optional.ofNullable(userRepository.findById((long) id).orElse(null));
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
}
