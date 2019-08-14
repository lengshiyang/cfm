package com.gen.jpa.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 创建数据库连接
 * @author	zhanglikun
 * @mail	likun_zhang@yeah.net
 * @date 	2013-6-6
 */
public class DBHandler {
    private static Connection conn ;

    public static final Connection createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver") ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + GenerateConfig.config.dbHost + ":"
                    + GenerateConfig.config.dbPort + "/" + GenerateConfig.config.dbName,
                    GenerateConfig.config.dbUser , GenerateConfig.config.dbPass) ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn ;
    }

    public static final void close() {
        if(conn != null) {
            try {
                conn.close() ;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
