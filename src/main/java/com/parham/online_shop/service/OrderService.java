package com.parham.online_shop.service;

import com.parham.online_shop.entity.Orders;
import com.parham.online_shop.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrderService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public Orders addOrders(Orders orders) {
        return ordersRepository.save(orders);
    }

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Orders getOrderById(Long id) {
        return ordersRepository.findById(id).orElse(null);
    }

    public Orders updateOrders(Orders orders) {
        return ordersRepository.save(orders);
    }

    public void deleteOrders(Long id) {
        ordersRepository.deleteById(id);
    }
}
