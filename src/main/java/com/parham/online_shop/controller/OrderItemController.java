package com.parham.online_shop.controller;

import com.parham.online_shop.entity.OrderItem;
import com.parham.online_shop.model.Converter;
import com.parham.online_shop.model.OrderItemModel;
import com.parham.online_shop.service.OrderItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/orderItem")
@RestController
@Slf4j
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private Converter converter;

    @GetMapping
    public ResponseEntity<List<OrderItemModel>> allOrderItems() {
        try {
            List<OrderItem> orderItems = orderItemService.getAllOrderItems();
            List<OrderItemModel> orderItemModels = orderItems.stream()
                    .map(converter::toModelOrderItem)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(orderItemModels);
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/id")
    public ResponseEntity<OrderItemModel> getOrderItemById(Long id) {
        try {
            OrderItem orderItem = orderItemService.getOrderItemById(id);
            OrderItemModel orderItemModel = converter.toModelOrderItem(orderItem);
            return ResponseEntity.ok(orderItemModel);
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<OrderItem> updateOrderItem(OrderItem orderItem) {
        try {
            OrderItem updatedOrderItem = orderItemService.updateOrderItem(orderItem);
            OrderItemModel orderItemModel = converter.toModelOrderItem(updatedOrderItem);
            return ResponseEntity.ok(updatedOrderItem);
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        try {
            OrderItem addOrderItem = orderItemService.addOrderItem(orderItem);
            return ResponseEntity.status(HttpStatus.CREATED).body(addOrderItem);
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping
    public ResponseEntity<String> deleteOrderItemById(Long id) {
        try {
            orderItemService.deleteOrderItemById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
