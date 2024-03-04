package com.vet.repositories;

import com.vet.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    Page<ProductEntity> findAllByNameStartingWith(String name, Pageable pageable);

    Page<ProductEntity> findAllByProviderStartingWith(String provider, Pageable pageable);

    Page<ProductEntity> findAllByTypeStartingWith(String type, Pageable pageable);

    Page<ProductEntity> findAllByCategoryStartingWith(String category, Pageable pageable);
}
