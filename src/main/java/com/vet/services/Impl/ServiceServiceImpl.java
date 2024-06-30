package com.vet.services.Impl;

import com.vet.entities.sales.ServiceEntity;
import com.vet.repositories.ServiceRepository;
import com.vet.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<ServiceEntity> findAllServices() {
        return serviceRepository.findAll();
    }

    public ServiceEntity saveService(ServiceEntity service) {
        return serviceRepository.save(service);
    }

    public ServiceEntity updateService(ServiceEntity service) {
        return serviceRepository.save(service);
    }

    public Optional<ServiceEntity> deleteService(Long id) {
        Optional<ServiceEntity> service = serviceRepository.findById(id);
        service.ifPresent(value -> serviceRepository.delete(value));
        return service;
    }

    public Optional<ServiceEntity> findServiceById(Long id) {
        return serviceRepository.findById(id);
    }
}
