package me.cetauri.springboot.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class SampleController {
    @PostConstruct
    public void init(){
        System.out.println("inintttt");
    }

    @GetMapping("/test")
    public String test(){
        System.out.println("------- test -------");
        return "text";
    }
}
