package com.cakefactory.eshop.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Slf4j
@Component
@SessionScope
public class InMemoryBasket implements Basket {
    private int size;

    @Override
    public void addItem() {
        size++;
        log.info("added item - size=" + size);
    }

    @Override
    public int itemNumber() {
        return size;
    }
}
