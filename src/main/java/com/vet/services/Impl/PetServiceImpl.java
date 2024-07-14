package com.vet.services.Impl;

import com.vet.entities.pets.PetEntity;
import com.vet.entities.pets.vo.PetEntityVO;
import com.vet.entities.users.UserEntity;
import com.vet.repositories.PetRepository;
import com.vet.services.PetService;
import com.vet.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final UserService userService;

    public PetServiceImpl(PetRepository petRepository, UserService userService) {
        this.petRepository = petRepository;
        this.userService = userService;
    }

    public List<PetEntity> getAllPets() {
        return petRepository.findAll();
    }

    public Optional<PetEntity> getPetById(int id) {
        return petRepository.findById((long) id);
    }

    public Optional<PetEntityVO> getPetWithUserById(int id) {
        Optional<PetEntity> pet = petRepository.findById((long) id);
        PetEntityVO petVO = new PetEntityVO();
        if (pet.isPresent()) {
            petVO.setId(pet.get().getId());
            petVO.setName(pet.get().getName());
            petVO.setLastName(pet.get().getLastName());
            petVO.setSex(pet.get().getSex());
            petVO.setBirthdate(pet.get().getBirthdate());
            petVO.setSpecie(pet.get().getSpecie());
            petVO.setRace(pet.get().getRace());
            petVO.setColor(pet.get().getColor());
            petVO.setWeight(pet.get().getWeight());
            petVO.setSize(pet.get().getSize());
            petVO.setOnRegister(pet.get().getOnRegister());
            petVO.setUserId(pet.get().getUser().getId());
            return Optional.of(petVO);
        } else {
            return Optional.empty();
        }
    }

    public PetEntity savePet(PetEntityVO petEntity) throws ParseException {
        Date date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
                .parse(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
        PetEntity pet = new PetEntity();
        Optional<UserEntity> user = Optional.of(new UserEntity());
        user = userService.getUserById(Math.toIntExact(petEntity.getUserId()));
        pet.setName(petEntity.getName());
        pet.setLastName(petEntity.getLastName());
        pet.setSex(petEntity.getSex());
        pet.setBirthdate(petEntity.getBirthdate());
        pet.setSpecie(petEntity.getSpecie());
        pet.setRace(petEntity.getRace());
        pet.setColor(petEntity.getColor());
        pet.setWeight(petEntity.getWeight());
        pet.setSize(petEntity.getSize());
        pet.setOnRegister(petEntity.getOnRegister());

        pet.setUser(user.get());
        return petRepository.save(pet);
    }

    public List<PetEntity> saveAllPets(List<PetEntityVO> petEntities) throws ParseException {
        Date date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
                .parse(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
        Optional<UserEntity> user = Optional.of(new UserEntity());
        List<PetEntity> pets = new ArrayList<>();
        for (PetEntityVO petEntity : petEntities) {
            PetEntity pet = new PetEntity();
            System.out.println(petEntity.getUserId());
            user = userService.getUserById(Math.toIntExact(petEntity.getUserId()));
            pet.setName(petEntity.getName());
            pet.setLastName(petEntity.getLastName());
            pet.setSex(petEntity.getSex());
            pet.setBirthdate(petEntity.getBirthdate());
            pet.setSpecie(petEntity.getSpecie());
            pet.setRace(petEntity.getRace());
            pet.setColor(petEntity.getColor());
            pet.setWeight(petEntity.getWeight());
            pet.setSize(petEntity.getSize());
            pet.setOnRegister(petEntity.getOnRegister());
            pet.setUser(user.get());
            pets.add(pet);
        }
        return petRepository.saveAll(pets);
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

    public Page<PetEntity> getAllPetsByFilter(String name,
                                              String lastName,
                                              String specie,
                                              String race,
                                              String sex,
                                              int page,
                                              int size,
                                              String[] sort) {
        Sort sortable = Sort.by(sort[0]);
        PageRequest pageable = PageRequest.of(page, size, sortable);
        if (name != null) {
            return petRepository.findByNameStartingWith(name, pageable);
        } else if (lastName != null) {
            return petRepository.findByLastNameStartingWith(lastName, pageable);
        } else if (specie != null) {
            return petRepository.findBySpecieStartingWith(specie, pageable);
        } else if (race != null) {
            return petRepository.findByRaceStartingWith(race, pageable);
        } else if (sex != null) {
            return petRepository.findBySexStartingWith(sex, pageable);
        } else {
            return petRepository.findAll(pageable);
        }
    }

    public List<PetEntity> getPetsByUserId(Long userId) {
        return petRepository.findByUserId(userId);
    }
}
