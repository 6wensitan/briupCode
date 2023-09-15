package com.briup.chat02.addLambda;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/30-08-30-14:57
 * @Description：com.briup.chat02.addLambda
 */
public class Method_reference {
    public static void main(String[] args) {
//        方法引用
        Action m = Student::sayHello;
        Action m1 = ()-> System.out.println("hello java8 方法引用");

        m.run();
        m1.run();
    }
}
interface Action {
    void run();
}

class Student{
//    其实只要一个函数是无参的、无返回类型的，它就可以作为run方法的具体实现
    public static void sayHello(){
        System.out.println("hello Lambda方法引用");
    }
}