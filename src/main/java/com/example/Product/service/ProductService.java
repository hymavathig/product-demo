package com.example.Product.service;


import com.example.Product.model.Product;
import com.example.Product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProducts(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    public Product updateProduct(Long id, Product productDetails){
        Product p = productRepository.findById(id).orElseThrow(() -> new RuntimeException ("Product not found"));
        p.setQuantity(productDetails.getQuantity());
        p.setPrice(productDetails.getPrice());
        return productRepository.save(p);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }


}
