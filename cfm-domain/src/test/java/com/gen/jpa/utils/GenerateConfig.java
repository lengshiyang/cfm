package com.gen.jpa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 数据库常量
 * @author	zhanglikun
 * @mail	likun_zhang@yeah.net
 * @date 	2013-6-6
 */
public class GenerateConfig {
    String dbName;		// 数据库名称
    String dbHost ;	// 数据库HOST
    int dbPort = 3306 ;					// 数据库端口
    String dbUser;					// 用户名
    String dbPass ;	// 密码
    String dbTablePrefix;		// 表前缀
    String targetDir ;	// 生成代码存放目录

    public static GenerateConfig config;

    public static void init(String fileName) throws IOException {
        if (config == null) {
            Properties pro = new Properties();
            //this.class.getClassLoader().getResource(
            pro.load(new FileInputStream(new File(fileName)));
            config = new GenerateConfig();
            config.setDbHost(pro.getProperty("db.host"));
            config.setDbPort(Integer.parseInt(pro.getProperty("db.port")));
            config.setDbName(pro.getProperty("db.database"));
            config.setDbUser(pro.getProperty("db.username"));
            config.setDbPass(pro.getProperty("db.password"));
            config.setDbTablePrefix(pro.getProperty("db.table.prefix"));
            config.setTargetDir(pro.getProperty("target.dir"));
        }
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbHost() {
        return dbHost;
    }

    public void setDbHost(String dbHost) {
        this.dbHost = dbHost;
    }

    public int getDbPort() {
        return dbPort;
    }

    public void setDbPort(int dbPort) {
        this.dbPort = dbPort;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPass() {
        return dbPass;
    }

    public void setDbPass(String dbPass) {
        this.dbPass = dbPass;
    }

    public String getDbTablePrefix() {
        return dbTablePrefix;
    }

    public void setDbTablePrefix(String dbTablePrefix) {
        this.dbTablePrefix = dbTablePrefix;
    }

    public String getTargetDir() {
        return targetDir;
    }

    public void setTargetDir(String targetDir) {
        this.targetDir = targetDir;
    }
}
