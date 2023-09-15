package src.junit.PageTesting;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Auther: vanse(lc)
 * @Date: 2023/9/14-09-14-16:19
 * @Description：连接工具类
 */
public class JdbcUtil {
    public static DataSource dataSource;

    // 准备数据源
    static {
        InputStream in = null;
        try {
            Properties properties = new Properties();
            in = JdbcUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        // 从连接池获取的
        return dataSource.getConnection();
    }

    public static void close(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close(); // 归还连接池
        }
    }

}