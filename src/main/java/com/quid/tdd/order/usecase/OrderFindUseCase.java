package com.quid.tdd.order.usecase;

import com.quid.tdd.order.domain.Order;
import com.quid.tdd.order.repo.OrderRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface OrderFindUseCase {

    Order findOrder(long id);

    List<Order> findOrder(String ordererName);

    @Service
    @RequiredArgsConstructor
    class OrderFindUseCaseImpl implements OrderFindUseCase {
        private final OrderRepository orderRepository;

        @Override
        public Order findOrder(long id) {
            return orderRepository.findById(id);
        }

        @Override
        public List<Order> findOrder(String ordererName) {
            return orderRepository.findByOrdererName(ordererName);
        }
    }
}
