package com.example.server4.firstdb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Users {
    private String id;
    private String username;
    private String carnum;
}
