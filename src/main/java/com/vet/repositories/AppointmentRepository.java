package com.vet.repositories;

import com.vet.entities.pets.AppointmentEntity;
import com.vet.entities.pets.PetEntity;
import com.vet.entities.sales.ServiceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {
    Page<AppointmentEntity> findAllByDate(String date, Pageable pageable);
    Page<AppointmentEntity> findAllByTime(String time, Pageable pageable);
    Page<AppointmentEntity> findAllByStatus(String status, Pageable pageable);
    Page<AppointmentEntity> findAllByPet(PetEntity pet, Pageable pageable);
    Page<AppointmentEntity> findAllByService(ServiceEntity service, Pageable pageable);
}
