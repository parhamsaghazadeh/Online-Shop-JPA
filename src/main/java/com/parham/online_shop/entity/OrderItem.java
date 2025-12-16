package com.parham.online_shop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "order_item")
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false, foreignKey = @ForeignKey(name = "FK_order_item_order"))
    private Orders orders;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "FK_order_product"))
    private Product product;
    @Column(name = "quantity", nullable = false, length = 50)
    private long quantity;
    @Column(name = "price", nullable = false, length = 50)
    private BigDecimal price;
}
