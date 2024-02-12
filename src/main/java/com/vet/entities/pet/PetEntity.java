package com.vet.entities.pet;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.vet.entities.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "pets")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @Size(max = 40)
    private String name;

    @NotNull @Size(max = 40)
    private String lastName;

    @NotNull @Size(max = 20)
    private String sex;

    @NotNull @Past
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birthdate;

    @NotNull @Size(max = 40)
    private String specie;

    @NotNull @Size(max = 40)
    private String race;

    @NotNull @Size(max = 15)
    private String color;

    @NotNull @Column(unique = true)
    private float weight;

    @NotNull @Size(max = 10)
    private String size;

    @NotNull @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date onRegister;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = UserEntity.class)
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-pets")
    private UserEntity user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = HealthRecordsEntity.class)
    @JoinColumn(name = "health_records_id")
    private HealthRecordsEntity healthRecords;

}
