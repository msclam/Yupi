package com.atguigu9.connectionPool.dbcp;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPTest {
    // 测试dbcpTest的连接池技术
    // 方式一
    @Test
    public void testGetConnection() throws SQLException {
        // 创建dbcp数据库连接池
        BasicDataSource source = new BasicDataSource();

        // 设置基本信息
//        source.setDriverClassName();
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/test");
        source.setUsername("root");
        source.setPassword("root");

        // 还可以设置其他设计数据库连接池管理的相关属性
        source.setInitialSize(10);
        source.setMaxActive(10);

        Connection conn = source.getConnection();
        System.out.println(conn);
    }

    // 方式二 使用配置文件的方式
    @Test
    public void testGetConnection1() throws Exception {
        // 方式一
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
//        FileInputStream is = new FileInputStream(new File("src/dbcp.properties"));
        Properties pros = new Properties();
        pros.load(is);
        DataSource datasource = BasicDataSourceFactory.createDataSource(pros);

        Connection conn = datasource.getConnection();
        System.out.println(conn);
    }
}
