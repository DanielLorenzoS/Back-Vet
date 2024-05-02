package com.vet.services;

import com.vet.entities.sales.BillEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BillService {

    List<BillEntity> getAllBills();

    Optional<BillEntity> getBillById(Long id);

    BillEntity createBill(BillEntity bill);

    Optional<BillEntity> updateBill(Long id, BillEntity bill);

    Optional<BillEntity> deleteBillById(Long id);

    public Page<BillEntity> getBillsByUserId(String name,
                                             int page,
                                             int size,
                                             String[] sort);

    public Page<BillEntity> getAllBillsByFilter(String paymentMethod,
                                                String paymentStatus,
                                                int page,
                                                int size,
                                                String[] sort);

}
