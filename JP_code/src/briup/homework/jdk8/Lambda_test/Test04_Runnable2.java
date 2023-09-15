package briup.homework.jdk8.Lambda_test;
import java.lang.Runnable;
/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/30-08-30-9:15
 * @Description：briup.homework.jdk8.Lambda_test
 */
public class Test04_Runnable2 {
    public static void main(String[] args) {
//        Runnable task = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello java Thread");
//            }
//        };
//        new Thread(task).start();
        /*lambda简化写法*/
        new Thread(() -> System.out.println("Hello java8 Thread")).start();
    }
}
