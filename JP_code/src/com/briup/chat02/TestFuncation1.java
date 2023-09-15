package com.briup.chat02;

import java.util.function.Function;

/**
 *  @Auther: Green Park(pch))
 *  @Date: 2023/8/30-08-30-10:01
 *  @Description：briup.homework.jdk8.Lambda_test
 */
public class TestFuncation1 {
    public static void main(String[] args) {
        String s = "1234";
        Function<Integer, String> fun = new Function<Integer, String>() {
            @Override
            public String apply(Integer i) {
                return String.valueOf(i);
            }
        };
        System.out.println("oper(s,fun) = " + oper(1, fun));
    }
    // 字符串 -> 数字   "1" -> 1
    public static <T, R> R oper(T s, Function<T,R> function){
        return function.apply(s);
    }
}