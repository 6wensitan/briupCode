package briup.homework.jdk8.Lambda_add;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/1-09-01-14:22
 * @Description：briup.homework.jdk8.Lambda_add
 */
public class Test01_Line_up {
    public static void  main(String[] args) {

        List<String> list =
                Arrays.asList("Tom","jay","jjj","hhh","Lucy", "张的","张萨那","Simon","GreenPark","张大刷","张小Phone");

        List<String> stringList1 = list.stream().filter(s -> s.length() == 3)
                .collect(Collectors.toList())
                .subList(0,2);
//                .forEach(System.out::println);

        List<String> stringList = list.stream().filter(m -> m.contains("张"))
                .collect(Collectors.toList())
                .subList(2, list.stream()
                        .filter(m -> m.contains("张"))
                        .collect(Collectors.toList())
                        .size());
//                .forEach(System.out::println);

        ArrayList<String> list2 = new ArrayList<>();
        list2.addAll(stringList);
        list2.addAll(stringList1);
//        list2.forEach(System.out::println);

        //根据姓名创建 Person 对象；存储到一个新集合中。
        List<Person> list3 = list2.stream().map(Person::new).collect(Collectors.toList());
        list3.forEach(System.out::println);

    }

    static class Person {
        String name;
        public String getName() {return name;}

        public Person() {}
        public Person(String name) {this.name = name;}

        @Override
        public String toString() {return "Person{name='" + name + '\'' + '}'; }
    }
}