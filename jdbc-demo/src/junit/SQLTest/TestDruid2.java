package src.junit.SQLTest;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/14-09-14-10:25
 * @Description：src.junit.SQLTest
 */
public class TestDruid2 {
    public static void main(String[] args) throws Exception {
        Properties prep= new Properties();
        prep.load(TestDruid2.class.getClassLoader().getResourceAsStream("druid.properties"));

        DruidDataSource ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(prep);
        System.out.println("ds = " + ds);
        Connection connection = ds.getConnection();
        System.out.println("connection = " + connection);
    }
}
