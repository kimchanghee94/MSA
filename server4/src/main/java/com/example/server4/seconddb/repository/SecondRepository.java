package com.example.server4.seconddb.repository;

import com.example.server4.seconddb.entity.Users;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface SecondRepository extends R2dbcRepository<Users, String> {
}
