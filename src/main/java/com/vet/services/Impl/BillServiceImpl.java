package com.vet.services.Impl;

import com.vet.entities.BillEntity;
import com.vet.repositories.BillRepository;
import com.vet.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillRepository billRepository;

    public List<BillEntity> getAllBills() {
        return billRepository.findAll();
    }

    public Optional<BillEntity> getBillById(Long id) {
        return billRepository.findById(id);
    }

    public BillEntity createBill(BillEntity bill) {
        return billRepository.save(bill);
    }

    public Optional<BillEntity> updateBill(Long id, BillEntity bill) {
        Optional<BillEntity> billOptional = billRepository.findById(id);
        if (billOptional.isPresent()) {
            bill.setId(id);
            return Optional.of(billRepository.save(bill));
        } else {
            return Optional.empty();
        }
    }

    public Optional<BillEntity> deleteBill(Long id) {
        Optional<BillEntity> bill = billRepository.findById(id);
        if (bill.isPresent()) {
            billRepository.deleteById(id);
            return bill;
        } else {
            return Optional.empty();
        }
    }

    public List<BillEntity> getBillsByUserId(Long userId) {
        return billRepository.getBillsByUserId(userId);
    }
}
