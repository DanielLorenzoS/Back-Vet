package com.vet.services;

import com.vet.entities.pet.PetEntity;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface PetService {

    public List<PetEntity> getAllPets();

    public Optional<PetEntity> getPetById(int id);

    public PetEntity savePet(PetEntity petEntity) throws ParseException;

    public Optional<PetEntity> editPet(PetEntity petEntity);

    public Optional<PetEntity> deletePetById(int id);
}
