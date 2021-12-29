package com.atguigu3.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author lanjuwen
 * @create 2021-12-25  16:34
 */
public class JDBCUtils {
    // （不使用数据库连接池）操作数据库的工具类
    // 获取连接
    public static Connection getConnection() throws Exception {
        // 1 获取配置资源
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        String url = pros.getProperty("url");
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String driverClass = pros.getProperty("driverClass");

        // 2 加载驱动
        Class.forName(driverClass);

        // 3 注册驱动和获得连接
        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    }

    public static void closeResource(Connection conn, Statement ps) {
        // 7 资源关闭
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
        // 7 资源关闭
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*********************************使用dbutils.jar包中提供的工具类Dbutils工具类实现资源关闭****************************************************/
    public static void closeResource1(Connection conn, Statement ps, ResultSet rs) {
//        try {
//            DbUtils.close(conn);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            DbUtils.close(ps);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            DbUtils.close(rs);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(ps);
        DbUtils.closeQuietly(rs);
    }

    public static void closeResource1(Connection conn, Statement ps) {
//        try {
//            DbUtils.close(conn);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            DbUtils.close(ps);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            DbUtils.close(rs);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(ps);
    }

    /*********************************使用数据库连接池连接数据库****************************************************/
    /**
     * 使用c3p0的数据库连接池技术
     *
     * @return
     * @throws SQLException
     */
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0"); // 池子一个就够，连接多个

    public static Connection getConnection1() throws SQLException {
        Connection connection = cpds.getConnection();
//        System.out.println(connection);
        return connection;
    }


    /**
     * 使用dbcp的数据库连接池技术
     *
     * @return
     * @throws SQLException
     */
    private static DataSource source2;

    static {
        try {
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
//        FileInputStream is = new FileInputStream(new File("src/dbcp.properties"));
            Properties pros = new Properties();
            pros.load(is);
            source2 = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection2() throws Exception {
        Connection conn = source2.getConnection();
        return conn;
    }


    /**
     * druid数据库连接池的连接
     *
     * @return
     * @throws SQLException
     */
    private static DataSource source3;

    static {
        try {
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            Properties pros = new Properties();
            pros.load(is);
            source3 = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection3() throws Exception {
        Connection conn = source3.getConnection();
        return conn;
    }

}
