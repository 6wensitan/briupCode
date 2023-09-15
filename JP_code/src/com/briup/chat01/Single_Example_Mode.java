package com.briup.chat01;

/**
 * 单例模式：饿汉式
 * @Auther: Green Park(pch))
 * @Date: 2023/8/29-08-29-9:46
 * @Description：com.briup.chat01
 */
public class Single_Example_Mode {
    static Single_Example_Mode sem = new Single_Example_Mode();//1
    static int a = 0;//3:a=0,b=1;
    static int b;
    
    private Single_Example_Mode(){//2:a=1,b=1;
        a++;
        b++;
    }

    public static Single_Example_Mode getInstance(){
        return sem;
    }

    public static void main(String[] args) {
        getInstance();//4
        getInstance();
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
