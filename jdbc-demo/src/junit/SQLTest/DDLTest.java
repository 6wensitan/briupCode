package src.junit.SQLTest;

import org.junit.Test;

import java.sql.*;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/12-09-12-14:53
 * @Description：src.SQLTest
 */
public class DDLTest {
    private final String driverClass = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/briup";
    private final String user = "root";
    private final String password = "root";

    @Test
    public void createTable() throws Exception {
//        Connection conn = null;
//        Statement stmt = null;

        Class.forName(driverClass);
        Connection conn = DriverManager.getConnection(url,user,password);
        Statement stmt = conn.createStatement();
        String sql = "create table t_user("
                +"id int primary key, "
                +"name varchar(50) not null,"
                +"age int "
                +")";
        int rows = stmt.executeUpdate(sql);
        // 处理结果
        System.out.println("返回结果："+rows);

        stmt.close();
        conn.close();

    }

    @Test
    public void dropTable(){
        Connection conn = null;
        Statement stmt = null;
        try {
            // 加载驱动
            Class.forName(driverClass);
            //2.获取连接对象
            conn = DriverManager.getConnection(url,user,password);
            //3.获取statement对象
            stmt = conn.createStatement();
            //4.执行sql语句
            String sql = "drop table if exists t_user";
            int rows = stmt.executeUpdate(sql);
            //处理结果
            System.out.println("返回结果："+rows);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6.释放资源
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
