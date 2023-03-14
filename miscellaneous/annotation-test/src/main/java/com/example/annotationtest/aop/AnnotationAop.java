package com.example.annotationtest.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Aspect
@Component
public class AnnotationAop {

    @Pointcut("@annotation(com.example.annotationtest.annotation.AnnotationTest)")
    public void annotationTest() {
    }

    /**
     * 过滤入参，防止sql注入安全危险
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("annotationTest()")
    public Object doBefore(ProceedingJoinPoint point) throws Throwable {
        //获取入参
        Object[] args = point.getArgs();
        JSONObject jsonObject = JSON.parseObject(JSONObject.toJSONString(args[0]));
        Map<String, Object> map = JSONObject.toJavaObject(jsonObject, Map.class);

        String str = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|(\\b(select|update" +
                "|and|or|delete|insert|trancate|char|substr|ascii|declare|exec|count" +
                "|master|into|drop|execute)\\b|(\\*|;|\\+|'|%))";
        Pattern pattern = Pattern.compile(str);
        //遍历每个入参
        for (String key : map.keySet()) {
            Object valueObj = map.get(key);
            //如果是列表，则只判断最后一个
            if (valueObj instanceof List) {
                List arrayList = (List) valueObj;
                valueObj = arrayList.get(arrayList.size() - 1);
            }
            String value = JSON.toJSONString(valueObj) ;
            if (value != null) {
                //选择匹配对象
                Matcher matcher = pattern.matcher(value);
                if (matcher.find()) {
                    throw new RuntimeException("参数\"" + key + "\"包含非法字符");
                }
            }
        }

        Object result = point.proceed();
        return result;
    }
}
