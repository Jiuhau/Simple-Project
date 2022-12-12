package com.example.apitest.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    String name;
    String sex;
    Integer age;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT")
    Date birthday;

    public User() {
    }

    public User(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

}
