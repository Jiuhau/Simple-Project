package com.example.springaspectsaop.annotatioin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE}) // 表示次注解可以标注在类和方法上
@Retention(RetentionPolicy.RUNTIME) // 运行时生效
public @interface LogAnnotatioin {
    //定义一个变量，可以接受参数
    String desc() default "";
}
