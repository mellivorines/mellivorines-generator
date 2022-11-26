package com.mellivorines.generator.config;

import com.mellivorines.generator.config.query.*;
import com.mellivorines.generator.constants.DbType;
import com.mellivorines.generator.entity.GenDatasourceTable;
import com.mellivorines.generator.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
public class MyDataSource {
    /**
     * 数据源ID
     */
    private Integer id;
    /**
     * 数据库类型
     */
    private DbType dbType;
    /**
     * 数据库URL
     */
    private String connUrl;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    private AbstractQuery dbQuery;

    private Connection connection;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DbType getDbType() {
        return dbType;
    }

    public void setDbType(DbType dbType) {
        this.dbType = dbType;
    }

    public String getConnUrl() {
        return connUrl;
    }

    public void setConnUrl(String connUrl) {
        this.connUrl = connUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AbstractQuery getDbQuery() {
        return dbQuery;
    }

    public void setDbQuery(AbstractQuery dbQuery) {
        this.dbQuery = dbQuery;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    public MyDataSource(GenDatasourceTable genDatasourceTable) {
        this.id = Integer.valueOf(genDatasourceTable.id().toString());
        this.dbType = DbType.valueOf(genDatasourceTable.dbType().toString());
        this.connUrl = String.valueOf(genDatasourceTable.connUrl());
        this.username = genDatasourceTable.username().toString();
        this.password = genDatasourceTable.password().toString();

        if (dbType == DbType.MySQL) {
            this.dbQuery = new MySqlQuery();
        } else if (dbType == DbType.Oracle) {
            this.dbQuery = new OracleQuery();
        } else if (dbType == DbType.PostgreSQL) {
            this.dbQuery = new PostgreSqlQuery();
        } else if (dbType == DbType.SQLServer) {
            this.dbQuery = new SQLServerQuery();
        }

        try {
            this.connection = DatabaseUtil.getConnection(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MyDataSource(Connection connection) throws SQLException {
        this.id = 0;
        this.dbType = DbType.valueOf(connection.getMetaData().getDatabaseProductName());

        if (dbType == DbType.MySQL) {
            this.dbQuery = new MySqlQuery();
        } else if (dbType == DbType.Oracle) {
            this.dbQuery = new OracleQuery();
        } else if (dbType == DbType.PostgreSQL) {
            this.dbQuery = new PostgreSqlQuery();
        } else if (dbType == DbType.SQLServer) {
            this.dbQuery = new SQLServerQuery();
        }

        this.connection = connection;
    }
}
