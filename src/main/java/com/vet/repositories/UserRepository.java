package com.vet.repositories;

import com.vet.entities.users.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Page<UserEntity> findAllByEmailStartingWith(String email, Pageable pageable);

    Page<UserEntity> findAllByPhoneStartingWith(String phone, Pageable pageable);

    Page<UserEntity> findAllByNameStartingWith(String name, Pageable pageable);

    Page<UserEntity> findAllByLastNameStartingWith(String lastName, Pageable pageable);

    Page<UserEntity> findAllByIdRole(Integer idRole, Pageable pageable);

    List<UserEntity> findAllByNameStartingWithAndIdRole(String name, Integer idRole);

}
