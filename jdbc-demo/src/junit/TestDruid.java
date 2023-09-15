package src.junit;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.SQLException;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/14-09-14-10:10
 * @Description：PACKAGE_NAME
 */
public class TestDruid {
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/briup";
    static String user = "root";
    static String password = "root";
    public static void main(String[] args) throws SQLException {
        // 配置druid
//        DruidDataSource dataSource = new DruidDataSource();
//        System.out.println("dataSource = " + dataSource);
        // 1.准备连接池参数并创建对象
        DruidDataSource dataSource = new DruidDataSource();
        // driver url username password
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        // 2.从连接池获取连接
        DruidPooledConnection conn = dataSource.getConnection();
        System.out.println("conn = " + conn);
    }
}