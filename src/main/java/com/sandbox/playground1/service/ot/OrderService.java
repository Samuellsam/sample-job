package com.sandbox.playground1.service.ot;

import com.sandbox.playground1.repository.ot.OrderRepository;
import com.sandbox.playground1.model.ot.CustomerOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<CustomerOrder> findAllOrderByCustomerId(int customerId) {
        return orderRepository.findAllOrderByCustomerId(customerId);
    }
}
