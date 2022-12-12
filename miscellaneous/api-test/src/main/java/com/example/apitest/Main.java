package com.example.apitest;

import com.example.apitest.common.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //todo null能否强转->能
//        Object nulObj = null;
//        String test1 = (String) nulObj;
        //todo foreach是否是引用类型->是
//        List<User> users = new ArrayList<>();
//        users.add(new User("张伟", "男", 18));
//        users.add(new User("张伟", "男", 25));
//        users.add(new User("小美", "女", 20));
//        System.out.println(users.toString());
//        for (User user : users) {
//            user.setAge(1);
//        }
//        System.out.println(users.toString());
        //todo 时间戳获取会重复吗->会
//        long[] a = new long[10];
//        for (int i = 0; i < 10; i++) {
//            a[i] = System.currentTimeMillis();
//        }
//        for (int i = 0; i < 10; i++) {
//            System.out.println(a[i]);
//        }
        //todo 计算
        double checkRate = 0;
        int submitPassCount = 0;
        int submitCount = 1;
        checkRate = 1.0D * submitPassCount / submitCount * 100;
        System.out.println(checkRate);
    }
}
