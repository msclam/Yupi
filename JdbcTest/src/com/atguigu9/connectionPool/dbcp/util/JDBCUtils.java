package com.atguigu9.connectionPool.dbcp.util;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    /**
     * 使用dbcp的数据库连接池技术
     * @return
     * @throws SQLException
     */
    private static DataSource source;

    static {
        try {
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
//        FileInputStream is = new FileInputStream(new File("src/dbcp.properties"));
            Properties pros = new Properties();
            pros.load(is);
            source = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection testGetConnection2() throws Exception {
        Connection conn = source.getConnection();
        return conn;
    }
}
