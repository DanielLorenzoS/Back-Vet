package com.vet.controllers;

import com.vet.entities.pets.AppointmentEntity;
import com.vet.entities.pets.PetEntity;
import com.vet.entities.sales.ServiceEntity;
import com.vet.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public ResponseEntity<List<AppointmentEntity>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AppointmentEntity>> getAppointmentById(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
    }

    @PostMapping
    public ResponseEntity<AppointmentEntity> addAppointment(@RequestBody AppointmentEntity appointmentEntity) {
        return ResponseEntity.ok(appointmentService.saveAppointment(appointmentEntity));
    }

    @PostMapping("/all")
    public ResponseEntity<List<AppointmentEntity>> addAllAppointments(@RequestBody List<AppointmentEntity> appointmentEntities) {
        return ResponseEntity.ok(appointmentService.saveAllAppointments(appointmentEntities));
    }

    @PutMapping
    public ResponseEntity<Optional<AppointmentEntity>> updateAppointment(@RequestBody AppointmentEntity appointmentEntity) {
        return ResponseEntity.ok(appointmentService.updateAppointment(appointmentEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<AppointmentEntity>> deleteAppointmentById(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.deleteAppointmentById(id));
    }

    @GetMapping("filter")
    public ResponseEntity<Page<AppointmentEntity>> getAllAppointments(
            @RequestParam(required = false) String date,
            @RequestParam(required = false) String time,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) PetEntity pet,
            @RequestParam(required = false) ServiceEntity service,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "date,asc") String[] sort) {
        return ResponseEntity.ok(appointmentService.getAllAppointmentsByFilter(date, time, status, pet, service, page, size, sort));
    }
}
