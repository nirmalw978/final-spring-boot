package com.devStack.database.controller;

import com.devStack.database.dto.ProductDTO;
import com.devStack.database.entity.Product;
import com.devStack.database.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Product>> getAllProducts (){
        return ResponseEntity.status(200).body(productService.getAllProducts());
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Product> getProductById (@PathVariable Long id){

        Product product= productService.getProductById(id);
        if (product!=null){
            return ResponseEntity.status(200).body(productService.getProductById(id));
    }else {
        return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct (@RequestBody ProductDTO productDTO){
        try {
           return ResponseEntity.status(200).body(productService.createProduct(productDTO));
        }catch (Exception e){
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct (@PathVariable Long id, @RequestBody Product product){
        Product existingProduct = productService.getProductById(id);
        if (existingProduct != null){
            return ResponseEntity.status(200).body(productService.updateProduct(id, product));
        }else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct (@PathVariable Long id){

        Product deletingProduct = productService.getProductById(id);

        if (deletingProduct !=null){
            productService.deleteProduct(id);
            return ResponseEntity.status(200).body("deleted successfully");
        }else {
            return ResponseEntity.status(404).body("product not found");
        }

    }
}
