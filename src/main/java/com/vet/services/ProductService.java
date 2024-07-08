package com.vet.services;

import com.vet.entities.sales.ProductEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    ProductEntity saveProduct(ProductEntity productEntity);

    List<ProductEntity> saveProducts(List<ProductEntity> productEntities);

    ProductEntity editProduct(ProductEntity productEntity);

    void deleteProductById(int id);

    ProductEntity getProductById(int id);

    List<ProductEntity> getAllProducts();

    public Page<ProductEntity> getAllProductsByFilter(String name,
                                                   String provider,
                                                    String type,
                                                   String category,
                                                   int page,
                                                   int size,
                                                   String[] sort);
}
