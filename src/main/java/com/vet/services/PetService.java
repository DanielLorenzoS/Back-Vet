package com.vet.services;

import com.vet.entities.pet.PetEntity;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface PetService {

    List<PetEntity> getAllPets();

    Optional<PetEntity> getPetById(int id);

    PetEntity savePet(PetEntity petEntity) throws ParseException;

    Optional<PetEntity> editPet(PetEntity petEntity);

    Optional<PetEntity> deletePetById(int id);
}
