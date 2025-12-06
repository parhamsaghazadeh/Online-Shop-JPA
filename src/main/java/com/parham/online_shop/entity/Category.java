package com.parham.online_shop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "category", uniqueConstraints = {
        @UniqueConstraint(name = "UK_CATEGORY_NAME", columnNames = {"title"}),
        @UniqueConstraint(name = "UK_CATEGORY_CODE", columnNames = {"code"})
})
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false, length = 50)
    private String title;
    @Column(name = "code", nullable = false, length = 50)
    private String code;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
