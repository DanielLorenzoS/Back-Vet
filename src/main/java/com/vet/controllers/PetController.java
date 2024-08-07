package com.vet.controllers;

import com.vet.entities.pets.PetEntity;
import com.vet.entities.pets.vo.PetEntityVO;
import com.vet.services.PetService;
import com.vet.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pet")
public class PetController {

    private final PetService petService;
    private final UserService userService;

    public PetController(PetService petService, UserService userService) {
        this.petService = petService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<PetEntity>> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PetEntity>> getPetById(@PathVariable int id) {
        return ResponseEntity.ok(petService.getPetById(id));
    }

    @GetMapping("/petWithUser/{id}")
    public ResponseEntity<Optional<PetEntityVO>> getPetWithUserById(@PathVariable int id) {
        return ResponseEntity.ok(petService.getPetWithUserById(id));
    }

    @PostMapping
    public ResponseEntity<PetEntity> savePet(@RequestBody PetEntityVO petEntity) throws ParseException {
        return ResponseEntity.ok(petService.savePet(petEntity));
    }
    
    @PostMapping("/all")
    public ResponseEntity<List<PetEntity>> saveAllPets(@RequestBody List<PetEntityVO> petEntities) throws ParseException {
        System.out.println(petEntities.get(0).getName());
        return ResponseEntity.ok(petService.saveAllPets(petEntities));
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

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PetEntity>> getPetsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(petService.getPetsByUserId(userId));
    }
}
