package com.vet.controllers;

import com.vet.entities.pet.PetEntity;
import com.vet.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<PetEntity>> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PetEntity>> getPetById(@PathVariable int id) {
        return ResponseEntity.ok(petService.getPetById(id));
    }

    @PostMapping
    public ResponseEntity<PetEntity> savePet(@RequestBody PetEntity petEntity) throws ParseException {
        return ResponseEntity.ok(petService.savePet(petEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<PetEntity>> editPet(@RequestBody PetEntity petEntity) {
        return ResponseEntity.ok(petService.editPet(petEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<PetEntity>> deletePetById(@PathVariable int id) {
        return ResponseEntity.ok(petService.deletePetById(id));
    }
}
