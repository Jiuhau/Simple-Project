package com.example.springaspectsaop.service.impl;

import com.example.springaspectsaop.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getAll() {
        return "My name is Kiki ,ki~ki~ki!";
    }

    @Override
    public String getOne(String name) {
        return "my name is " + name;
    }
}
