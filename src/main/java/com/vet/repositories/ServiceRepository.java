package com.vet.repositories;

import com.vet.entities.sales.ServiceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {

    Page<ServiceEntity> findAllByNameStartingWith(String name, Pageable pageable);

    Page<ServiceEntity> findAllByDescriptionStartingWith(String type, Pageable pageable);

    Page<ServiceEntity> findAllByCategoryStartingWith(String category, Pageable pageable);
}
