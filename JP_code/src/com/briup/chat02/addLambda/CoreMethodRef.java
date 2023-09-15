package com.briup.chat02.addLambda;

import org.testng.annotations.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/30-08-30-19:17
 * @Description：com.briup.chat02.addLambda
 */

/*
 * 方法引用：若Lamda体中的内容有方法已经实现了，我们可以使用“方法引用”
 * (可以理解为方法引用是Lambda表达式的另一种表现形式)
 * 主要有三种语法格式：
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 * ！！！注意：
 * ①Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的参数列表和返回值类型保持一致
 * ②若Lambda体中参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数值时，可以使用ClassName::method
 */
public class CoreMethodRef {
    //对象：：实例方法名
    @Test
    public void test() {
//        PrintStream printStream= System.out;
//        Consumer<String> con = x->printStream.println(x);
//        con.accept("Hello");
//        //上面等价于下面这种写法
//        Consumer<String> con1 = printStream::println;
//        con1.accept("Hello a");
        //最终等价于
        Consumer<String> con2 = System.out::println;
        con2.accept("Hello ba");
    }

    //对象：： 实例方法名2
    @Test
    public void test1(){
        Employee emp = new Employee();
//        Supplier<String> supplier = ()-> emp.getName();
//        String name = supplier.get();
//        System.out.println(name);
        //上面等价于下面这种写法
        Supplier<String> supplier1 = emp::getName;
        String name1 = supplier1.get();
        System.out.println(name1);
    }

    //类：：静态方法名
    @Test
    public void test2() {
        //当调用Comparator Lambda方法体时，
        /*发现已经有Integer实现这个方法，那么就可以直接调用*/
        //而Integer的compare方法同时也是静态方法，所以可以直接使用类名：：方法名调用
        Comparator<Integer> comparator = (o1, o2) -> {
            return Integer.compare(o1,o2);
        };
        //上面等价于
        Comparator<Integer> comparator1 = Integer::compare;
        System.out.println("comparator1 = " + comparator1);
    }

    //类：：实例方法名
    @Test
    public void test3(){
        BiPredicate<String,String> biP = (s, s2) -> {
            return s.equals(s2);
        };
        System.out.println("biP.test() = " + biP.test("hhh", "h"));

        BiPredicate<String,String> biP2 = String::equals;
        System.out.println("biP2.test() = " + biP2.test("hhhj", "hhhj"));
    }

}

class Employee{
    public String getName() {
        System.out.println("get name ...");
        return "abc";
    }
}