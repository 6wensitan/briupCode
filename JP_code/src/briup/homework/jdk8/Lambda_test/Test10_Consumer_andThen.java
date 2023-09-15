package briup.homework.jdk8.Lambda_test;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/8/30-08-30-13:34
 * @Description：briup.homework.jdk8.Lambda_test
 */
/*
* 使用Consumer接口：格式化打印信息，String[] arr={"卢本伟,男","五五开,女","white,男"}
* 格式化结果：
*  卢本伟：男 姓名：卢本伟 性别：男 */
public class Test10_Consumer_andThen {
    public static void main(String[] args) {
        Consumer_andThen consumerAndThen = str -> {
            for (String s : str) {
                String str1 = s.replace(",",":");
                System.out.println(str1 + " 姓名:"+str1.split(":")[0]+" 姓别:"+str1.split(":")[1]);
            }
        };
        consumerAndThen.feature(new String[] {"卢本伟,男","五五开,女","white,男"});
    }
}

interface Consumer_andThen {
    void  feature(String []str);
}

