package com.example.server4.service;

import com.example.server4.firstdb.entity.Users;
import com.example.server4.firstdb.repository.FirstRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MainService {
    private final FirstRepository repository;

    public Mono<Users> update(Users dto){

        Users users = new Users("test", "test", "test");
        return repository.save(users);
    }
}
