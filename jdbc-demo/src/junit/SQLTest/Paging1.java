package src.junit.SQLTest;

import src.junit.SQLTest.tool.Connect_MySQL;

import java.sql.*;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/13-09-13-19:17
 * @Description：src.SQLTest
 */
public class Paging1 {
    static Connect_MySQL con = new Connect_MySQL();
    public static void main(String[] args) throws Exception {

        int pageSize = 5;
        int total = 24;
        for (int currentPage = 1; currentPage <= (total / pageSize + 1); currentPage++) {
            int start = (currentPage - 1) * pageSize;
            String sql = "SELECT * FROM t_user limit " + start + "," + pageSize;
            System.out.println("当前第"+(start+1)+"页");
            System.out.println("当前页大小："+pageSize);
            page(sql);
            if ((currentPage* pageSize)%5==0){
                System.out.println("======================");
            }
        }
    }

    public static void page(String sql) throws Exception{
        Class.forName(con.getDriverClass());
        Connection conn = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int age = rs.getInt(3);
            String psw = rs.getString(4);
            System.out.println("id: " + id + ", name:" + name + ", age:" + age + ", password:" + psw);
        }
        ggg();
    }

    public static void ggg(){
        con.EXAMINE();
    }
}