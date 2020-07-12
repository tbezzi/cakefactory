package com.cakefactory.eshop.model;

import org.springframework.context.annotation.Bean;

public interface Basket {
    void addItem();
    int itemNumber();
}
