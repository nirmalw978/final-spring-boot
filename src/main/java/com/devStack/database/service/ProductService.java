package com.devStack.database.service;

import com.devStack.database.entity.Product;
import com.devStack.database.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts();
    Product createProduct(ProductDTO productDTO);
    Product getProductById(Long product_id);

    Product updateProduct(Long product_id , Product product);
    void deleteProduct(Long product_id);
}
