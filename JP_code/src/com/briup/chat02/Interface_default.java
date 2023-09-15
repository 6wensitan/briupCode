package com.briup.chat02;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/29-08-29-14:23
 * @Description：com.briup.chat02
 */
public class Interface_default implements defaultInterface {
    public static void main(String[] args) {
        Interface_default default1 = new Interface_default();
        default1.before();
        default1.after();
    }

    @Override
    public void before() {

    }

    @Override
    public void after() {
        defaultInterface.super.after();
    }
}

interface defaultInterface {
    void before ();
    default void after(){
        System.out.println("hekk");
    };
}