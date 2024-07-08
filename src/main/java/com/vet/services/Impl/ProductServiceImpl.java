package com.vet.services.Impl;

import com.vet.entities.sales.ProductEntity;
import com.vet.repositories.ProductRepository;
import com.vet.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductEntity saveProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    public List<ProductEntity> saveProducts(List<ProductEntity> productEntities) {
        return productRepository.saveAll(productEntities);
    }

    public ProductEntity editProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }

    public ProductEntity getProductById(int id) {
        return productRepository.findById(id).get();
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public Page<ProductEntity> getAllProductsByFilter(String name,
                                                String provider,
                                                String type,
                                                String category,
                                                int page,
                                                int size,
                                                String[] sort) {
        Page<ProductEntity> listProducts;
        Sort sortable = Sort.by(sort[0]);
        PageRequest pageable = PageRequest.of(page, size, sortable);

        if (name != null) {
            listProducts = productRepository.findAllByNameStartingWith(name, pageable);
        } else if (provider != null) {
            listProducts = productRepository.findAllByProviderStartingWith(provider, pageable);
        } else if (type != null) {
            listProducts = productRepository.findAllByTypeStartingWith(type, pageable);
        } else if (category != null) {
            listProducts = productRepository.findAllByCategoryStartingWith(category, pageable);
        } else {
            listProducts = productRepository.findAll(pageable);
        }
        return listProducts;
    }
}
