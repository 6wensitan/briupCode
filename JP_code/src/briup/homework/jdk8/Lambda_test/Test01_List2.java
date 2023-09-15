package briup.homework.jdk8.Lambda_test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/29-08-29-20:18
 * @Description：briup.homework.jdk8.Lambda
 */
public class Test01_List2 {
    public static void main(String[] args) {
        // 生产型接口
        Supplier<Integer> s = () -> (int) (Math.random() * 20);
        // 1.准备set集合
        Set<Integer> set = new HashSet<>();
        prepare(set,s);
        set.forEach(a -> System.out.print(a + " "));
        // 2.筛选偶数的集合
        System.out.println(filter(set, e -> (int) e % 2 == 0));
    }
    //获取随机数
    public static void prepare(Set<Integer> set,Supplier<Integer> s){
        for (int i = 0; i < 20; i++) {
            set.add(s.get());
        }
    }

    public static List<Integer> filter(Set<Integer> set, Predicate<Integer> p){
        List<Integer> newList = new ArrayList<>();
        set.forEach(c -> { // c是每一个元素
            if(p.test(c)){
                newList.add(c);
            }
        });
        return newList;
    }
    
}