package briup.homework.jdk8.Lambda_test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/30-08-30-11:03
 * @Description：briup.homework.jdk8.Lambda_test
 */
public class Test08_Preidcate_and {
    public static void main(String[] args) {
        List<String> newList = new ArrayList<>();
        Preidcate_and preidcateAnd = (String[] arr) -> {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length()==5 && (arr[i].lastIndexOf("男")==arr[i].length()-1)){
                    newList.add(arr[i]);
                }
            }
            return newList;
        };
        System.out.println(preidcateAnd.getList(new String[] {"卢本伟,男","五五开,女","white,男"}));
    }
}

interface Preidcate_and {
     List <String> getList(String []arr);
}