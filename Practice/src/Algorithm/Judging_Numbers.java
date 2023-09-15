package Algorithm;

import java.util.Scanner;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/2-09-02-11:27
 * @Description：Algorithm
 */

/*
* 二维数组中的查找
* 在一个n*m的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
* 请完成一个高效的函数，输入下面这个二维数组和键盘录入一个整数，判断数组中是否含有该整数。*/
public class Judging_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] arr = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(Judging_Numbers.findNumber(arr, num));
        scanner.close();
    }

    public static boolean findNumber(int[][] arr,int num){
//        遍历二维数组
        loop1:for (int i = arr.length-1; i >=0; i--) {
            for (int j = 0; j < arr[i].length; ) {
                if (arr[i][j]>num){
                    continue loop1;
                }else if (arr[i][j]<num){
                    j++;
                }else if (arr[i][j]==num){
                    return true;
                }
            }
        }
        return false;
    }
}
