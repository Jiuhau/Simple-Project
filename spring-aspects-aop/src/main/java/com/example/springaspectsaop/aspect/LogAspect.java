package com.example.springaspectsaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 记录日志功能的类：切面类 = 切入点(规则)+通知(方法
 */
@Aspect
@Component
public class LogAspect {

    // 定义切入点函数 com.example.springaspectsaop.service包及所有子包下任何类的任何方法
    @Pointcut("execution(* com.example.springaspectsaop.controller..*(..))")
    public void pt() {
        System.out.println("---切入点---");
    }

    @Before("pt()")
    public void before(JoinPoint joinPoint) {
        System.out.println("---前置通知---");
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        System.out.println("URL : " + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("CLASS_METHOD : " + joinPoint);
        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning("pt()")
    public void afterReturning() {
        System.out.println("---后置通知---");
    }

    @AfterThrowing("pt()")
    public void afterThrowing() {
        System.out.println("---异常通知---");
    }

    @After("pt()")
    public void after() {
        System.out.println("---最终通知---");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) {
        //获取目标方法签名对象
        Signature signature = joinPoint.getSignature();
        System.out.println("目标方法名字：" + signature.getName());
        System.out.println("目标对象实现接口的全名：" + signature.getDeclaringTypeName());

        //获取参数的数组
        Object[] args = joinPoint.getArgs();
        System.out.println("目标方法参数：" + Arrays.toString(args));

        Object result = null;
        //修改目标方法参数
        //args[0] = "白骨精";
        try {
            System.out.println("前置通知");
            //如果修改了参数，要使用带参数的方法。(如果不执行这句话，目标方法不会执行)
            result = joinPoint.proceed(args);  //直接调用目标方法
            System.out.println("后置通知");
        } catch (Throwable throwable) {
            System.out.println("异常通知");
        } finally {
            System.out.println("最终通知");
        }
        return result;
    }
}
