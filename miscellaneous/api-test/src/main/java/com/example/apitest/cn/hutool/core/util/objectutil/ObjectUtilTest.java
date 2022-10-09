package com.example.apitest.cn.hutool.core.util.objectutil;

import cn.hutool.core.util.ObjectUtil;
import com.example.apitest.common.User;

import java.util.ArrayList;
import java.util.List;

public class ObjectUtilTest {
    public static void main(String[] args) {
        // 测试工具类isEmpty功能
        List<User> users1=null;
        System.out.println(ObjectUtil.isEmpty(users1));
        List<User> users2=new ArrayList<>();
        System.out.println(ObjectUtil.isEmpty(users2)+"---"+users2.isEmpty());
    }
}
