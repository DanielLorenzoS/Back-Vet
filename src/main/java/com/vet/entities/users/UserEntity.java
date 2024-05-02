package com.vet.entities.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vet.entities.sales.BillEntity;
import com.vet.entities.pets.PetEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @Email @Size(max = 40) @Column(unique = true)
    private String email;

    @NotNull @Size(max = 12) @Column(unique = true)
    private String phone;

    @NotNull @Size(max = 20)
    private String city;

    @NotNull @Size(max = 20)
    private String municipality;

    @NotNull @Size(max = 20)
    private String street;

    private Integer number;

    @NotNull @Size(max = 100)
    private String password;

    @NotNull @Size(max = 40)
    private String name;

    @NotNull @Size(max = 40)
    private String lastName;

    @NotNull
    private boolean enabled;

    @Past @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdAt;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.MERGE)
    @JsonManagedReference(value = "user-pets")
    private List<PetEntity> pets;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "bill_user_id")
    private List<BillEntity> bills;

}
