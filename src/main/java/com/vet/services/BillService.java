package com.vet.services;

import com.vet.entities.BillEntity;

import java.util.List;
import java.util.Optional;

public interface BillService {

    List<BillEntity> getAllBills();

    Optional<BillEntity> getBillById(Long id);

    BillEntity createBill(BillEntity bill);

    Optional<BillEntity> updateBill(Long id, BillEntity bill);

    Optional<BillEntity> deleteBillById(Long id);

    List<BillEntity> getBillsByUserId(Long userId);

}
