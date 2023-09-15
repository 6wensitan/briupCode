package com.briup.chat01;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/28-08-28-15:23
 * @Description：com.briup
 *
 * 快捷键的学习huhu
 */
public class Sample_Shortcut_keys {
    public static void main(String[] args) {
        System.out.println("test01.main");//soutm
        System.out.println();//sout

        int a = 1;
        System.out.println(a);
        System.out.println("a = " + a);//soutv

        System.out.println("args = " + Arrays.deepToString(args));//soutp,自动打印方法参数

        String c="oo";
        if (c == null) {
            System.out.println("c = " + c);
        }//ifn

        if (c != null) {
            System.out.println(c);
        }//inn
        
        int []arr = {1,3,4};
        for (int i : arr) {
            
        }//iter

        for (int i = 10; i > 0; i--) {
            
        }//10.forr

        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];

        }//arr.for

        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < objects.size(); i++) {
            Object o =  objects.get(i);
        }//itli

    }
}
