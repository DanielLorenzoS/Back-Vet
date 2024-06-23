package com.vet.services;

import com.vet.entities.pets.PetEntity;
import com.vet.entities.pets.vo.PetEntityVO;
import org.springframework.data.domain.Page;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface PetService {

    List<PetEntity> getAllPets();

    Optional<PetEntity> getPetById(int id);

    Optional<PetEntityVO> getPetWithUserById(int id);

    PetEntity savePet(PetEntityVO petEntity) throws ParseException;

    Optional<PetEntity> editPet(PetEntity petEntity);

    Optional<PetEntity> deletePetById(int id);

    public Page<PetEntity> getAllPetsByFilter(String name,
                                              String lastName,
                                              String specie,
                                              String race,
                                              String sex,
                                              int page,
                                              int size,
                                              String[] sort);

    List<PetEntity> getPetsByUserId(Long userId);
}
