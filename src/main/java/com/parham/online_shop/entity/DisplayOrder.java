package com.parham.online_shop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "display_order")
@Data
public class DisplayOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_id" , nullable = false, foreignKey = @ForeignKey(name = "FK_order_location"))
    private Orders orderId;
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false , foreignKey = @ForeignKey(name = "FK_location_location"))
    private Location locationId;
}
