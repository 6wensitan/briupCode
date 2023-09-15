package briup.homework.jdk8.Lambda_test;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/30-08-30-11:42
 * @Description：briup.homework.jdk8.Lambda_test
 */
/*使用Predicate接口String[] arr = {"卢本伟,男","五五开,女","white,男"};
把三个字的，性别为男的存一个集合中。
*/
public class Test09_ConsumerReverse {
    public static void main(String[] args) {
        Consumer_reverse consumer = (str) -> {
            StringBuilder str1 = new StringBuilder(str);
            return String.valueOf(str1.reverse());
        };
        System.out.println("反转 = " + consumer.getReversResult("12UNDEFINED"));
    }
}

interface Consumer_reverse {
    String getReversResult(String str);
}