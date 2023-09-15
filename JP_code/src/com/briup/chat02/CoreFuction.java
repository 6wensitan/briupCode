package com.briup.chat02;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/30-08-30-16:21
 * @Description：com.briup.chat02
 */

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8内置的四大核心函数式接口
 * Consumer<T>：消费型接口：void accept(T t);
 * Supplier<T>：供给型接口：T get();
 * Function<T, R>：函数型接口：R apply(T t);
 * Predicate<T>：断言型接口：boolean test(T t);
 */
public class CoreFuction {
    //Consumer接口测试（消费
    @Test
    public void testConsumer(){
        consume(1,m->{
            System.out.println("每月吃饭消费："+m +"元");
        });
    }
    public void consume(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    //Supplier接口测试（供给
    @Test
    public void testSupplier() {
        List<Integer> list = getNumberList(10,()->(int)(Math.random() * 100));
        list.forEach(System.out::println);
    }

    public List<Integer> getNumberList(Integer num, Supplier<Integer> supplier){
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer res = supplier.get();
            newList.add(res);
        }
        return newList;
    }

    // Function接口测试（函数式接口）
    @Test
    public void testFunction() {
        String functionRes = getFunctionRes("小明,吃饭了吗？", s-> {
            return s.replace(",", "在");
        });
        String functionRes2 = getFunctionRes("小明,吃coroutine了吗？", s-> {
            return s.replace("o", "l");
        });
        System.out.println(functionRes);
        System.out.println(functionRes2);
    }

    public String getFunctionRes(String string, Function<String,String> function) {
        return function.apply(string);
    }

    //  Predicate接口测试（断言型接口）
    @Test
    public void testPredicate() {
        List<String> list = Arrays.asList("dddd", "unmarshall", "整理", "storage ");
        List<String> res = predicateRes(list, s-> {
            return s.length()>3&&s.startsWith("un");
        });
        res.forEach(System.out::println);
    }

    public List<String> predicateRes(List<String> list, Predicate<String> predicate){
        List<String> newList = new ArrayList<>();
        list.forEach(l-> {
            if (predicate.test(l)) {
                //这里的test其实就是s.length()>3&&s.startsWith("un")
                newList.add(l);
            }
        });
        return newList;
    }
}
