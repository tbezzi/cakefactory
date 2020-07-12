package com.cakefactory.eshop.model;

import org.springframework.context.annotation.Bean;

import java.util.Map;
import java.util.Set;

public interface Basket {
    void addItem(com.cakefactory.eshop.model.Item item);
    void removeItem(com.cakefactory.eshop.model.Item item);
    int itemNumber();
    Set<Map.Entry<Item, Integer>> items();
    void removeAllItems();
}
