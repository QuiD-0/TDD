package com.quid.tdd.order.usecase.fake;

import com.quid.tdd.order.domain.Order;
import com.quid.tdd.order.repo.OrderRepository;
import java.util.HashMap;
import java.util.Map;

public class FakeOrderRepository implements OrderRepository {

    private Map<Long, Order> persistence = new HashMap<>();

    @Override
    public Order createOrder(Order order) {
        persistence.put(1L, order);
        return order;
    }
}
