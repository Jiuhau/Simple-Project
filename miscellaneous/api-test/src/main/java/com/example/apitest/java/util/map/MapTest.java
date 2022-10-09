package com.example.apitest.java.util.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        // Map remove不存在的key会如何
        // 结果：remove存在的key返回value 不存在的key返回null
        Map<String, Object> map = new HashMap<>();
        map.put("name", "peter");
        map.put("age", "11");
        map.put("age", "12"); // 重复key会覆盖
        System.out.println("初始:" + map);
        System.out.println("移除存在的key:" + map.remove("name"));
        System.out.println("移除不存在的key:" + map.remove("sex")); // 不存在的key
        System.out.println("结束:" + map);
    }
}
