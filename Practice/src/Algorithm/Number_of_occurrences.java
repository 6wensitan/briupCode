package Algorithm;

import java.util.*;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/3-09-03-10:40
 * @Description：Algorithm
 */
public class Number_of_occurrences {
    public static void main(String[] args) {
        int[] arr={1,3,4,2,4,2,3};
        Number_of_occurrences.findOccurrences(arr);
    }

    public static void findOccurrences(int[] arr){
       //利用hashMap来实现记录数组中元素出现的次数
        HashMap<Integer,Integer> countMap = new HashMap<>();
        for (int num : arr) {
            //判断key是否存在集合
            if (countMap.containsKey(num)){
                //countMap.get(num)获取相应key的value值
                countMap.put(num,countMap.get(num)+1);
            }else {
                countMap.put(num,1);
            }
        }
        System.out.println("数组中相应元素出现的次数："+countMap);
    }
}
