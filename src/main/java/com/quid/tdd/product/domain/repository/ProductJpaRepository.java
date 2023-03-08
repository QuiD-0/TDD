package com.quid.tdd.product.domain.repository;

import com.quid.tdd.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {

}
