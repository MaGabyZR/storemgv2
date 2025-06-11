package com.magabyzr.storemgv2.repositories;

import com.magabyzr.storemgv2.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
  //Derived Query Methods for strings, ex.:
  List<Product> findByName(String name);
  List<Product> findByNameLike(String name);
  List<Product> findByNameNotLike(String name);
  List<Product> findByNameContaining(String name);
  List<Product> findByNameNotContaining(String name);
  List<Product> findByNameEndingWith(String name);
  List<Product> findByNameStartingWith(String name);

  //Derived Query Methods for numbers, ex.:
  List<Product> findByPrice(BigDecimal price);
  List<Product> findByPriceGreaterThan(BigDecimal price);
  List<Product> findByPriceGreaterThanEqual(BigDecimal price);
  List<Product> findByPriceLessThan(BigDecimal price);
  List<Product> findByPriceLessThanEqual(BigDecimal price);
  List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

  }