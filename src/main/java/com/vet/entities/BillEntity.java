package com.vet.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
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
@Table(name="bills")
public class BillEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = UserEntity.class)
    @JoinColumn(name = "bill_user_id")
    private UserEntity user;

    @Past
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdAt;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date expirationDate;

    @NotNull
    private float total;

    @NotNull
    private String paymentMethod;

    @NotNull
    private String paymentStatus;

    @NotNull
    private String discount;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = ProductEntity.class)
    @JoinTable(name = "bill_products",
            joinColumns = @JoinColumn(name = "bill_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<ProductEntity> products;
}