package src.junit.SQLTest;

import org.junit.Test;

import java.sql.*;

/**
 * @Auther: vanse(lc)
 * @Date: 2023/9/13-09-13-9:41
 * @Description：com.briup
 */
public class TestLoginAttackHandler {
    private final String driver = "com.mysql.cj.jdbc.Driver";
    String password = "root";
    String user = "root";
    String url = "jdbc:mysql://localhost:3306/briup";
    @Test
    public void test() throws Exception {
        // 1.注册驱动
        Class.forName(driver);
        // 2.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("conn = " + conn);
        // 3.获取执行器'
//        conn.createStatement();
        String sql = "select * from t_user " +
                "where name = ? and password = ?";
        // 预编译sql
        PreparedStatement ps = conn.prepareStatement(sql);
        // 给sql条件设置值
        ps.setString(1,"tom");
        ps.setString(2,"212");
        // 5.处理结果集
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("password"));
        }

        // 名字不对
        // 6.关闭资源
        rs.close();
        ps.close();
        conn.close();
    }
}