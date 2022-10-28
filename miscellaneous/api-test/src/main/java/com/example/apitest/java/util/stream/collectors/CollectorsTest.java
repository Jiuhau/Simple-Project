package com.example.apitest.java.util.stream.collectors;

import com.example.apitest.common.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsTest {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("张伟", "男", 18));
        users.add(new User("张伟", "男", 25));
        users.add(new User("小美", "女", 20));
        users.add(new User("小美", "女", null));
        // 问：测试List.stream转map时List中有重复key会如何处理
        Map<String, Integer> map = users.stream().filter(v -> {
            if (v.getAge() == null) {
                return false;
            }
            return true;
        }).collect(Collectors.toMap(
                v -> v.getName(),
                v -> v.getAge(),
                (o, n) -> Math.min(o, n))
        );
        // 答：用第三个参数对相同Key的Value进行逻辑比较
        System.out.println(users);
        System.out.println(map);
        // 测试.count是统计条数还是统计值相加
        Long long1 = users.stream().filter(a -> a.getAge() != null && a.getAge() > 0).count();
        // 答：统计条数
        System.out.println(long1);
        // 测试groupingBy能否自动处理null
        users.stream().collect(Collectors.groupingBy(User::getAge));
        // 答：不能
    }
}
