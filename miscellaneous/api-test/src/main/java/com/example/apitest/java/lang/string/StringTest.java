package com.example.apitest.java.lang.string;

public class StringTest {
    public static void main(String[] args) {
        //split分割 但没有分割点
        //答：不分割
//        String a = "dealerCode";
//        String[] splitResult = a.split("\\.");
//        System.out.println(splitResult[0]);
        //String.replace与String.replaceAll替换转义字符是否能识别
        //答：replace可以不做特殊处理 replaceAll需要用正则表达式
        String context = "服务顾问{}您好，预约车辆【{}】还有{}小时到达预约时间，请做好接待准备。";
        System.out.println(context);
        System.out.println(context.replace("{}","替换文本"));
        System.out.println(context.replace("{}",""));
//        context.replaceAll("{0}","替换文学");
    }
}
