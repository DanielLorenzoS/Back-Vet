package com.vet.services.Impl;

import com.vet.entities.pet.PetEntity;
import com.vet.repositories.PetRepository;
import com.vet.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    PetRepository petRepository;

    public List<PetEntity> getAllPets() {
        return petRepository.findAll();
    }

    public Optional<PetEntity> getPetById(int id) {
        return Optional.ofNullable(petRepository.findById((long) id).orElse(null));
    }

    public PetEntity savePet(PetEntity petEntity) throws ParseException {
        Date date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
                .parse(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
        petEntity.setOnRegister(date);
        return petRepository.save(petEntity);
    }

    public Optional<PetEntity> editPet(PetEntity petEntity) {
        Optional<PetEntity> pet = petRepository.findById(petEntity.getId());
        if (pet.isPresent()) {
            pet.get().setName(petEntity.getName());
            pet.get().setLastName(petEntity.getLastName());
            pet.get().setSex(petEntity.getSex());
            pet.get().setBirthdate(petEntity.getBirthdate());
            pet.get().setSpecie(petEntity.getSpecie());
            pet.get().setRace(petEntity.getRace());
            pet.get().setColor(petEntity.getColor());
            pet.get().setWeight(petEntity.getWeight());
            pet.get().setSize(petEntity.getSize());
            return Optional.of(petRepository.save(pet.get()));
        } else {
            return Optional.empty();
        }
    }

    public Optional<PetEntity> deletePetById(int id) {
        Optional<PetEntity> pet = petRepository.findById((long) id);
        if (pet.isPresent()) {
            petRepository.deleteById((long) id);
            return pet;
        } else {
            return Optional.empty();
        }
    }
}
