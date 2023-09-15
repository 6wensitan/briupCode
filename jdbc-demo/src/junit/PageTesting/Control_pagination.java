package src.junit.PageTesting;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/14-09-14-18:49
 * @Description：src.junit.PageTesting
 */
public class Control_pagination {
    public static void main(String[] args) {
        System.out.println("hdduysbsd ");
        int a= 12;
        pageUtils(a);
    }
    public static void pageUtils(int a) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i+ a);
        }
    }
}
