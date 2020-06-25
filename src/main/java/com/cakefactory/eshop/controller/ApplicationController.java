package com.cakefactory.eshop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class ApplicationController {

    @RequestMapping("/")
    public String index(Model model) {
        log.info("index method");
        return "index";
    }
}
