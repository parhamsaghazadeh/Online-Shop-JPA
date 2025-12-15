package com.parham.online_shop.controller;

import com.parham.online_shop.entity.Orders;
import com.parham.online_shop.model.Converter;
import com.parham.online_shop.model.OrderModel;
import com.parham.online_shop.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private Converter converter;

    @GetMapping
    public ResponseEntity<List<OrderModel>> getAllOrders() {
        try {
            List<Orders> orders = orderService.getAllOrders();
            List<OrderModel> orderModels = orders.stream()
                    .map(converter::toModelOrder)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(orderModels);
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/id")
    public ResponseEntity<OrderModel> getOrderById(Long id) {
        try {
            Orders order = orderService.getOrderById(id);
            OrderModel orderModel = converter.toModelOrder(order);
            return ResponseEntity.ok(orderModel);
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Orders> addOrder(@RequestBody Orders orders) {
        try {
            Orders addOrders = orderService.addOrders(orders);
            return ResponseEntity.ok(addOrders);
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<OrderModel> updateOrder(@RequestBody Orders orders) {
        try {
            Orders updateOrders = orderService.updateOrders(orders);
            return ResponseEntity.ok(converter.toModelOrder(updateOrders));
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteOrderById(Long id) {
        try {
            orderService.deleteOrders(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
