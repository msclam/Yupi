package com.atguigu8.connectionPool.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author lanjuwen
 * @create 2021-12-28  12:50
 */
public class C3P0Test {
    @Test
    // 方式一
    public void testGetConnection() throws Exception {
        // c3p0数据库连接池
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test" );
        cpds.setUser("root");
        cpds.setPassword("root");

        // 通过设置相关参数，对数据库连接池进行管理

        // 设置初始时数据库连接池的连接数
        cpds.setInitialPoolSize(10);
        Connection conn = cpds.getConnection();
        System.out.println(conn);

        // 销毁c3p0连接池
        DataSources.destroy( cpds );
    }

    // 方式二: 使用配置文件
    @Test
    public void testGetConnection1() throws Exception {
        ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
        Connection connection = cpds.getConnection();
        System.out.println(connection);
    }
}
