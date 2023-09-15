package com.briup.chat02.addLambda;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/31-08-31-15:09
 * @Description：com.briup.chat02.addLambda
 */
public class CoreStream {
    @Test
    public void tset1() {
        //准备集合
        List<String> list = Arrays.asList("hello", "world", "java");
        //操作集合
//        Stream<String> stringStream = list.stream();
//        System.out.println(stringStream.map(String::length).reduce(Integer::sum).get());
        list.stream()
                .filter(s->s.length()>4)
                .limit(3)
                .map( String::new)
                .forEach(System.out::println);

    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("hello", "worldd", "hdhhhhh");
//        任意类型数组变成流
        Stream<Integer> s1 = Stream.of(1, 2, 3, 4);
//        指定数组变成流
        String[] arr = {"a","c","d","t"};
        Stream <String> s2 = Stream.of(arr);
        Stream <String> s3 = Arrays.stream(arr);

    }

    @Test
    public void test3(){

//        1将流变成数组
        Stream<String> a = Stream.of("a", "b", "v");
        String[] as = a.toArray(String[]::new);
        System.out.println(as.length);

//        2将流变成集合
        Stream<String> a1 = Stream.of("a", "b", "v");
        List<String> a1L = a1.collect(Collectors.toList());
        Stream<String> a11 = Stream.of("a", "f", "v");
        ArrayList<String> arrayList = a11.collect(Collectors.toCollection(ArrayList::new));
        System.out.println(a1L);
        System.out.println(arrayList);

//        3将流变成字符串
        Stream<String> a2 = Stream.of("a", "b", "v");
        String a2s = a2.collect(Collectors.joining("-"));
        System.out.println(a2s);

    }

    @Test
    public void test4() {
//       流最终操作
        Stream<String> hello = Stream.of("hello", "world", "java", "routing", "SD", "shanghai");
        hello
                .filter(c->c.length()>5&&c.contains("a"))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void test5() {
//        流变Map集合，分组
        Stream<String> stream =
                Stream.of("test","hello","world","java","tom","C","javascript");
        Map<Integer, Set<String>> tMapCollector =
                stream.collect(
                                Collectors
                                        .groupingBy(String::length,
                                                Collectors
                                                        .mapping(s-> s,
                                                                Collectors
                                                                        .toSet()
                                                        )
                                        )
                            );

    }
}
