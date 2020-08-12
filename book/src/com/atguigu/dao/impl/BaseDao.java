package com.atguigu.dao.impl;

import com.atguigu.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao<T> {

    //使用DbUtil操作数据库
    private QueryRunner runner = new QueryRunner();
    private Class clazz = null;

    {
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type actualTypeArguments = genericSuperclass.getActualTypeArguments()[0];
        clazz = (Class) actualTypeArguments;
    }

    /**
     * update方法用来执行UPDATE/INSERT/DELETE语句
     * @param sql
     * @param args
     * @return 如果返回-1，表示返回失败<br/>返回其他表示影响的行数
     */
    public int update(String sql, Object... args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return runner.update(conn, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return -1;
    }

    /**
     * 查询单条记录
     * @param sql  查询语句
     * @param args  占位符参数
     * @return
     */
    public T queryForOne(String sql,Object...args) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            BeanHandler<T> handler = new BeanHandler<>(clazz);
            return  runner.query(conn, sql, handler, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /**
     * 查询多条记录
     * @param sql  sql语句
     * @param args  占位符参数
     * @return
     */
    public List<T> queryForList(String sql, Object...args) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            BeanListHandler<T> handler = new BeanListHandler<>(clazz);
            return  runner.query(conn, sql, handler, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /**
     * 查询单个值
     * @param sql
     * @param args
     * @param <E>
     * @return
     */
    public <E> E queryForSigleValue(String sql, Object...args) {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            ScalarHandler<E> handler = new ScalarHandler();
            return runner.query(conn, sql, handler, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }


}
