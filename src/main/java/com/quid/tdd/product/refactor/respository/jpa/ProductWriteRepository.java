package com.quid.tdd.product.refactor.respository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductWriteRepository extends JpaRepository<ProductWriteEntity, Long> {
}
