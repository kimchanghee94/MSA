package com.example.server4.controller;

import com.example.server4.entity.Users;
import com.example.server4.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class MainController {
    @Autowired
    private MainService service;
    @GetMapping("/")
    public Flux<Users> mainP(){
        return service.getData();
    }

}
