package com.mellivorines.generator.config.query

import com.mellivorines.generator.constants.DbType

interface AbstractQuery {
    /**
     * 数据库类型
     */
    fun dbType(): DbType?

    /**
     * 表信息查询 SQL
     */
    fun tableSql(tableName: String?): String?

    /**
     * 表名称
     */
    fun tableName(): String?

    /**
     * 表注释
     */
    fun tableComment(): String?

    /**
     * 表字段信息查询 SQL
     */
    fun tableFieldsSql(): String?

    /**
     * 字段名称
     */
    fun fieldName(): String?

    /**
     * 字段类型
     */
    fun fieldType(): String?

    /**
     * 字段注释
     */
    fun fieldComment(): String?

    /**
     * 主键字段
     */
    fun fieldKey(): String?
}