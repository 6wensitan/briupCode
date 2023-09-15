package src.junit.SQLTest.tool;

import org.junit.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/14-09-14-9:26
 * @Description：src.SQLTest.tool
 */
public class DifferentFromPrepareStatement {
//    Connect_MySQL con = new Connect_MySQL();

    @Test
    public void Batch() throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
//        connection = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
        Properties props = new Properties();
        props.load(new FileInputStream("src/junit/druid.properties"));
        String user = props.getProperty("user");
        String pass = props.getProperty("password");
        String url = props.getProperty("url");
        String driver = props.getProperty("driver");
        Class.forName(driver);
        //连接sql
        connection = DriverManager.getConnection(url, user, pass);
        System.out.print("start：");
        //statement
        String sql = "INSERT INTO t_user VALUES(?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        long start = System.currentTimeMillis();
        System.out.println(start);
        connection.setAutoCommit(false);
        for (int i = 0; i < 1000; i++) {
            preparedStatement.setLong(1,i+1);
            preparedStatement.setString(2,"jack_"+i);
            preparedStatement.setLong(3,10+i);
            preparedStatement.setString(4,"uuuu"+i);
            preparedStatement.addBatch();

            if ((i+1)%1000 == 0){
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }
        preparedStatement.executeBatch();
        preparedStatement.clearBatch();
        connection.commit();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        
        preparedStatement.close();
        connection.close();
    }
}