package com.parham.online_shop.model;

import com.parham.online_shop.entity.*;

import java.util.Date;
import java.util.List;

public class PersonModel {
    private long id;
    private String name;
    private String lastName;
    private String birthday;
    private long personId;
    private String phone;
    private Long age;
    private User userId;
    private Gender genderId;
    private Role roleId;
    private AddressModel address;
    private List<OrderModel> ordersList;
    private List<ProductRegisterModel> productRegisterModels;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Gender getGenderId() {
        return genderId;
    }

    public void setGenderId(Gender genderId) {
        this.genderId = genderId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public List<OrderModel> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<OrderModel> ordersList) {
        this.ordersList = ordersList;
    }

    public List<ProductRegisterModel> getProductRegisterModels() {
        return productRegisterModels;
    }

    public void setProductRegisterModels(List<ProductRegisterModel> productRegisterModels) {
        this.productRegisterModels = productRegisterModels;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }
}

