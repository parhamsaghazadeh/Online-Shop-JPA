package com.parham.online_shop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "location")
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title",length = 50, nullable = false)
    private String title;
    @Column(name = "type" , length = 50, nullable = false)
    private String type;
    @Column(name = "open_time" , length = 10, nullable = false)
    private LocalDateTime openTime;
}