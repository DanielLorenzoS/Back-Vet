package com.vet.repositories;

import com.vet.entities.sales.BillEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, Long> {

    Page<BillEntity> getBillEntitiesByUser_Name(String name, Pageable pageable);

    Page<BillEntity> getBillsByPaymentMethodStartingWith(String paymentMethod, Pageable pageable);

    Page<BillEntity> getBillsByPaymentStatusStartingWith(String paymentStatus, Pageable pageable);
}
