package com.quid.tdd.product.refactor.respository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReadRepository extends JpaRepository<ProductReadEntity, Long> {
}
