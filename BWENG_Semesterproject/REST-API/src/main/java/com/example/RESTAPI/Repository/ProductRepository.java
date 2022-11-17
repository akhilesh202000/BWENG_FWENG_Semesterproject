package com.example.RESTAPI.Repository;

import com.example.RESTAPI.Entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
