package Demo_all;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/13-09-13-9:59
 * @Description：Demo_all
 */
public class Student {
    public void defaultMethod(){
        System.out.println("hhhhhhdhdcgsdcjdscb");
    }
}



/**
 * 题目：
 * 1.在浏览器第一个窗口访问地址 ( 多线程 + 网络 + io)
 * localhost:9999/hello.txt 文件内容需要io读取
 *
 * 2.在浏览器第一个窗口访问地址  localhost:9999/hello?role=admin
 * 调用hello方法并将返回值返回给浏览器
 * 该方法有权限注解（管理员 游客 vip） 只有管理员身份才能访问 ,（hashMap集合手动存入）
 *
 * 3.如果访问的/hello没有这个资源；
 * 返回异常信息 异常+枚举；资源找不到；权限不足
 * 自定义异常{
 code 200

 403 权限不足

 404 无资源

 msg

 时间戳
 }
 枚举
 4.服务器一直能接受客户端  */