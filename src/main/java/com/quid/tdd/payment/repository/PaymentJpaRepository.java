package com.quid.tdd.payment.repository;

import com.quid.tdd.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentJpaRepository extends JpaRepository<Payment, Long>{

}
