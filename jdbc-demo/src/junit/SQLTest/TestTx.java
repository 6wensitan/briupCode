package src.junit.SQLTest;

import org.junit.Test;

import java.sql.*;

/**
 * @Auther: vanse(lc)
 * @Date: 2023/9/13-09-13-14:26
 * @Description：批处理
 */
public class TestTx {
    private final String driver = "com.mysql.cj.jdbc.Driver";
    String password = "root";
    String user = "root";
    String url = "jdbc:mysql://localhost:3306/briup";

    @Test
    public void testPsTx() throws Exception {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        // 手动提交
        conn.setAutoCommit(false);
        try {
            // 两条sql 互相转账
            String sql = "update t_user set age = age+100 where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,1);
            int i = ps.executeUpdate();
            System.out.println("i = " + i);
//            int m = 1/0;
            // 注意: 换新的ps和sql,否则ps预编译的是原sql
            String sql2 = "update t_user set age = age-100 where id = ?";
            ps = conn.prepareStatement(sql2);
            ps.setInt(1,2);
            int i2 = ps.executeUpdate();
            System.out.println("i = " + i2);
            conn.commit(); // 手动提交事务
            ps.close();
            conn.close();
        } catch (SQLException e) {
            conn.rollback(); // 回滚
            throw new RuntimeException(e);
        }
    }
}