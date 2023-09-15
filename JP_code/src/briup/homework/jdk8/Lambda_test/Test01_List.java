package briup.homework.jdk8.Lambda_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/29-08-29-20:18
 * @Description：briup.homework.jdk8.Lambda
 */

/*
* 用一个大集合存入20个随机数，然后筛选其中的偶数元素，放到小集合当中然后进行遍历输出。
* */
public class Test01_List {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        Random random = new Random();
        List_num listNum = ()->{
            for (int i = 0; i < 20; i++) {
                int num = random.nextInt(100);
                integerList.add(num);
                if (num%2==0){
                    evenList.add(num);
                }
            }
//            System.out.println(integerList);
            for (Integer integer : evenList) {
                System.out.print(" "+integer);
            }
        };
        listNum.get();
    }
}

interface List_num {
    void get();
}
