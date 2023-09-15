package com.briup.chat02;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/28-08-28-16:17
 * @Description：com.briup
 */
public class FunctionInterface {
    public static void main(String[] args) {
//        使用lambda表达式简化代码实现
        MyFunctionInterface add = Integer::sum;
        System.out.println("add.operate(3,4) = " + add.operate(3, 4));

        MyFunctionInterface sub = (a,b) -> a-b;
        System.out.println("sub.operate(10,2) = " + sub.operate(10, 2));
    }
}

@FunctionalInterface
interface MyFunctionInterface{
    int operate(int a,int b);
}