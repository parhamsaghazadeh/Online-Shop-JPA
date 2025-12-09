package com.parham.online_shop.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "product")
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column (name = "brand" , length = 50, nullable = false)
    private String brand;
    @Column (name = "model" , length = 50, nullable = false)
    private String model;
    @Column(name = "made_in",length = 50, nullable = false)
    private String madeIn;
    @Column (name = "yare_of_menufacture",length = 50, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date yareOfMenuFacture;
    @Column (name = "price" , precision = 10, scale = 2, nullable = false )
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "FK_PRODUCT_CATEGORY_ID"))
    private Category category;
}
