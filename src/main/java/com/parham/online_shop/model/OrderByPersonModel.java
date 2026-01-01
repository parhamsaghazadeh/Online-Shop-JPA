package com.parham.online_shop.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderByPersonModel {
    private String name;
    private String lastName;
    private String paymentMethod;
    private LocalDateTime paymentDate;
    private long quantity;
    private BigDecimal price;
    private LocalDateTime registrationDate;

    public OrderByPersonModel(String name, String lastName, String paymentMethod, LocalDateTime paymentDate, long quantity, BigDecimal price , LocalDateTime registrationDate) {
        this.name = name;
        this.lastName = lastName;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.quantity = quantity;
        this.price = price;
        this.registrationDate = registrationDate;
    }

}
