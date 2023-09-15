package src.junit.SQLTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/12-09-12-16:16
 * @Description：src.SQLTest
 */
public class DMLTest {
    String password = "root";
    String user = "root";
    String url = "jdbc:mysql://localhost:3306/briup";

    @Before
    public void before() throws Exception {
        String driverClass = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverClass);
    }

    @Test    public void paginateData() throws SQLException {
        int currentPage = 1; // 当前页码
        int pageSize = 5; // 每页显示的行数

        // 计算起始行
        int startRow = (currentPage - 1) * pageSize;

        String selectSql = "SELECT person_id, person_name, gmt_create FROM person1 " +
                "ORDER BY person_id DESC " +
                "LIMIT " + startRow + ", " + pageSize;

        paginateAndPrintData(selectSql);
    }

    // 封装的方法用于执行SQL查询并进行分页显示和打印到控制台
    private void paginateAndPrintData(String sql) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        int rowNumber = 0;
        while (rs.next()) {
            int id = rs.getInt("person_id");
            String name = rs.getString("person_name");
            String date = rs.getString("gmt_create");

            System.out.println("ID: " + id + ", Name: " + name + ", Date: " + date);

            rowNumber++;
        }

        if (rowNumber == 0) {
            System.out.println("No more data.");
        }
    }

    //数据查询，数据以集合的形式输出
    private void testDQL(String sql) throws SQLException {
        Connection conn = DriverManager.getConnection(url,user,password);
        Statement stmt =conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<Message> list = new ArrayList<>();
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            System.out.println(id + " "+name + " "+age);
            list.add(new Message(id, name, age));
        }
        System.out.println(list);
    }

    //数据以集合的形式输出
    static class Message{
        int id;
        String name;
        int age;
        @Override
        public String toString() {
            return "Message{"+"id="+id + ", name="+name +", age="+age+"\n";
        }

        public Message(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }

    @After
    public void after() {
        try(Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
