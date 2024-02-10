package com.vet.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="products")
public class ProductEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @Size(max = 20)
    private String name;

    @Size(max = 100)
    private String description;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date entryDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date expirationDate;

    private float price;

    @Size(max = 20)
    private String category;

    @Size(max = 20)
    private String brand;

    @Size(max = 20)
    private String provider;

    private int quantity;

    private boolean available;

    @Size(max = 20)
    private String type;

    @Size(max = 20)
    private String batchNumber;

    @Size(max = 20)
    private String serialNumber;

    @Size(max = 255)
    private String notes;

    @Size(max = 50)
    private String barcode;

    @Size(max = 50)
    private String qrCode;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = BillEntity.class)
    @JoinTable(name = "bill_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "bill_id"))
    private List<BillEntity> bills;
}
