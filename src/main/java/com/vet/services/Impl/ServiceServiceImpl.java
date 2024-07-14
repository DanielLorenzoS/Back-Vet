package com.vet.services.Impl;

import com.vet.entities.sales.ServiceEntity;
import com.vet.repositories.ServiceRepository;
import com.vet.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<ServiceEntity> findAllServices() {
        return serviceRepository.findAll();
    }

    public ServiceEntity saveService(ServiceEntity service) {
        return serviceRepository.save(service);
    }

    public List<ServiceEntity> saveServices(List<ServiceEntity> services) {
        return serviceRepository.saveAll(services);
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

    public Page<ServiceEntity> findAllServicesByFilter(String name, String description, String category, int page, int size, String[] sort) {

        Page<ServiceEntity> listServices;
        Sort sortable = Sort.by(sort[0]);
        PageRequest pageable = PageRequest.of(page, size, sortable);

        if (name != null) {
            listServices = serviceRepository.findAllByNameStartingWith(name, pageable);
        } else if (description != null) {
            listServices = serviceRepository.findAllByDescriptionStartingWith(description, pageable);
        } else if (category != null) {
            listServices = serviceRepository.findAllByCategoryStartingWith(category, pageable);
        } else {
            listServices = serviceRepository.findAll(pageable);
        }
        return listServices;
    }
}
