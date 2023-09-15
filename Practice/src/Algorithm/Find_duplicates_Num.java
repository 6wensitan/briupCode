package Algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/2-09-02-10:46
 * @Description：Algorithm
 */

/*
* 找出数组中重复的数字
* 在一个长度为n的数组nums里的所有数字都在0`~`n-1`的范围内。
* 数组中某些数字是重复的，但不知道有几个数字重复。也不知道每个数字重复几次。
* 请找出数组中任意一个重复的数字。*/

public class Find_duplicates_Num {
    public static void main(String[] args) {
        int[] arr={1,3,4,2,4,2,3};
        System.out.println(Find_duplicates_Num.foundNum(arr));
    }
    public static int foundNum(int[] arr){
        // 定义一个set集合存放数字
        Set<Integer> dic = new HashSet<>();
        //遍历
        for (int num : arr) {
            //如果集合中含有该数字，直接返回
            if (dic.contains(num)){
                return num;
            }
            //否则添加到集合中
            else {
                dic.add(num);
            }
        }
        //遍历完所有，没有就返回-1（一般不会到）
        return -1;
    }
}
