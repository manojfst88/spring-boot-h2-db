package com.archt.controller;

import com.archt.entity.Product;
import com.archt.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/getAllProduct")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable int id) {
        return productRepository.findById(id).get();
    }

    @PostMapping("/saveProduct")
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product updatedProduct) {
        Product  product = productRepository.findById(updatedProduct.getId()).get();
        product.setProductName(updatedProduct.getProductName());
        product.setManufacturerName(updatedProduct.getManufacturerName());
        product.setDistributer(updatedProduct.getDistributer());
        product.setGstNo(updatedProduct.getGstNo());
        product.setDescription(updatedProduct.getDescription());
        return productRepository.save(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id) {
        productRepository.deleteById(id);
        return "Product deleted successfully";
    }

}
