package com.cakefactory.eshop.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Address {
    private String address1;
    private String address2;
    private String zipcode;
}
