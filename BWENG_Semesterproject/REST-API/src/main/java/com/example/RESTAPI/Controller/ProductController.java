package com.example.RESTAPI.Controller;

import com.example.RESTAPI.Entity.Auction;
import com.example.RESTAPI.Entity.Product;
import com.example.RESTAPI.Repository.ProductRepository;
import com.example.RESTAPI.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProductController {
    @Autowired
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @CrossOrigin
    @GetMapping("/products")
    public @ResponseBody Iterable<Product> getAuctions() {
        return productRepository.findAll();
    }

    @CrossOrigin
    @PostMapping("/products")
    public @ResponseBody Product postAuction(@RequestBody @Valid Product newProduct) {
        return productRepository.save(newProduct);
    }
}
