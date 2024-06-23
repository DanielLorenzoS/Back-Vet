package com.vet.entities.pets.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetEntityVO {


    private Long id;  // Include ID for potential updates

    @NotNull
    @Size(max = 40)
    private String name;

    @NotNull
    @Size(max = 40)
    private String lastName;

    @NotNull
    @Size(max = 20)
    private String sex;

    @NotNull
    @Past
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birthdate;

    @NotNull
    @Size(max = 40)
    private String specie;

    @NotNull
    @Size(max = 40)
    private String race;

    @NotNull
    @Size(max = 15)
    private String color;

    @NotNull
    private float weight;

    @NotNull
    @Size(max = 10)
    private String size;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date onRegister;

    private Long userId;
}