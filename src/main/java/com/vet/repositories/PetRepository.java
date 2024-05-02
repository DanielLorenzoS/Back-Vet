package com.vet.repositories;

import com.vet.entities.pets.PetEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> {

    Optional<PetEntity> findByName(String name);

    Page<PetEntity> findByNameStartingWith(String name, Pageable pageable);

    Page<PetEntity> findByLastNameStartingWith(String lastName, Pageable pageable);

    Page<PetEntity> findBySpecieStartingWith(String specie, Pageable pageable);

    Page<PetEntity> findByRaceStartingWith(String race, Pageable pageable);

    Page<PetEntity> findBySexStartingWith(String sex, Pageable pageable);
}
