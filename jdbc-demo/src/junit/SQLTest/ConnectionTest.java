package src.junit.SQLTest;

import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/12-09-12-10:53
 * @Description：PACKAGE_NAME
 */
public class ConnectionTest {
    public static void main(String[] args) {

    }
    @Test
    public void testMySQLConnection() throws Exception {

        //1、获取Driver实现类对象，使用反射机制
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
//        Class clazz = Class.forName("com.mysql.jdbc.Driver"); //mysql5
        Driver driver = (Driver) clazz.newInstance();

        //2、提供需要连接的数据库
        String url = "jdbc:mysql://localhost:3306/briup";

        //3、提供连接需要的用户名和密码
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        //4、获取连接
        Connection connection = driver.connect(url, info);
        System.out.println(connection);
    }
}
