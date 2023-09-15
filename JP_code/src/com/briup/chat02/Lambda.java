package com.briup.chat02;

/*
 * @Auther: Green Park(pch))
 * @Date: 2023/8/29-08-29-14:37
 * @Description：com.briup.chat02
 **/

import java.util.Random;

/**
 * 定义四个函数式接口,并lambda表达创建实现类
 * 1.接口
 * interface MyConsumer{
 * 	public abstract String accept();
 * }
 * class ConumerImpl implements MyConsumer{
 * 	public String accept(){
 * 		return "hello"; // 实现逻辑随便
 *        }
 * }
 * MyConsumer c = new ConumerImpl();
 * String s = c.accept();  // hello
 *
 * 2.接口
 * interface MySupply{
 * 	int get();
 * }
 * // 实现生产随机数
 *
 * 3.接口
 * interface MyPredicate{
 * 	boolean predict(); // 判空
 * }
 * int[] arr   arr>0 true 实现类
 *
 * 4.接口
 * interface MyFunction{
 * 	int hello(String s);
 * }
 * // 实现类 s.length   用参数的方法 -> int类型
 */

public class Lambda {
    public static void main(String[] args) {
        MyConsumer c = ()-> "hello";
        System.out.println("c.accept() = " + c.accept());

        MySupply u = ()->{
            Random random = new Random();
            return random.nextInt();
        };
        System.out.println("supply.get() = "+u.get());

        MyPredicate p = ()->{
            Random random = new Random();
            return random.nextInt() > 0;
        };
        System.out.println("p.predict() = "+p.predict());

        MyFunction f = (s)->{
            if (s == null || s.length() == 0) {
                return 0;
            } else {
                return s.length();
            }
        };
        System.out.println("f.length("+f.length("") + ") = "+f.length(""));
    }

}

//以下接口的实现都用lambda函数式接口实现
//字符串
interface MyConsumer{
     String accept();
}

// 实现生产随机数
interface MySupply {
     int get();
}

// 判空
interface MyPredicate{
   boolean predict();
}

// 实现类 s.length   用参数的方法 -> int类型
interface MyFunction{
    int length(String s);
}
