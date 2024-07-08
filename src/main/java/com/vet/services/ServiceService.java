package com.vet.services;

import com.vet.entities.sales.ServiceEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ServiceService {

    List<ServiceEntity> findAllServices();

    ServiceEntity saveService(ServiceEntity service);

    List<ServiceEntity> saveServices(List<ServiceEntity> services);

    ServiceEntity updateService(ServiceEntity service);

    Optional<ServiceEntity> deleteService(Long id);

    Optional<ServiceEntity> findServiceById(Long id);

    Page<ServiceEntity> findAllServicesByFilter(String name, String description, String category, int page, int size, String[] sort);

}
