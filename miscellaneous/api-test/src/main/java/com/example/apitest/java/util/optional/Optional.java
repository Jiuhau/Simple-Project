package com.example.apitest.java.util.optional;

public class Optional {
    public static void main(String[] args) {
        // 测试Optional.ofNullable.orElse
        String phone1 = "1";
        String phone2 = "1";
        phone1 = java.util.Optional.ofNullable(null).orElse("phone是null").toString();
        phone2 = java.util.Optional.ofNullable("1").orElse("phone是null").toString();
        System.out.println("phone1:" + phone1);
        System.out.println("phone2:" + phone2);
    }
}
