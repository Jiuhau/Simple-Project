package com.example.apitest.com.alibaba.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonTest {
    public static void main(String[] args) {
        /*
        测试getBooleanValue和getBoolean的区别
        结果：一样，唯有在处理null时前者返回false、后者返回null
         */
        String obj = "{\"name\":\"true\",\"age\":1}";
        JSONObject result = JSONObject.parseObject(obj);
        System.out.println(obj);
        System.out.println("getBooleanValue:" + result.getBooleanValue("name"));
        System.out.println("getBoolean:" + result.getBoolean("name"));
        System.out.println("——————————");
        System.out.println("getBooleanValue:" + result.getBooleanValue("age"));
        System.out.println("getBoolean:" + result.getBoolean("age"));
        System.out.println("——————————");
        System.out.println("getBooleanValue:" + result.getBooleanValue("other"));
        System.out.println("getBoolean:" + result.getBoolean("other"));
    }
}
