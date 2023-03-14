package com.example.apitest;

import com.alibaba.fastjson.JSON;
import com.example.apitest.common.User;
import com.github.jknack.handlebars.internal.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

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
//        double checkRate = 0;
//        int submitPassCount = 0;
//        int submitCount = 1;
//        checkRate = 1.0D * submitPassCount / submitCount * 100;
//        System.out.println(checkRate);
        //todo 转换
//        Map<String, Object> param = new HashMap<String, Object>(){{
//            put("dealerCode","buzhidao123");
//        }};
//        List<String> keyList = new ArrayList(){{
//            add("dealerCode");
//        }};
//        LinkedHashMap<String, Object> rst = new LinkedHashMap<>(param);
//        for (String paramKey : param.keySet()) {
//            Object paramVal = rst.get(paramKey);
//            String[] docSplit = paramKey.split("\\.");
//            String checkKey = docSplit[0];
//            int index = keyList.indexOf(checkKey);
//            if (index != -1 && Objects.nonNull(paramVal) && StringUtils.isNotBlank(paramVal.toString())) {
//                keyList.remove(index);
//            }
//            rst.put(checkKey, paramVal);
//        }
        //todo 去重
        //3
    }
}
