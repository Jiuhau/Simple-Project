package com.example.apitest.java.util.list;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        // 测试 List.contains 的使用
        String id = "1";
        List<String> idList = new ArrayList<>();
        idList.add("1");
        idList.add("2");
        idList.add("3");
        idList.add("10");
        System.out.println(idList.contains(id));
    }
}
