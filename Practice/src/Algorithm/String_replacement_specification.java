package Algorithm;
/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/2-09-02-13:15
 * @Description：Algorithm
 */

/*请实现一个函数，把字符串str中的每一个空格替换成“%20”*/
public class String_replacement_specification {
    public static void main(String[] args) {
        String str = "We are best friends";
        //简化版本
//        str.replaceAll(" ","%20");
        System.out.println(String_replacement_specification.replace_String(str));
    }

    public static String replace_String(String str){
        //此处利用StringBuilder类的对象能够被多次修改，并且不产生新的未使用对象
        //由于StringBuilder相较于StringBuffer有速度优势，所以多数情况下建议使用StringBuilder类
        //此处可以使用方法toCharArray：字符串变数组
        StringBuilder res = new StringBuilder();
        for (Character c:str.toCharArray()){
            if(c.equals(' ')){
                res.append("%20");
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
