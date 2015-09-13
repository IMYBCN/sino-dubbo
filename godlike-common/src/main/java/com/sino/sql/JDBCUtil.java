package com.sino.sql;

import com.sino.io.PropertiesUtil;

import java.sql.*;
import java.util.Map;

/**
 * Created by admin on 2015/5/22.
 */
public final class JDBCUtil {
    private static JDBCUtil jdbcUtil = new JDBCUtil();
    static String driverClassName = "";
    static String url = "";
    static String userName = "";
    static String password = "";
    static Connection connection = null;

    private JDBCUtil() {
    }

    static {
        Map<String, String> map = PropertiesUtil.read("mysql.properties");
        try {
            driverClassName = map.get("jdbc.driverClassName");
            Class.forName(driverClassName);
            url = map.get("jdbc.url");
            userName = map.get("jdbc.username");
            password = map.get("jdbc.password");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static JDBCUtil getInstance() {
        return jdbcUtil;
    }

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭资源
     *
     * @param connection Connection资源
     */
    public void close(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭资源
     *
     * @param resultSet  ResultSet资源
     * @param statement  Statement资源
     * @param connection Connection资源
     */
    public void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null && !resultSet.isClosed()) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null && !statement.isClosed()) {

                    statement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null && !connection.isClosed()) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
