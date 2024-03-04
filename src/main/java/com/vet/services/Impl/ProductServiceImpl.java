package com.vet.services.Impl;

import com.vet.entities.ProductEntity;
import com.vet.entities.UserEntity;
import com.vet.repositories.ProductRepository;
import com.vet.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductEntity saveProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
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
        Sort sortable = Sort.by(sort[0]);
        PageRequest pageable = PageRequest.of(page, size, sortable);
        if (name != null) {
            return productRepository.findAllByNameStartingWith(name, pageable);
        } else if (provider != null) {
            return productRepository.findAllByProviderStartingWith(provider, pageable);
        } else if (type != null) {
            return productRepository.findAllByTypeStartingWith(type, pageable);
        } else if (category != null) {
            return productRepository.findAllByCategoryStartingWith(category, pageable);
        } else {
            return productRepository.findAll(pageable);
        }
    }
}
