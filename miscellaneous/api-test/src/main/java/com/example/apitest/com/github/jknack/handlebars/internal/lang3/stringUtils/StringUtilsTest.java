package com.example.apitest.com.github.jknack.handlebars.internal.lang3.stringUtils;

import com.github.jknack.handlebars.internal.lang3.StringUtils;

public class StringUtilsTest {
    public static void main(String[] args) {
        // isBlank
        System.out.println(StringUtils.isBlank("phone"));
        System.out.println(StringUtils.isBlank(null));
        System.out.println(StringUtils.isBlank(""));
        System.out.println("————————————");
        // isEmpty
        System.out.println(StringUtils.isEmpty("phone"));
        System.out.println(StringUtils.isEmpty(null));
        System.out.println(StringUtils.isEmpty(""));
    }
}
