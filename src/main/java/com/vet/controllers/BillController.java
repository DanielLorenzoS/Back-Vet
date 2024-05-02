package com.vet.controllers;

import com.vet.entities.sales.BillEntity;
import com.vet.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillService billService;

    @GetMapping
    public ResponseEntity<List<BillEntity>> getAllBills() {
        return ResponseEntity.ok(billService.getAllBills());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BillEntity>> getBillById(@PathVariable int id) {
        return ResponseEntity.ok(billService.getBillById((long) id));
    }

    @GetMapping("/user")
    public ResponseEntity<Page<BillEntity>> getBillsByUserId(@RequestParam(required = false) String name,
                                                             @RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "5") int size,
                                                            @RequestParam(defaultValue = "createdAt,asc") String[] sort) {
        return ResponseEntity.ok(billService.getBillsByUserId(name, page, size, sort));
    }

    @PostMapping
    public ResponseEntity<BillEntity> saveBill(@RequestBody BillEntity billEntity) {
        return ResponseEntity.ok(billService.createBill(billEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<BillEntity>> editBill(@PathVariable Long id, @RequestBody BillEntity billEntity) {
        return ResponseEntity.ok(billService.updateBill(id, billEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBillById(@PathVariable int id) {
        billService.deleteBillById((long) id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<BillEntity>> getBillsByFilter(
            @RequestParam(required = false) String paymentMethod,
            @RequestParam(required = false) String paymentStatus,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "createdAt,asc") String[] sort) {
        return ResponseEntity.ok(billService.getAllBillsByFilter(paymentMethod, paymentStatus, page, size, sort));
    }
}
