package com.example.jdkdozer.service.impl;

import com.example.jdkdozer.entity.User;
import com.example.jdkdozer.res.UserVo;
import com.example.jdkdozer.service.TestService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private Mapper dozerMapper;

    @Override
    public UserVo getUser() {
        User user = new User() {{
            setName("张三");
            setFriendNameList(new ArrayList<String>() {{
                add("王一博");
                add("肖战");
            }});
            setAge(18);
            setIfMarried(Boolean.FALSE);
            setBirthday(new Date());
            setSon("没有!");
        }};
        UserVo userVo = dozerMapper.map(user, UserVo.class);
        System.out.println(user);
        System.out.println(userVo);
        return userVo;
    }
}
