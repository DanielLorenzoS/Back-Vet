package com.vet.services.Impl;

import com.vet.entities.pets.AppointmentEntity;
import com.vet.entities.pets.PetEntity;
import com.vet.entities.sales.ServiceEntity;
import com.vet.repositories.AppointmentRepository;
import com.vet.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Optional<AppointmentEntity> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public AppointmentEntity saveAppointment(AppointmentEntity appointmentEntity) {
        return appointmentRepository.save(appointmentEntity);
    }

    public List<AppointmentEntity> saveAllAppointments(List<AppointmentEntity> appointmentEntities) {
        return appointmentRepository.saveAll(appointmentEntities);
    }

    public List<AppointmentEntity> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<AppointmentEntity> updateAppointment(AppointmentEntity appointmentEntity) {
        Optional<AppointmentEntity> appointment = appointmentRepository.findById(appointmentEntity.getId());
        if (appointment.isPresent()) {
            appointment.get().setDate(appointmentEntity.getDate());
            appointment.get().setTime(appointmentEntity.getTime());
            appointment.get().setStatus(appointmentEntity.getStatus());
            appointment.get().setPet(appointmentEntity.getPet());
            appointment.get().setService(appointmentEntity.getService());
            return Optional.of(appointmentRepository.save(appointment.get()));
        } else {
            return Optional.empty();
        }
    }

    public Optional<AppointmentEntity> deleteAppointmentById(Long id) {
        Optional<AppointmentEntity> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            appointmentRepository.deleteById(id);
            return appointment;
        } else {
            return Optional.empty();
        }
    }

    public Page<AppointmentEntity> getAllAppointmentsByFilter(String date,
                                               String time,
                                               String status,
                                               PetEntity pet,
                                               ServiceEntity service,
                                               int page,
                                               int size,
                                               String[] sort) {
        Sort sortable = Sort.by(sort[0]);
        PageRequest pageable = PageRequest.of(page, size, sortable);

        if (date != null) {
            return appointmentRepository.findAllByDate(date, pageable);
        } else if (time != null) {
            return appointmentRepository.findAllByTime(time, pageable);
        } else if (status != null) {
            return appointmentRepository.findAllByStatus(status, pageable);
        } else if (pet != null) {
            return appointmentRepository.findAllByPet(pet, pageable);
        } else if (service != null) {
            return appointmentRepository.findAllByService(service, pageable);
        } else {
            return appointmentRepository.findAll(pageable);
        }
    }
}
