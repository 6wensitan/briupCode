package briup.homework.jdk8.Lambda_test;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/30-08-30-9:46
 * @Description：briup.homework.jdk8.Lambda_test
 */
/*声明函数式接口，接口中声明抽象方法，public String getValue（String str）；
声明类TestLambda，类中编写方法使用接口作为参数，将每一个字符转换成大写，并作为方法的返回值
再将一个字符串的第二个和第四个索引位置进行截取子串。*/

public class Test06_LambdaSub {
    public static void main(String[] args) {
        LambdaIndexing ls = (str) -> {
            String toCase = str.toUpperCase();
            System.out.println("大写的str = "+toCase);
            return toCase;
        };
        String sub = ls.getValue("hello world").substring(1, 4);
        System.out.println("截取的sub = "+sub);
    }
}

interface LambdaIndexing{
    String getValue(String str);
}
