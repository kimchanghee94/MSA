package com.example.server4.repository;

import com.example.server4.document.Table1Collection;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface Table1Repository extends ReactiveMongoRepository<Table1Collection, String> {
}
