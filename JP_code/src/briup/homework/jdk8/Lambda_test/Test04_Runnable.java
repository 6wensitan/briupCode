package briup.homework.jdk8.Lambda_test;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/30-08-30-8:52
 * @Description：briup.homework.jdk8.Lambda_test
 */

/*
* 使用lambda改造Runnable创建线程*/
public class Test04_Runnable {
    public static void main(String[] args) {
        Thread lambda_thread = new Thread(() -> {
            System.out.println("Hello Lambda Thread");
        });
        lambda_thread.start();

        Runnable lambdaRunnable = () -> {
            System.out.println("Hello");
            System.out.println("Runnable的线程");
        };
        lambdaRunnable.run();
    }
}

interface Runnable {
    void run();
}


