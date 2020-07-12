package com.cakefactory.eshop.controller;

import com.cakefactory.eshop.entity.Item;
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
public class ApplicationController {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    Basket basket;

    @GetMapping("/")
    public String index(Model model) {
        log.info("index method");

        List<Item> entities = new ArrayList<>();
        itemRepository.findAll().forEach(entities::add);
        List<com.cakefactory.eshop.model.Item> items = entities.stream().map(
                item -> new com.cakefactory.eshop.model.Item(item.getId(),
                        item.getName(), item.getName(), item.getPrice()))
                .collect(Collectors.toList());
        model.addAttribute("items", items);
        model.addAttribute("basket", basket);
        return "index";
    }

    @PostMapping("/basket")
    public String addBasket(com.cakefactory.eshop.model.Item item) {
        log.info("Item added: " + item.toString());
        basket.addItem(item);
        return "redirect:/";
    }

    @PostMapping("/basket/delete")
    public String removeFromBasket(com.cakefactory.eshop.model.Item item) {
        log.info("Item removed: " + item.toString());
        basket.removeItem(item);
        return "redirect:/basket";
    }

    @GetMapping("/basket")
    public String basket(Model model) {
        log.info("basket");
        model.addAttribute("basket", basket);
        model.addAttribute("items", basket.items());
        return "basket";
    }
}
