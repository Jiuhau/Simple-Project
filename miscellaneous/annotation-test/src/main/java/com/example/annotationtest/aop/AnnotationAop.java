package com.example.annotationtest.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Aspect
@Component
public class AnnotationAop {

    @Pointcut("@annotation(com.example.annotationtest.annotation.AnnotationTest)")
    public void annotationTest() {
    }

    @Around("annotationTest()")
    public Object doBefore(ProceedingJoinPoint point) throws Throwable {
        //获取入参
        Object[] args = point.getArgs();
        JSONObject params = JSON.parseObject(JSONObject.toJSONString(args[0]));
        //获取orderBy 防止sql注入
        String orderBy = params.getString("orderBy");
        if (orderBy != null && !orderBy.isEmpty()) {
            //创建匹配模式 只接受一个空格和字母
            Pattern pattern = Pattern.compile("^[a-zA-Z]+\\s?[a-zA-Z]+$");
            //选择匹配对象
            Matcher matcher = pattern.matcher(orderBy);
            if (!matcher.find()) {
                throw new RuntimeException("orderBy参数异常");
            }
        }
        Object result = point.proceed();
        return result;
    }
}
