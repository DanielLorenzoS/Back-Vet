package com.vet.services;

import com.vet.entities.sales.ServiceEntity;

import java.util.List;
import java.util.Optional;

public interface ServiceService {

    List<ServiceEntity> findAllServices();

    ServiceEntity saveService(ServiceEntity service);

    ServiceEntity updateService(ServiceEntity service);

    Optional<ServiceEntity> deleteService(Long id);

    Optional<ServiceEntity> findServiceById(Long id);

}
