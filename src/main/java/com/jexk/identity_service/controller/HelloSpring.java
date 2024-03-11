package com.jexk.identity_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpring {
     @GetMapping("/hello")
    String sayHello(){
         return  "hello bakery_recipe" ;
     }
}
