package Algorithm;

import java.util.Scanner;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/2-09-02-11:56
 * @Description：Algorithm
 */
public class Judging_Numbers_subscript {

    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        int num = scanner1.nextInt();
        int[][] arr = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(Judging_Numbers_subscript.findNumber1(arr, num));
    }

    public static boolean findNumber1(int[][] arr,int num){
//        利用下标去寻找对应的目标数字
//        初始化坐标定位到最后一行，第一列
        int i=arr.length-1;
        int j=0;
//        遍历
        while (i>=0&&j<=arr[i].length-1){
            if (arr[i][j]>num){
                i--;
            }else if (arr[i][j]<num){
                j++;
            }else {
                return true;
            }
        }
        return false;
    }
}
