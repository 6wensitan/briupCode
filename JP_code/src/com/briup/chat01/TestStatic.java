package com.briup.chat01;

import java.util.Calendar;
import java.util.Date;

public class TestStatic {
    public static void main(String[] args) {
//        String c = new String("a") + new String("b");
//        System.out.println("c = " + c);

        Date date = new Date();
        System.out.println("date = " + date);
        int day = date.getDay();
        System.out.println("day = " + day);

        Calendar instance = Calendar.getInstance();
        System.out.println("instance = " + instance);
        int i = instance.get(Calendar.DAY_OF_MONTH);
        System.out.println("i = " + i);    }
}