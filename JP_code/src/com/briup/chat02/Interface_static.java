package com.briup.chat02;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/29-08-29-14:22
 * @Description：com.briup.chat02
 */
public class Interface_static implements staticInterface {

    public static void main(String[] args) {
        staticInterface myObject = new staticInterface() {
            @Override
            public void sendMessage() {
                System.out.println("zhende ");
            }
        };
        staticInterface.sendMail();
    }

    @Override
    public void sendMessage() {

    }
}

interface staticInterface{

    void sendMessage();

    static void  sendMail(){
        // " I am An Emailer ";
        String s = "I am An Emailer";
        System.out.println(s);
    };
}
