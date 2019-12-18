package com.redislabs.redisdemo.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Person")
@Data
@AllArgsConstructor
public class Person {
    private String id;
    private String name;
}
