package com.devStack.database.service;
import com.devStack.database.entity.Catagory;
import com.devStack.database.entity.Product;
import com.devStack.database.dto.ProductDTO;
import com.devStack.database.repository.CatagoryRepository;
import com.devStack.database.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CatagoryRepository catagoryRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(ProductDTO productDTO) {
        Catagory catagory= catagoryRepository.findById(productDTO.getCatagoryId()).orElse(null);
        if (catagory!=null){
            Product product = new Product();
            product.setProduct_name(productDTO.getProduct_name());
            product.setImage(productDTO.getImage());
            product.setNew_price(productDTO.getNew_price());
            product.setOld_price(productDTO.getOld_price());
            product.setCatagory(catagory);
            return productRepository.save(product);
        }else{
            return null;
        }
    }

    @Override
    public Product getProductById(Long product_id) {
        return productRepository.findById(product_id).orElse(null);
    }

    @Override
    public Product updateProduct(Long product_id, Product product) {
        Product existingProduct = productRepository.findById(product_id).orElse(null);
        if (existingProduct!=null){

            existingProduct.setProduct_name(product.getProduct_name());
            existingProduct.setImage(product.getImage());
            existingProduct.setNew_price(product.getNew_price());
            existingProduct.setOld_price(product.getOld_price());

            return productRepository.save(existingProduct);
        }else {
            return null;
        }
    }

    @Override
    public void deleteProduct(Long product_id) {
        productRepository.deleteById(product_id);
    }
}
