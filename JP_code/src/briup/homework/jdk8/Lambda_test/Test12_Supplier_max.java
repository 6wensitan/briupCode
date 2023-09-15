package briup.homework.jdk8.Lambda_test;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/30-08-30-14:32
 * @Description：briup.homework.jdk8.Lambda_test
 */
public class Test12_Supplier_max {
    public static void main(String[] args) {
        Supplier_max supplier_max = (int[] arr) -> {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i]> max) {
                    max = arr[i];
                }
            }
            return max;
        };
        System.out.println("最大值： "+supplier_max.getMax(new int[]{2, 3, 52, 4, 333, 23}));
    }
}

interface Supplier_max {
    int getMax(int []arr);
}