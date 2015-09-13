package com.sino.sql;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pierce-deng on 2015/8/18.
 */
public class JDBCDAO {
    /**
     * 添加
     *
     * @param sql    添加使用的 sql 语句 e.g insert into user(name,age,sex) values(?,?,?)
     * @param params 填补 sql 语句参数的数组 e.g Object [] params = new Object[]{"john",18,"m"};
     */
    public static void insert(String sql, Object[] params) {
        Connection conn = JDBCUtil.getInstance().getConnection();
        QueryRunner queryRunner = new QueryRunner();
        try {
            queryRunner.update(conn, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 删除
     */
    public static void delete(String sql, Object[] params) {
        insert(sql, params);
    }

    /**
     * 修改
     */
    public static void update(String sql, Object[] params) {
        insert(sql, params);
    }

    /**
     * 查询
     * JDBCDAO.find("select name,sex from user where age=?",new Object[]{18},Class.forName("com.sino.model.User"))
     *
     * @param sql    查询使用的 sql 语句 e.g select name,sex from user where age=?
     * @param params 填补 sql 语句参数的数组 e.g Object [] params = new Object[]{18};
     * @param type   结果集转换成type类型 e.g Class.forName("com.sino.model.User")
     * @param <T>    声明此方法为泛型方法
     * @return e.g 返回值为List<User>
     */
    public static <T> List<T> find(String sql, Object[] params, Class<T> type) {
        Connection conn = JDBCUtil.getInstance().getConnection();
        QueryRunner qr = new QueryRunner();
        List<T> obj = null;
        try {
            obj = qr.query(conn, sql, new BeanListHandler<>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }


    public static List<Map<String, Object>> find(String sql) {
        Connection connection = JDBCUtil.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            return resultSet2List(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.getInstance().close(rs, ps, connection);
        }
        return null;
    }

    private static List<Map<String, Object>> resultSet2List(ResultSet rs) throws SQLException {
        List<Map<String, Object>> models = new ArrayList<>();
        Map<String, Object> model;//获取结果集的结构
        ResultSetMetaData rsmd = rs.getMetaData();
        //获取结果集的列数(字段数)
        int columnCount = rsmd.getColumnCount();
        if (rs != null) {
            while (rs.next()) {
                model = new HashMap<>();
                for (int i = 1; i <= columnCount; i++)
                    //key:列名(别名)，value:字段值
                    //第一列的下标是1
                    model.put(rsmd.getColumnLabel(i), rs.getObject(i));
                models.add(model);
            }
        }
        return models;
    }
}
