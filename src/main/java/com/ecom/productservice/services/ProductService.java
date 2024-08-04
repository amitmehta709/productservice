package com.ecom.productservice.services;

import com.ecom.productservice.exception.NotFoundException;
import com.ecom.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws NotFoundException;
    List<Product> getAllProducts();
    Product updateProduct(Long id, Product product) throws NotFoundException;
    Product replaceProduct();
    Product createProduct(Product product);
    Product deleteProduct();
}
