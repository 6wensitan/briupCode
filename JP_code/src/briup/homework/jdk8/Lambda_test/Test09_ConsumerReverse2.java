package briup.homework.jdk8.Lambda_test;

import java.util.function.Consumer;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/30-08-30-13:24
 * @Description：briup.homework.jdk8.Lambda_test
 *
 * Consumer有一个未实现的抽象方法accept()
 */
public class Test09_ConsumerReverse2 {
    public static void main(String[] args) {
        String text = "Hello, World!";
        Consumer<String> reverseAndPrint = str -> {
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            System.out.println(sb);
        };
        reverseAndPrint.accept(text);
    }
}
