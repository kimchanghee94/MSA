package com.example.server4.service;


import com.example.server4.firstdb.entity.Users;
import com.example.server4.firstdb.repository.FirstRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MainServiceTest {
    @InjectMocks
    MainService service;
    @Mock
    FirstRepository repository;

    @Test
    void update_test(){
        //given
        Users users = new Users("test", "test", "test");
        Users saved = new Users("test", "test", "test");
        //when
        given(repository.save(any(Users.class))).willReturn(Mono.just(saved));
        Mono<Users> resultId = service.update(users);

        //then
        assertTrue(resultId instanceof Mono<Users>);
    }

    @Test
    void update_test2(){
        //given
        Users users = new Users("test", "test", "test");

        Users saved = new Users("test", "test", "test");
        //when
        given(repository.save(any(Users.class))).willReturn(Mono.just(saved));
        service.update(users);

        //then
        verify(repository).save(any(Users.class));
    }
}
