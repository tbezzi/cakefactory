package com.cakefactory.eshop.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
@Component
@SessionScope
public class InMemoryBasket implements Basket {
    private Map<Item, Integer> basket = new HashMap<>();

    @Override
    public void addItem(com.cakefactory.eshop.model.Item item) {
        Integer counter = basket.getOrDefault(item, 0);
        basket.put(item, counter + 1);
        log.info("added item " + item.getName() + " - size=" + basket.get(item));
    }

    @Override
    public void removeItem(Item item) {
        Integer counter = basket.get(item);
        if (counter != null) {
            if (counter > 1) {
                basket.put(item, counter - 1);
            } else {
                basket.remove(item);
            }
        }
        log.info("removed item " + item.getName() + " - size=" + basket.getOrDefault(item, 0));
    }

    @Override
    public int itemNumber() {
        return basket.values().stream().mapToInt(p -> p).sum();
    }

    public Set<Map.Entry<Item, Integer>> items() {
        return basket.entrySet();
    }

    @Override
    public void removeAllItems() {
        basket.clear();
    }
}
