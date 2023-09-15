package briup.homework.jdk8.Lambda_test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/30-08-30-11:30
 * @Description：briup.homework.jdk8.Lambda_test
 */
public class Test08_Preidcate_and2 {
    public static void main(String[] args) {
        String[] arr = {"卢本伟,男","五五开,女","white,男"};

        Predicate<String> CharsPredicate = s -> s.length() == 5;
        Predicate<String> malePredicate = s -> {
//            return s.lastIndexOf("男")==s.length()-1;
            return s.endsWith("男");
        };

        List<String> newList = new ArrayList<>();

        for (String s : arr) {
            if (CharsPredicate.and(malePredicate).test(s)) {
                newList.add(s);
            }
        }
        System.out.println(newList);
    }
}
