package briup.homework.jdk8.Lambda_test;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/30-08-30-14:01
 * @Description：briup.homework.jdk8.Lambda_test
 */
/*1.使用Function接口 long long把String类型的”123”,转换为Integer类型，
把转换后的结果加10把增加后的Integer类型数据转换为String类型*/
public class Test11_Function_andThen {
    public static void main(String[] args) {
        Function_andThen functionAndThen = str-> {
            int integer = Integer.parseInt(str);
            int integer1 = integer+10;
            return ""+integer1;
        };
        System.out.println("修改后的 = " + functionAndThen.getString("123"));
    }
}
interface Function_andThen {
     String getString(String str);
}