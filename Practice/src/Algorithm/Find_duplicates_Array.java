package Algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/2-09-02-10:59
 * @Description：Algorithm
 */
public class Find_duplicates_Array {
    public static void main(String[] args) {
        int[] arr={1,3,4,2,4,2,3};
        System.out.println(Find_duplicates_Array.foundNum(arr));
    }

    public static List<Integer> foundNum(int[] arr){
        Set<Integer> dia = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (dia.contains(num)){
                list.add(num);
            }else{
                dia.add(num);
            }
        }
        //返回的数字排序
//        List<Integer> integerList = list.stream().sorted().collect(Collectors.toList());
//        return integerList;
        return list;
    }
}
