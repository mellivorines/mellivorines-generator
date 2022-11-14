package com.mellivorines.generator.utils;

import com.mellivorines.generator.config.GenDataSource;
import com.mellivorines.generator.constants.DbType;
import oracle.jdbc.driver.OracleConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final int CONNECTION_TIMEOUTS_SECONDS = 6;

    public static Connection getConnection(GenDataSource dataSource) throws ClassNotFoundException, SQLException {
        DriverManager.setLoginTimeout(CONNECTION_TIMEOUTS_SECONDS);
        Class.forName(dataSource.getDbType().getDriverClass());

        Connection connection = DriverManager.getConnection(dataSource.getConnUrl(), dataSource.getUsername(), dataSource.getPassword());
        if (dataSource.getDbType() == DbType.Oracle) {
            ((OracleConnection) connection).setRemarksReporting(true);
        }

        return connection;
    }
}
