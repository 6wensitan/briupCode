package briup.homework.jdk8.Lambda_test;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/30-08-30-13:52
 * @Description：briup.homework.jdk8.Lambda_test
 */
public class Test10_Consumer_andThen2 {
    public static void main(String[] args) {
        String[] arr = {"卢本伟,男", "五五开,女", "white,男"};

        Consumer<String> formatPrint = s -> {
            String[] split = s.split(",");
            String name = split[0];
            String gender = split[1];

            System.out.println(s.replace(",", "：")+" 姓名：" + name + "，性别：" + gender);
        };
        //流遍历
        Arrays.stream(arr).forEach(formatPrint);
    }
}
