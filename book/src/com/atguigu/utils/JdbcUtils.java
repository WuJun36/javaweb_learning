package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {

    private static DruidDataSource source = null;

    static {
        try {
            //读取jdbc.properties属性配置文件
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties pros = new Properties();
            System.out.println(is);
            //从流中加载数据
            pros.load(is);
            //创建数据库连接
            source = (DruidDataSource) DruidDataSourceFactory.createDataSource(pros);
            System.out.println(source);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 获取数据库连接池中的连接
     *
     * @return 如果返回null，说明获取连接失败
     */
    public static Connection getConnection(){

        Connection conn = null;
        try {
            conn = source.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;

    }

    /**
     * 关闭链接，放回数据库连接池
     * @param conn 数据库连接
     * @throws SQLException
     */
    public static void close(Connection conn){
        DbUtils.closeQuietly(conn);
    }

}
