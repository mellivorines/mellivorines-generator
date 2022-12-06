package com.mellivorines.generator.utils;

import cn.hutool.core.util.StrUtil;
import com.mellivorines.generator.config.MyDataSource;
import com.mellivorines.generator.config.query.AbstractQuery;
import com.mellivorines.generator.constants.CommonConstant;
import com.mellivorines.generator.constants.DbType;
import com.mellivorines.generator.exception.BizException;
import com.mellivorines.generator.model.GenTableFieldModel;
import com.mellivorines.generator.model.GenTableModel;
import oracle.jdbc.driver.OracleConnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtil {

    private static final int CONNECTION_TIMEOUTS_SECONDS = 6;

    public static Connection getConnection(MyDataSource dataSource) throws ClassNotFoundException, SQLException {
        DriverManager.setLoginTimeout(CONNECTION_TIMEOUTS_SECONDS);
        Class.forName(dataSource.getDbType().getDriverClass());

        Connection connection = DriverManager.getConnection(dataSource.getConnUrl(), dataSource.getUsername(), dataSource.getPassword());
        if (dataSource.getDbType() == DbType.Oracle) {
            ((OracleConnection) connection).setRemarksReporting(true);
        }

        return connection;
    }

    /**
     * 根据数据源，获取全部数据表
     *
     * @param datasource 数据源
     */
    public static List<GenTableModel> getTableList(MyDataSource datasource) {
        List<GenTableModel> genTableModels = new ArrayList<>();
        try {
            AbstractQuery query = datasource.getDbQuery();

            //查询数据
            PreparedStatement preparedStatement = datasource.getConnection().prepareStatement(query.tableSql(null));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GenTableModel genTableModel = new GenTableModel();
                genTableModel.setId(0);
                genTableModel.setTableName(resultSet.getString(query.tableName()));
                genTableModel.setTableComment(resultSet.getString(query.tableComment()));
                genTableModel.setDatabaseId(datasource.getId());
                genTableModels.add(genTableModel);
            }

            datasource.getConnection().close();
        } catch (Exception e) {
            throw new BizException("exception:{}", e);
        }

        return genTableModels;
    }

    /**
     * 根据数据源，获取指定数据表
     *
     * @param datasource 数据源
     * @param tableName  表名
     */
    public static GenTableModel getTable(MyDataSource datasource, String tableName) {
        try {
            AbstractQuery query = datasource.getDbQuery();

            // 查询数据
            PreparedStatement preparedStatement = datasource.getConnection().prepareStatement(query.tableSql(tableName));
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                GenTableModel genTableModel = new GenTableModel();
                genTableModel.setId(0);
                genTableModel.setTableName(rs.getString(query.tableName()));
                genTableModel.setTableComment(rs.getString(query.tableComment()));
                genTableModel.setDatabaseId(datasource.getId());
                return genTableModel;
            }
        } catch (Exception e) {
            throw new BizException("exception:{}", e);
        }

        throw new BizException("数据表不存在：" + tableName);
    }

    /**
     * 获取表字段列表
     *
     * @param datasource 数据源
     * @param tableId    表ID
     * @param tableName  表名
     */
    public static List<GenTableFieldModel> getTableFieldList(MyDataSource datasource, Integer tableId, String tableName) {
        List<GenTableFieldModel> genTableFieldModels = new ArrayList<>();

        try {
            AbstractQuery query = datasource.getDbQuery();
            String tableFieldsSql = query.tableFieldsSql();
            if (datasource.getDbType() == DbType.Oracle) {
                DatabaseMetaData md = datasource.getConnection().getMetaData();
                tableFieldsSql = String.format(tableFieldsSql.replace("#schema", md.getUserName()), tableName);
            } else {
                tableFieldsSql = String.format(tableFieldsSql, tableName);
            }
            PreparedStatement preparedStatement = datasource.getConnection().prepareStatement(tableFieldsSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GenTableFieldModel genTableFieldModel = new GenTableFieldModel();
                genTableFieldModel.setId(0);
                genTableFieldModel.setTableId(tableId);
                genTableFieldModel.setColumnName(resultSet.getString(query.fieldName()));
                String fieldType = resultSet.getString(query.fieldType());
                if (fieldType.contains(CommonConstant.SPACE)) {
                    fieldType = fieldType.substring(0, fieldType.indexOf(CommonConstant.SPACE));
                }
                genTableFieldModel.setDataType(fieldType);
                genTableFieldModel.setColumnComment(resultSet.getString(query.fieldComment()));
                String key = resultSet.getString(query.fieldKey());
                genTableFieldModel.setColumnKey(key);

                genTableFieldModels.add(genTableFieldModel);
            }
        } catch (Exception e) {
            throw new BizException("exception:{}", e);
        }

        return genTableFieldModels;
    }

    /**
     * 获取模块名
     *
     * @param packageName 包名
     * @return 模块名
     */
    public static String getModuleName(String packageName) {
        return StrUtil.subAfter(packageName, CommonConstant.POINT, true);
    }

    /**
     * 获取功能名
     *
     * @param tableName 表名
     * @return 功能名
     */
    public static String getFunctionName(String tableName) {
        String functionName = StrUtil.subAfter(tableName, CommonConstant.HORIZONTAL, true);
        if (StrUtil.isBlank(functionName)) {
            functionName = tableName;
        }

        return functionName;
    }

}
