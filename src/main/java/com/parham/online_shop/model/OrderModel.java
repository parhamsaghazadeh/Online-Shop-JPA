package com.parham.online_shop.model;

import com.parham.online_shop.entity.DisplayOrder;

import java.util.List;

public class OrderModel {
    private long id;
    private long personId;
    private String paymentMethod;
    private String paymentDate;
    public List<OrderItemModel> orderItems;
    private List<DisplayOrderModel> displayOrderModels;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public List<OrderItemModel> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemModel> orderItems) {
        this.orderItems = orderItems;
    }

    public List<DisplayOrderModel> getDisplayOrderModels() {
        return displayOrderModels;
    }

    public void setDisplayOrderModels(List<DisplayOrderModel> displayOrderModels) {
        this.displayOrderModels = displayOrderModels;
    }
}
