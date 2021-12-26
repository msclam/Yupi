package com.atguigu6.transaction;

import com.atguigu3.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author lanjuwen
 * @create 2021-12-26  17:11
 */
public class ConnectionTest {
    @Test
    public void testGetConnection() throws Exception{
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);
    }


}
