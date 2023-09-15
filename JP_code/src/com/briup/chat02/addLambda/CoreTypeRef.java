package com.briup.chat02.addLambda;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/30-08-30-20:19
 * @Description：com.briup.chat02.addLambda
 */

/*
 * 数组引用：
 *  语法格式：
 *  Type::new
 */
public class CoreTypeRef {
    @Test
    public void test(){

//        Function<Integer, String[]> function = x->new String[x];
//        String [] apply = function.apply(10);
//        System.out.println(apply.length);
        //上面等价于

        //字符串数组，存入Integer类型的参数
        Function<Integer, String[]> function1 = String[]::new;
        /*Function是Java标准库中的一个函数式接口，它的抽象方法是R apply(T t)，
                其中T是输入参数的类型，R是返回值的类型。
                    在这里，T是Integer，R是String[]*/
        String[] apply1 = function1.apply(20);
        List<String> stringList = new ArrayList<>();
        stringList.add("hello");
        stringList.add("world");
        stringList.add("window");
        for (int i = 0; i < stringList.size(); i++) {
            /*.stream(): 首先，stringList 被转换为一个流。
                流是Java 8引入的概念，它可以让你对数据进行一系列的操作，例如筛选、映射、聚合等。

                .filter(str -> str.contains("l")): 在流上调用 filter 操作。这个操作会保留那些满足特定条件的元素。
                在这里使用 lambda 表达式 str -> str.contains("l") 来判断字符串是否包含字母 "l"，如果包含则被保留。

                    .toArray(String[]::new): 在经过 filter 操作后，流中剩余的元素会被收集到一个数组中。
                    这里使用方法引用 String[]::new 来创建一个与流中元素数量相同的字符串数组，然后将流中的元素放入这个数组中。
            */
            apply1 = stringList
                        .stream()
                            .filter(str -> str.contains("l"))
                                .toArray(String[]::new);
        }

        System.out.println(Arrays.toString(apply1));

    }
}
