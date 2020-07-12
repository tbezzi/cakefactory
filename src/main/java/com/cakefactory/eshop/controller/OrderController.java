package com.cakefactory.eshop.controller;

import com.cakefactory.eshop.entity.Item;
import com.cakefactory.eshop.model.Address;
import com.cakefactory.eshop.model.Basket;
import com.cakefactory.eshop.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class OrderController {

    @Autowired
    Basket basket;

    @PostMapping("/order")
    public String completeOrder(Address address) {
        log.info("Received order from order " + address);
        basket.items().stream().forEach(entry-> log.info(entry.getKey().getName()+" qty. "+entry.getValue()));
        basket.removeAllItems();
        return "redirect:/";
    }

}
