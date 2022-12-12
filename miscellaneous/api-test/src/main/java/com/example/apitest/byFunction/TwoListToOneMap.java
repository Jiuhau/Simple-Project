package com.example.apitest.byFunction;

import com.example.apitest.common.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 两个List转换成一个Map
 */
public class TwoListToOneMap {
    public static void main(String[] args) {
        //构建List
        List list1 = new ArrayList(){{
            add(new User("北京","有重复,同位置",16));
            add(new User("天津","有重复,不同位置",36));
            add(new User("杭州","不重复",20));
            add(new User("上海","不重复",70));
        }};
        List list2 = new ArrayList(){{
            add(new User("北京","有重复,同位置",14));
            add(new User("深圳","不重复",10));
            add(new User("天津","有重复,不同位置",34));
        }};
        //两List相加
        list1.addAll(list2);
        //list转map
        Map<String,User> map = (Map<String, User>) list1.stream().collect(Collectors.toMap(User::getName, list->list , (key1,key2)->{
            User user1 = new User(){{
                setName(key1.getName());
                setAge(key1.getAge()+ key2.getAge());
            }};
            return user1;
        }));
        System.out.println(map);
    }
}
