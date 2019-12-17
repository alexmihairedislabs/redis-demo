package com.redislabs.redisdemo.dao;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Person")
@Data
public class Person {
    private String id;
    private String name;
}
