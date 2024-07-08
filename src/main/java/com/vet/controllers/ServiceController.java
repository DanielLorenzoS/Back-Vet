package com.vet.controllers;

import com.vet.entities.sales.ServiceEntity;
import com.vet.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping
    public List<ServiceEntity> findAllServices() {
        return serviceService.findAllServices();
    }

    @GetMapping("/{id}")
    public ServiceEntity findServiceById(Long id) {
        return serviceService.findServiceById(id).orElse(null);
    }

    @PostMapping
    public ServiceEntity saveService(@RequestBody ServiceEntity service) {
        return serviceService.saveService(service);
    }

    @PostMapping("/all")
    public List<ServiceEntity> saveServices(@RequestBody List<ServiceEntity> services) {
        return serviceService.saveServices(services);
    }

    @PutMapping("/{id}")
    public ServiceEntity updateService(@RequestBody ServiceEntity service) {
        return serviceService.updateService(service);
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<ServiceEntity>> findAllServicesByFilter(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name,asc") String[] sort) {
        return ResponseEntity.ok(serviceService.findAllServicesByFilter(name, description, category, page, size, sort));
    }

    @DeleteMapping("/{id}")
    public ServiceEntity deleteService(@PathVariable Long id) {
        return serviceService.deleteService(id).orElse(null);
    }
}
