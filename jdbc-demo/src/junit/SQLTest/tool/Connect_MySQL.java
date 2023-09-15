package src.junit.SQLTest.tool;

import java.sql.*;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/13-09-13-20:02
 * @Description：src.SQLTest.tool
 */
public class Connect_MySQL {
    final String password = "root";
    final String user = "root";
    final String url = "jdbc:mysql://localhost:3306/briup";
    final String driverClass = "com.mysql.cj.jdbc.Driver";

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }

    public String getUrl() {
        return url;
    }

    public String getDriverClass() {
        return driverClass;
    }


    public void EXAMINE()  {
        try(Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try(Statement stmt = DriverManager.getConnection(url, user, password).createStatement()) {
            if (stmt != null){
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (PreparedStatement pstmt = DriverManager.getConnection(url, user, password).prepareStatement("SELECT * FROM t_user")){
            if (pstmt != null){
                pstmt.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
