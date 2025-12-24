package com.parham.online_shop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_registration")
@Data
public class ProductRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "person_id" , nullable = false , foreignKey = @ForeignKey(name = "FK_register_person"))
    private Person person;
    @ManyToOne
    @JoinColumn(name = "product_id" , nullable = false , foreignKey = @ForeignKey(name = "FK_register_product"))
    private Product product;
    @Column(name ="registration_date" , nullable = false)
    private LocalDateTime registrationDate;
}
