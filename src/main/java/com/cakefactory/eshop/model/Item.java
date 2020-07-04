package com.cakefactory.eshop.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.text.NumberFormat;

@Data
@RequiredArgsConstructor
public class Item {
    private final String id;
    private final String name;
    private final String description;
    private final BigDecimal price;

    public String priceFormatted() {
        return String.format("£ %.2f", price);
    }
}