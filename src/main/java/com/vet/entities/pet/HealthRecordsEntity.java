package com.vet.entities.pet;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "health_records")
public class HealthRecordsEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "healthRecords", cascade = CascadeType.ALL)
    private List<AllergyEntity> allergies;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id")
    private PetEntity pet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "healthRecords", cascade = CascadeType.ALL)
    private List<MedicalProcedureEntity> medicalProcedures;

}
