package com.vet.entities.pets;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vet.entities.sales.ServiceEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "appointments")
public class AppointmentEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private String date;

    @JsonFormat(pattern = "HH:mm")
    private String time;

    private String reason;
    private String status;

    @ManyToOne
    @JoinColumn(name = "idPet")
    private PetEntity pet;

    @ManyToOne
    @JoinColumn(name = "idService")
    private ServiceEntity service;
}
