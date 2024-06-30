package com.vet.entities.sales;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="services")
public class ServiceEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @Size(max = 200)
    private String name;

    @Size(max = 1000)
    private String description;

    @NotNull
    private float price;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date availableFrom;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date availableTo;

    @NotNull
    private boolean active;

    @Size(max = 200)
    private String category;

    @Size(max = 500)
    private String notes;

    @Size(max = 200)
    private String provider;

}
