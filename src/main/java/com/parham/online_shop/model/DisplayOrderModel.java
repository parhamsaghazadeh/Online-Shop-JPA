package com.parham.online_shop.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class DisplayOrderModel {
    // person
    private String personName;
    private String personLastName;
    private Date personBirthday;

    // category
    private String categoryTitle;

    // product
    private String productBrand;
    private String productModel;
    private String productMadeIn;
    private Date productYear;
    private String productName;
    private BigDecimal productPrice;

    // order
    private String paymentMethod;
    private LocalDateTime paymentDate;

    // order item
    private long orderQuantity;
    private BigDecimal orderItemPrice;

    // registration
    private LocalDateTime registrationDate;

    // location
    private String locationTitle;
    private String locationType;
    private LocalDateTime locationOpenTime;  // 👈 LocalTime

    public DisplayOrderModel(
            String personName,
            String personLastName,
            Date personBirthday,
            String categoryTitle,
            String productBrand,
            String productModel,
            String productMadeIn,
            Date productYear,
            String productName,
            BigDecimal productPrice,
            String paymentMethod,
            LocalDateTime paymentDate,
            long orderQuantity,
            BigDecimal orderItemPrice,
            LocalDateTime registrationDate,
            String locationTitle,
            String locationType,
            LocalDateTime locationOpenTime
    ) {
        this.personName = personName;
        this.personLastName = personLastName;
        this.personBirthday = personBirthday;
        this.categoryTitle = categoryTitle;
        this.productBrand = productBrand;
        this.productModel = productModel;
        this.productMadeIn = productMadeIn;
        this.productYear = productYear;
        this.productName = productName;
        this.productPrice = productPrice;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.orderQuantity = orderQuantity;
        this.orderItemPrice = orderItemPrice;
        this.registrationDate = registrationDate;
        this.locationTitle = locationTitle;
        this.locationType = locationType;
        this.locationOpenTime = locationOpenTime;
    }

}
