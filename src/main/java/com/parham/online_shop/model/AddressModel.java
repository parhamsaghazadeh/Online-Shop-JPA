package com.parham.online_shop.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
public class AddressModel {
    private String city;
    private String street;
    private String zipcode;
}
