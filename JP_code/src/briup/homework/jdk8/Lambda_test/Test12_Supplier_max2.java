package briup.homework.jdk8.Lambda_test;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/30-08-30-14:38
 * @Description：briup.homework.jdk8.Lambda_test
 */
public class Test12_Supplier_max2 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 52, 333, 23};//1
        int max = findMax(arr, () -> Integer.MIN_VALUE);
        System.out.println("Max value: " + max);
    }

    public static int findMax(int[] arr, Supplier<Integer> supplier) {//2
        int max = supplier.get();
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
