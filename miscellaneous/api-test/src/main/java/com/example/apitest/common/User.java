package com.example.apitest.common;

import lombok.Data;

@Data
public class User {
    String name;
    String sex;
    Integer age;

    public User() {
    }

    public User(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

}
