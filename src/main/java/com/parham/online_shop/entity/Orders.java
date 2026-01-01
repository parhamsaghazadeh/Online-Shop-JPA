package com.parham.online_shop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "person_id",nullable = false , foreignKey = @ForeignKey(name ="FK_order_person"))
    private Person person;
    @Column(name = "payment_method", nullable = false ,length = 50)
    private String paymentMethod;
    @Column(name = "payment_date",nullable = false)
    private LocalDateTime paymentDate;
    @OneToMany(mappedBy = "orders")
    private List<OrderItem> orderItems;
}
