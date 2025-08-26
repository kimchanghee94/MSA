package com.example.server4.controller;

import com.example.server4.firstdb.entity.Users;
import com.example.server4.firstdb.repository.FirstRepository;
import com.example.server4.seconddb.repository.SecondRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final FirstRepository firstRepository;
    private final SecondRepository secondRepository;

    @GetMapping("/")
    public String mainP(){
        Flux<Users> data1 = firstRepository.findAll();
        data1.subscribe(x ->{System.out.println(x);});

        Flux<com.example.server4.seconddb.entity.Users> data2= secondRepository.findAll();
        data2.subscribe(x->System.out.println(x));

        return "hi";
    }

}
