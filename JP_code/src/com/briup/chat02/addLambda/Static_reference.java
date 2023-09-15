package com.briup.chat02.addLambda;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/30-08-30-15:13
 * @Description：com.briup.chat02.addLambda
 */
public class Static_reference {
    public static void main(String[] args) {
        //3调用
        Action1 action1= Static_reference::parse;
        System.out.println(action1.run("hello"));
        //调用2
        Action1 action2 = Integer::parseInt;
        System.out.println(action2.run("123")+10);
    }
    //2处理逻辑
    public static int parse(String s){
        return s.length();
    }
}
//1
interface Action1 {
    int run(String str);
}