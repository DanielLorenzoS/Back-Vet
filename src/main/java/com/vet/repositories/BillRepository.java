package com.vet.repositories;

import com.vet.entities.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, Long> {

    // List<BillEntity> getBillsByUserId(Long userId);
    List<BillEntity> getBillsByUserId(Long userId);
}
