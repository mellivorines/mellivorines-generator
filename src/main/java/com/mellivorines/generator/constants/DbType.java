package com.mellivorines.generator.constants;

public enum DbType {
    SQLServer("com.microsoft.sqlserver.jdbc.SQLServerDriver"),
    MySQL("com.mysql.cj.jdbc.Driver"),
    Oracle("oracle.jdbc.driver.OracleDriver"),
    PostgreSQL("org.postgresql.Driver");

    private final String driverClass;

    DbType(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getDriverClass() {
        return driverClass;
    }
}
