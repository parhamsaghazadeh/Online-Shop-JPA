package com.parham.online_shop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "order_location")
@Data
public class OrderLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    @JoinColumn(name = "order_id" , nullable = false, foreignKey = @ForeignKey(name = "FK_order_location"))
    private Orders orderId;
    @ManyToMany
    @JoinColumn(name = "location_id", nullable = false , foreignKey = @ForeignKey(name = "FK_order_locatio_id"))
    private Location locationId;

}
