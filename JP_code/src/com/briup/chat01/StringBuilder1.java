package com.briup.chat01;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/29-08-29-10:22
 * @Description：com.briup.chat01
 */
public class StringBuilder1 {
    /**
     * writer a StringBuilder demo with me and in.
     */
    public static void main(String[] args) {

        // 如果已经存在，则覆盖
        String a = "a";
        System.out.println(a);
        System.out.println(a.length());
        StringBuilder a1 = new StringBuilder("a") ;
        a1.append("b").append("c");
        String b = a1.toString();
        System.out.println(b);
        System.out.println(a1);

        // 顺序不要改变
        String c = "test";
        StringBuilder builder1 = new StringBuilder("a");
        builder1.append("b").append("c");
        String d = builder1.toString();
        System.out.println(d);
        builder1.insert(0, "new").insert(0, "test");
        String e = builder1.toString();
        System.out.println(e);

        // end of demo
        String f = new String("a");
        StringBuilder builder2 = new StringBuilder("a");
        builder2.append("b").append("c");
        System.out.println(builder2.length());
        System.out.println(builder2.capacity());
        System.out.println(builder2.charAt(2));
        System.out.println(builder2.length());
        System.out.println(builder2.subSequence(1, 4));
        System.out.println("printout = "+builder2);
        System.out.println(builder2.toString());
        System.out.println("======================");

        StringBuilder builder3 = new StringBuilder("a");
        builder3.append("b").append("c");
        String g = builder3.toString();
        System.out.println(g);
        builder3.reverse();
        String h = builder3.toString();
        System.out.println(h);
        builder3.delete(1, 4);
        System.out.println(builder3.length());
        System.out.println(builder3.capacity());
        System.out.println(builder3.charAt(0));
        System.out.println(builder3.toString());
        System.out.println(builder3.substring(1));
        System.out.println(builder3.substring(1,3));
        System.out.println("======================");
    }
}
