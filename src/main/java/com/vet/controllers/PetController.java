package com.vet.controllers;

import com.vet.entities.pet.PetEntity;
import com.vet.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    PetService petService;

    @GetMapping
    public List<PetEntity> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/{id}")
    public Optional<PetEntity> getPetById(@PathVariable int id) {
        return petService.getPetById(id);
    }

    @PostMapping
    public PetEntity savePet(@RequestBody PetEntity petEntity) throws ParseException {
        return petService.savePet(petEntity);
    }

    @PutMapping("/{id}")
    public Optional<PetEntity> editPet(@PathVariable int id, @RequestBody PetEntity petEntity) {
        return petService.editPet(petEntity);
    }

    @DeleteMapping("/{id}")
    public Optional<PetEntity> deletePetById(@PathVariable int id) {
        return petService.deletePetById(id);
    }
}
