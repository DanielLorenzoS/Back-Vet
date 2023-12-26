package com.vet.repositories;

import com.vet.entities.pet.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> {

    Optional<PetEntity> findByName(String name);
}
