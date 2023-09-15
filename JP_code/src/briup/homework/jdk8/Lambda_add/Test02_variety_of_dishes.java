package briup.homework.jdk8.Lambda_add;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/1-09-01-16:19
 * @Description：briup.homework.jdk8.Lambda_add
 */
public class Test02_variety_of_dishes {
    public static void main(String[] args) {
        List<String> list =
                Arrays.asList("水煮鱼","酸菜鱼","麻辣鱼","麻婆豆腐","回锅肉",
                        "鱼香肉丝","水煮肉片","宫保鸡丁","剁椒","鱼头","夫妻肺片");
        Predicate<String> predicate = s-> s.contains("鱼");
        Predicate<String> predicate1= (String s) -> s.length()==3;
        // 使用 Predicate 判断当前元素是否符合给定的 Predicate 条件，返回值
        //List<String> stringList1 =
        list.stream()
                .filter(predicate)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("------------");
//        List<String> stringList2 =
        list.stream()
                .filter(predicate1)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("------------");
        list.stream()
                .filter(predicate)
                .filter(s->s.length()==3)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
