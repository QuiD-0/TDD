package com.quid.tdd.order.repo;

import com.quid.tdd.order.domain.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<Order, Long> {

    List<Order> findByOrdererName(String ordererName);
}
