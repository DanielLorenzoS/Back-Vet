package com.vet.repositories;

import com.vet.entities.BillEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, Long> {

    List<BillEntity> getBillsByUserId(Long userId);

    Page<BillEntity> getBillsByPaymentMethod(String paymentMethod, Pageable pageable);

    Page<BillEntity> getBillsByPaymentStatus(String paymentStatus, Pageable pageable);
}
