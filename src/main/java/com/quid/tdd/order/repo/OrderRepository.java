package com.quid.tdd.order.repo;


import com.quid.tdd.order.domain.Order;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface OrderRepository {


    Order createOrder(Order order);

    Order findById(long id);

    List<Order> findByOrdererName(String ordererName);

    @Repository
    @RequiredArgsConstructor
    class OrderRepositoryImpl implements OrderRepository {

        private final OrderJpaRepository orderJpaRepository;

        @Override
        public Order createOrder(Order order) {
            return orderJpaRepository.save(order);
        }

        @Override
        public Order findById(long id) {
            return orderJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        }

        @Override
        public List<Order> findByOrdererName(String ordererName) {
            return orderJpaRepository.findByOrdererName(ordererName);
        }
    }
}
