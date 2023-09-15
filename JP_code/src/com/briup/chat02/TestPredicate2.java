package com.briup.chat02;

import java.util.function.Predicate;

/**
 *  @Auther: Green Park(pch))
 *  @Date: 2023/8/30-08-30-10:01
 *  @Description：briup.homework.jdk8.Lambda_test
 */
public class TestPredicate2 {
    public static void main(String[] args) {
        // 情况1: 判断某字符串是否以为 txt结尾
        Predicate<String> p1 = a -> a.endsWith("txt");
        System.out.println(operater("hello.txt", p1));

        // 情况2: 判断字符串长度 > 5
        Predicate<String> p2 = s -> s.length() > 5;
        System.out.println(operater("hello.txt", p2));

        // 2个条件同时成立
        Predicate<String> p3 = p1.and(p2);
        System.out.println(operater("hello.txt", p3));

        Predicate<String> p4 = p1.or(p2);
        System.out.println("operater(\"hello.\",p4) = " + operater("hello.", p4));

        Predicate<String> p5 = p1.negate();
        System.out.println("operater(\"hello.txt\",p5) = " + operater("hello.txt", p5));

        // 对象是否相等
      Predicate<String> p6 =  Predicate.isEqual("hello.txt");
        System.out.println("operater(\"a.txt\",p6) = " + operater("hello.txt", p6));


    }
    public static boolean operater(String s, Predicate my){
        return my.test(s);
    }
}
