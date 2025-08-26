package com.example.server4.firstdb.repository;

import com.example.server4.firstdb.entity.Users;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface FirstRepository extends R2dbcRepository<Users, String> {
}
