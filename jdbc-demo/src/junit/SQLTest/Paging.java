package src.junit.SQLTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/13-09-13-19:17
 * @Description：src.SQLTest
 */
public class Paging {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/briup";
        String user = "root";
        String password = "root";
        String driverClass = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverClass);
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();

        int pageSize = 5;
        int total = 24;
        for (int currentPage = 1; currentPage <= (total / pageSize + 1); currentPage++) {
            int start = (currentPage - 1) * pageSize;
            String sql = "SELECT * FROM t_user limit " + start + "," + pageSize;
//            System.out.println(sql);
            System.out.println("当前第"+(start+1)+"页");
            System.out.println("当前页大小："+pageSize);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String psw = rs.getString(4);
                System.out.println("id: " + id + ", name:" + name + ", age:" + age + ", password:" + psw);

            }
            if ((currentPage* pageSize)%5==0){
                System.out.println("======================");
            }
        }
        stmt.close();
        conn.close();

    }

}