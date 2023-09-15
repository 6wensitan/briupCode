package src.junit.SQLTest;

import org.junit.Test;

import java.sql.*;

/**
 * @Author: VIRUS(rlq))
 * @Date: 2023/9/12 0012-09-12-22:19
 * @Description：SQLTest
 */
public class LoginTest {
    private final String driverClass = "com.mysql.cj.jdbc.Driver";
    String password = "root";
    String user = "root";
    String url = "jdbc:mysql://localhost:3306/briup";

    @Test
    public void test_Login() {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            String username = "tom";
            String passwd = "' or '1'='1";
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            String sql = "select count(*) from t_user where name = '" + username + "' and password = '" + passwd + "'";
            rs = statement.executeQuery(sql);
            //5、处理结果集
            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("count = " + count);
                if (count == 0)
                    System.out.println("登录失败");
                else
                    System.out.println("登录成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
