package com.vet.repositories;

import com.vet.entities.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    @Query("SELECT u FROM UserEntity u WHERE " +
            "(:name is null or u.name like %:name%) and " +
            "(:lastName is null or u.lastName like %:lastName%) and " +
            "(:email is null or u.email like %:email%) and " +
            "(:phone is null or u.phone like %:phone%)")
    List<UserEntity> findAllByFilter(
            @Param("name") String name,
            @Param("lastName") String lastName,
            @Param("email") String email,
            @Param("phone") String phone);

}
