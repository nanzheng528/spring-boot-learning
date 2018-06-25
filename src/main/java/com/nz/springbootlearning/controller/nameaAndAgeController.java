package com.nz.springbootlearning.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class nameaAndAgeController {
    @Value("${my.name}")
    private  String name;
    @Value("${my.age}")
    private String age;
    @RequestMapping("/sayNameAndAge")
    public String sayHello(){
        return "your name is :"+ name +" age is "+ age ;
    }
}
