package briup.homework.jdk8.Lambda_test;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/30-08-30-10:01
 * @Description：briup.homework.jdk8.Lambda_test
 */
/*声明一个带两个泛型的函数式接口，泛型类型为<T,R>T为参数，R为返回值接口中声明
* 对于抽象方法在Test07_LambdaGenerics类中声明方法，使得接口作为参数，
* 计算两个long型参数的和，再计算两个long型参数的乘积*/
public class Test07_LambdaGenerics {
    public static void main(String[] args) {
        Lambda_Generics<Long, Long> sum1 = Long::sum;
        Lambda_Generics<Long, Long> product = (a, b) -> a*b;
//      计算两个long型参数的和，再计算两个long型参数的乘积
        Long l1=20L,l2=12L;
        System.out.println("result_sum =" + sum1.apply(l1, l2));
        System.out.println("result_pro = " + product.apply(l1, l2));
    }
}

interface Lambda_Generics<T,R> {
//    R为返回值
    R apply(T x,T y);
}
