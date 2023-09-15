package briup.homework.jdk8.Lambda_test;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/30-08-30-9:21
 * @Description：briup.homework.jdk8.Lambda_test
 */
/*自定义函数式接口，提供方法将字符串转为数字，使用Lambda测试。抽象方法toNum。*/
public class Test05_StringTONum {
    public static void main(String[] args) {
        //如果字符串不是一个合法的数字格式，将会抛出NumberFormatException异常。
        Lambda_string_num lsn = () -> {
            try {
                String s = "131";
                int num = Integer.parseInt(s);
                System.out.println("num = " + num);
            } catch (NumberFormatException e) {
                System.out.println("无法将该字符串转换为整数");
            }
        };
        lsn.toNum();
    }
}

interface Lambda_string_num{
    void toNum();
}