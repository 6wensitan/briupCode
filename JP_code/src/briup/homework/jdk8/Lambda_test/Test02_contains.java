package briup.homework.jdk8.Lambda_test;

import java.util.*;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/29-08-29-21:01
 * @Description：briup.homework.jdk8.Lambda
 */
/*
* ArrayList 去除集合中字符串的重复值（字符串的内容相同）
* 思路：创建新集合方式，新集和添加的时候用contains（）判断*/
public class Test02_contains {
    public static void main(String[] args) {
        List <String> listString = new ArrayList<>();
        Set<String> newList = new HashSet<>();
        listString.add("hello");
        listString.add("keq");
        listString.add("role");
        listString.add("keq");
        listString.add("Role");
        listString.add("hello");
        String_contains string_contains = () -> {
            for (String string : listString) {
                if (listString.contains(string)){
                    newList.add(string);
                }
            }
            return newList;
        };
        string_contains.getContains().forEach(s -> {
            System.out.print(s+" ");
        });
    }
}

interface String_contains {
    Set<String> getContains();
}