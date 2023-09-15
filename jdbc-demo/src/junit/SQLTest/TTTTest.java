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
public class TTTTest {
    String password = "root";
    String user = "root";
    String url = "jdbc:mysql://localhost:3306/briup";

    @Before
    public void before() throws Exception {
        String driverClass = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverClass);
    }

    @Test
    public void paginateData() throws SQLException {
        int currentPage = 1; // Current page number
        int pageSize = 5;   // Number of rows per page

        // Calculate the starting row
        int startRow = (currentPage - 1) * pageSize;

        String selectSql1 = "SELECT person_id, person_name, gmt_create FROM person1 " +
                "ORDER BY person_id DESC " +
                "LIMIT " + startRow + ", " + pageSize;

        List<Person> paginatedData = paginateAndRetrieveData(selectSql1, Person.class);

        // Print the paginated data
        for (Person person : paginatedData) {
            System.out.println(person);
        }
    }

    // Generic method to execute SQL query, paginate the results, and return a list of the specified type
    public <T> List<T> paginateAndRetrieveData(String sql, Class<T> clazz) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        List<T> dataList = new ArrayList<>();
        while (rs.next()) {
            // Customize this part according to your data structure
            int id = rs.getInt("person_id");
            String name = rs.getString("person_name");
            String date = rs.getString("gmt_create");

            // Create an instance of the specified class and populate it with data
            try {
                T instance = clazz.getDeclaredConstructor(Integer.class, String.class, String.class)
                        .newInstance(id, name, date);
                dataList.add(instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return dataList;
    }

    // Define your data class (replace this with your actual data structure)
    static class Person {
        int person_id;
        String person_name;
        String gmt_create;

        public Person(int person_id, String person_name, String gmt_create) {
            this.person_id = person_id;
            this.person_name = person_name;
            this.gmt_create = gmt_create;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "person_id=" + person_id +
                    ", person_name='" + person_name + '\'' +
                    ", gmt_create='" + gmt_create + '\'' +
                    '}';
        }
    }

    @After
    public void after() {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
