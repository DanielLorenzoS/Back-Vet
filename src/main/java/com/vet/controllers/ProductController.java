package com.vet.controllers;

import com.vet.entities.sales.ProductEntity;
import com.vet.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<ProductEntity>> getProductsByFilter(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String provider,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name,asc") String[] sort) {
        return ResponseEntity.ok(productService.getAllProductsByFilter(name, provider, type, category, page, size, sort));
    }

    @PostMapping
    public ResponseEntity<ProductEntity> saveProduct(@RequestBody ProductEntity productEntity) {
        return ResponseEntity.ok(productService.saveProduct(productEntity));
    }

    @PostMapping("/all")
    public ResponseEntity<List<ProductEntity>> saveProducts(@RequestBody List<ProductEntity> productEntities) {
        return ResponseEntity.ok(productService.saveProducts(productEntities));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> editProduct(@RequestBody ProductEntity productEntity) {
        return ResponseEntity.ok(productService.editProduct(productEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable int id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }
}
