package com.cakefactory.eshop.controller;

import com.cakefactory.eshop.entity.Item;
import com.cakefactory.eshop.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class ApplicationController {

    @Autowired
    ItemRepository itemRepository;

    @RequestMapping("/")
    public String index(Model model) {
        log.info("index method");

        List<Item> entities = new ArrayList<>();
        itemRepository.findAll().forEach(entities::add);
        List<com.cakefactory.eshop.model.Item> items= entities.stream().map(
                item -> new com.cakefactory.eshop.model.Item("aaa",
                        item.getName(), item.getName(), item.getPrice()))
                .collect(Collectors.toList());

        model.addAttribute("items", items);
        return "index";
    }
}
