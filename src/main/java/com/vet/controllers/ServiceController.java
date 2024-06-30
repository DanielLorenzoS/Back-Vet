package com.vet.controllers;

import com.vet.entities.sales.ServiceEntity;
import com.vet.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping("/{id}")
    public ServiceEntity updateService(@RequestBody ServiceEntity service) {
        return serviceService.updateService(service);
    }

    @DeleteMapping("/{id}")
    public ServiceEntity deleteService(@PathVariable Long id) {
        return serviceService.deleteService(id).orElse(null);
    }
}
