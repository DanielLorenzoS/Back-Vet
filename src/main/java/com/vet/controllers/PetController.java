package com.vet.controllers;

import com.vet.entities.pets.PetEntity;
import com.vet.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping("/filter")
    public ResponseEntity<Page<PetEntity>> getAllPetsByFilter(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String specie,
            @RequestParam(required = false) String race,
            @RequestParam(required = false) String sex,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name,asc") String[] sort) {
        return ResponseEntity.ok(petService.getAllPetsByFilter(name, lastName, specie, race, sex, page, size, sort));
    }
}
