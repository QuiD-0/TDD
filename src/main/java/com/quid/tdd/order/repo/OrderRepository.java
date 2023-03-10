package com.quid.tdd.order.repo;


import com.quid.tdd.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface OrderRepository {


    Order createOrder(Order order);

    @Repository
    @RequiredArgsConstructor
    class OrderRepositoryImpl implements OrderRepository{

        private final OrderJpaRepository orderJpaRepository;

        @Override
        public Order createOrder(Order order) {
            return orderJpaRepository.save(order);
        }
    }
}
