package com.yunusemre.notebook.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Merhaba YouTube!";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name){
        return "Merhaba YouTube! via " + name;
    }
}
