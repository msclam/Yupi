package com.atguigu5.blob;

import com.atguigu3.bean.Customer;
import com.atguigu3.util.JDBCUtils;
import org.junit.Test;

import java.io.*;
import java.sql.*;

/**
 * @author lanjuwen
 * @create 2021-12-26  12:41
 */
public class BlobTest {
    // 向数据表customers插入blob型数据的字段(插入超过1m的图，修改mysql的my.ini配置文件，然后重启)
    @Test
    public void testInsert() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        String sql = "insert into customers(name, email, birth, photo) values(?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setObject(1, "袁");
        ps.setObject(2, "yuan@qq.com");
        ps.setObject(3, "1993-02-02");
        FileInputStream is = new FileInputStream(new File("girl.jpg"));
        ps.setObject(4, is);

        ps.execute();

        JDBCUtils.closeResource(conn, ps);
    }

    // 向数据表customers查询数据的blob字段
    @Test
    public void testQuery() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id, name, email, birth, photo from customers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, 21);
            rs = ps.executeQuery();
            if (rs.next()) {
                // 方式一
    //            int id = rs.getInt(1);
    //            String name = rs.getString(2);
    //            String email = rs.getString(3);
    //            Date birth = rs.getDate(4);
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birth = rs.getDate("birth");
                Customer cust = new Customer(id, name, email, birth);
                System.out.println(cust);

                // 将blob字段下载，保存在本地
                Blob photo = rs.getBlob("photo");
                is = photo.getBinaryStream();
                fos = new FileOutputStream("zhan.jpg");
                byte[] buffer = new byte[1024];
                int len;
                while ((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResource(conn, ps, rs);
        }

    }
}
