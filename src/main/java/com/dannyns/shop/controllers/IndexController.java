package com.dannyns.shop.controllers;

import com.dannyns.shop.annotations.ThymeleafLayout;
import com.dannyns.shop.services.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private IndexService indexService;

    @Autowired
    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    @ThymeleafLayout("login")
    public String login() {
        return "login";
    }
}
