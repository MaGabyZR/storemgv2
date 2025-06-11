package com.magabyzr.storemgv2.repositories;

import com.magabyzr.storemgv2.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
  }