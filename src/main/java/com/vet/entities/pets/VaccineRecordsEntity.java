package com.vet.entities.pets;

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
@Table(name = "vaccine_records")
public class VaccineRecordsEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
