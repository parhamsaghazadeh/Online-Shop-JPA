package com.parham.online_shop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "person")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "lastname", length = 50, nullable = false)
    private String lastName;
    @Column(name = "birthday", length = 50, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Column(name = "user_id",length = 50, nullable = false)
    private long userId;
    @ManyToOne
    @JoinColumn(name = "gender_id", foreignKey = @ForeignKey(name = "Fk_Person_gender"))
    private Gender genderId;
    @ManyToOne
    @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "FK_Person_Role"))
    private Role roleId;

}
