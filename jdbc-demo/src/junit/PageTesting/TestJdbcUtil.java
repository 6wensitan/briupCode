package src.junit.PageTesting;


import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: vanse(lc)
 * @Date: 2023/9/14-09-14-16:26
 * @Description：com.briup.jdbc.test
 */
public class TestJdbcUtil {
    @Test
    public void getConnetction() throws SQLException {
        int pageNum = 2;
        int pageSize = 10;
        PageUtil pageUtil = new PageUtil();
        pageUtil.currentPage = pageNum; // 当前页
        pageUtil.pageSize = pageSize; // 每页条数

        Connection conn = JdbcUtil.getConnection();
        String sql = "select id,name,gender,password from t_person limit ?,?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int offset = (pageNum - 1) * pageSize; // 0-5
        ps.setInt(1, offset);
        ps.setInt(2, pageSize);
        ResultSet rs = ps.executeQuery();

        List<User> list = new ArrayList<User>();
        while (rs.next()) {
            // 取出每一条数据
            User user = new User(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("gender"),
                    rs.getString("password"));
            list.add(user);
        }
        pageUtil.data = list; // 10条数据


        String sql2 = "select count(id) as total from t_user";
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        ResultSet rs2 = ps2.executeQuery();
        while (rs2.next()) {
            long total = rs2.getLong("total");
            pageUtil.totalSize = total;
        }
        // 10001 / 10
        pageUtil.totalPage = (pageUtil.totalSize % pageSize == 0
                ? pageUtil.totalSize / pageSize : pageUtil.totalSize / pageSize + 1);

        System.out.println("pageUtil = " + pageUtil);
    }

}