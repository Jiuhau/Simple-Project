package com.example.apitest.com.alibaba.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.apitest.common.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {
    public static void main(String[] args) {
        /*
        todo 测试getBooleanValue和getBoolean的区别
        结果：一样，唯有在处理null时前者返回false、后者返回null
         */
//        String obj = "{\"name\":\"true\",\"age\":1}";
//        JSONObject result = JSONObject.parseObject(obj);
//        System.out.println(obj);
//        System.out.println("getBooleanValue:" + result.getBooleanValue("name"));
//        System.out.println("getBoolean:" + result.getBoolean("name"));
//        System.out.println("——————————");
//        System.out.println("getBooleanValue:" + result.getBooleanValue("age"));
//        System.out.println("getBoolean:" + result.getBoolean("age"));
//        System.out.println("——————————");
//        System.out.println("getBooleanValue:" + result.getBooleanValue("other"));
//        System.out.println("getBoolean:" + result.getBoolean("other"));
        /*
        todo 时间转换JSONObject.parseObject 时区问题
        结果：
         */
//        JSONObject jsonObject = new JSONObject(){{
//            put("birthday","2022-11-12 10:34:23");
//            put("name","阿三");
//            put("sex","女");
//            put("age",16);
//        }};
//        System.out.println("——————————打印jsonObject——————————");
//        System.out.println(jsonObject);
//        User user = JSONObject.parseObject(jsonObject.toJSONString(), User.class);
//        System.out.println(user.getBirthday());
        /*
        todo JSONObejct中数组转List
         */
        JSONObject jsonObject= new JSONObject();
        List<Map<String,Object>> array = new ArrayList<>();
        Map a1 = new HashMap(){{
            put("image_data", "图片1");
            put("extended", "11111");
        }};
        array.add(a1);
        Map a2 = new HashMap(){{
            put("image_data", "图片2");
            put("extended", "22222");
        }};
        array.add(a2);
        jsonObject.put("result_data", array);
        System.out.println("模拟入参>>>>>" + jsonObject);
        //开始转换
        String js = JSONObject.toJSONString(jsonObject.getJSONArray("result_data"));
        List<Map> resultData = JSONObject.parseArray(js, Map.class);
        for (Map data : resultData) {
            String imageData = (String) data.get("image_data");
            System.out.println(imageData);
        }
    }
}
