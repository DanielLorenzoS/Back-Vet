package com.vet.services;

import com.vet.entities.BillEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BillService {

    List<BillEntity> getAllBills();

    Optional<BillEntity> getBillById(Long id);

    BillEntity createBill(BillEntity bill);

    Optional<BillEntity> updateBill(Long id, BillEntity bill);

    Optional<BillEntity> deleteBillById(Long id);

    List<BillEntity> getBillsByUserId(Long userId);

    public Page<BillEntity> getAllBillsByFilter(String paymentMethod,
                                                String paymentStatus,
                                                int page,
                                                int size,
                                                String[] sort);

}
