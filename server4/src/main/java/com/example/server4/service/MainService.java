package com.example.server4.service;

import com.example.server4.entity.Users;
import com.example.server4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MainService {
    @Autowired
    private UserRepository repository;

    public Flux<Users> getData(){
        return repository.findAll();
    }

}
