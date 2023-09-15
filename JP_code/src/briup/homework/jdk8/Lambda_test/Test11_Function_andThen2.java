package briup.homework.jdk8.Lambda_test;

import java.util.function.Function;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/30-08-30-14:01
 * @Description：briup.homework.jdk8.Lambda_test
 */
public class Test11_Function_andThen2 {
    /*
        定义一个方法
        参数串一个字符串类型的整数
        参数再传递两个Function接口
           一个泛型使用Function<String,Integer>
           一个泛型使用Function<Integer,String>
     */
    public static void change(String s, Function<String,Integer> fun1, Function<Integer,String> fun2){
        String ss = fun1.andThen(fun2).apply(s);
        System.out.println(ss);
    }

    public static void main(String[] args) {
        String s = "123";
        //调用change方法
        change(s,(String str)->{
            return Integer.parseInt(str)+10;
        },(Integer i)->{
            return i+"";
        });

        //优化Lambda表达式
        change(s, str->Integer.parseInt(str)+10, i->i+"");
    }
}
