package src.junit.SQLTest;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;

/**
 * @Auther: vanse(lc)
 * @Date: 2023/9/13-09-13-11:54
 * @Description：预处理器
 */
public class TestPS {
    private final String driver = "com.mysql.cj.jdbc.Driver";
    String password = "root";
    String user = "root";
    String url = "jdbc:mysql://localhost:3306/briup";
    @Test
    public void test() throws Exception{
        // 1.注册驱动
        Class.forName(driver);
        // 2.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        // 3.获取预处理执行器 并提前准备sql
        // ? 预处理占位符
        String sql = "insert into t_user(id,name,age,password) " +
                "values(?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        // 3.1 设置sql的占位符参数
        for (int i = 0; i <=10; i++) {
            ps.setInt(1, 23+i);// 第一个?
            ps.setString(2,"thgg_"+i);
            ps.setInt(3,21+i);
            ps.setString(4,"211"+i);
            ps.addBatch();

            if (i%5==0){
                int[] rows = ps.executeBatch();
                System.out.println(Arrays.toString(rows));
            }
        }


        // 4.执行sql 此处参数不要写sql,已经预处理
//        int row = ps.executeUpdate(); // stmt(sql)
//        System.out.println("row = " + row);
        // 5.处理结果
        // 6.关闭资源
        ps.close();
        conn.close();
    }
}