package com.vet.services;

import com.vet.entities.pets.AppointmentEntity;
import com.vet.entities.pets.PetEntity;
import com.vet.entities.sales.ServiceEntity;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    Optional<AppointmentEntity> getAppointmentById(Long id);

    AppointmentEntity saveAppointment(AppointmentEntity appointmentEntity);

    List<AppointmentEntity> saveAllAppointments(List<AppointmentEntity> appointmentEntities);

    List<AppointmentEntity> getAllAppointments();

    Optional<AppointmentEntity> updateAppointment(AppointmentEntity appointmentEntity);

    Optional<AppointmentEntity> deleteAppointmentById(Long id);

    Page<AppointmentEntity> getAllAppointmentsByFilter(String date,
                                               String time,
                                               String status,
                                               PetEntity pet,
                                               ServiceEntity service,
                                               int page,
                                               int size,
                                               String[] sort);
}
