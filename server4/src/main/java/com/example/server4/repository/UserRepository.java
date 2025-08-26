package com.example.server4.repository;

import com.example.server4.entity.Users;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface UserRepository extends R2dbcRepository<Users, String> {
}
