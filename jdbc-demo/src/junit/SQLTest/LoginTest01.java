package src.junit.SQLTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.*;

/**
 * @Author: Green Park
 * @Date: 2023/9/12 0012-09-12-22:19
 * @Description：SQLTest
 */
public class LoginTest01 {
    String password = "root";
    String user = "root";
    String url = "jdbc:mysql://localhost:3306/briup";

    @Before
    public void before() throws Exception {
        String driverClass = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverClass);
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter ID: ");
//        int id = sc.nextInt();
    }

    @Test
    public void test_Login() throws SQLException {
//        String username = "tom";
//        String passwd = "212";
//        String sql = "select count(*) from t_user where name = '"
//                + username + "' and password = '"
//                + passwd + "'";

        String sql ="select name,password from t_user ";
        System.out.println(sql);
        dataProcess(sql);
    }

    private void dataProcess(String sql) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        //5、处理结果集
//        while (rs.next()) {
//            int count = rs.getInt(1);
//            System.out.println("count = " + count);
//            if (count == 0)
//                System.out.println("登录失败");
//            else
//                System.out.println("登录成功");
//        }

        while (rs.next()){
            String name = rs.getString(1);
            String password = rs.getString(2);
            System.out.println("username: "+name+" "+"password: "+password);
            if (name.equals("green")&&password.equals("123")){
                System.out.println("登录成功");
            }else{
                System.out.println("登录失败");
            }
        }
    }

    @After
    public void after() throws SQLException {
        try(Connection connection = DriverManager
                .getConnection(url, user, password)){
            if (connection != null)
            {
                connection.close();
            }
        }
        try (Statement statement = DriverManager
                .getConnection(url, user, password)
                .createStatement())
        {
            if (statement != null){
                statement.close();
            }
        }
    }
}
