package com.magabyzr.storemgv2.repositories;

import com.magabyzr.storemgv2.entities.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductCriteriaRepository {
    List<Product> findProductsByCriteria(String name, BigDecimal minPrice, BigDecimal maxPrice);
}
