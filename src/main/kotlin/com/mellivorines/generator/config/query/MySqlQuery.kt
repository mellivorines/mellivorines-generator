package com.mellivorines.generator.config.query

import com.github.xiaoymin.knife4j.core.util.StrUtil
import com.mellivorines.generator.constants.DbType

class MySqlQuery : AbstractQuery {
    override fun dbType(): DbType? {
        return DbType.MySQL
    }

    override fun tableSql(tableName: String?): String? {
        val sql = StringBuilder()
        sql.append("select table_name, table_comment from information_schema.tables ")
        sql.append("where table_schema = (select database()) ")
        // 表名查询
        if (StrUtil.isNotBlank(tableName)) {
            sql.append("and table_name = '").append(tableName).append("' ")
        }
        sql.append("order by table_name asc")
        return sql.toString()
    }

    override fun tableName(): String? {
        return "table_name"
    }

    override fun tableComment(): String? {
        return "table_comment"
    }

    override fun tableFieldsSql(): String? {
        return ("select column_name, data_type, column_comment, column_key from information_schema.columns "
                + "where table_name = '%s' and table_schema = (select database()) order by ordinal_position")
    }

    override fun fieldName(): String? {
        return "column_name"
    }

    override fun fieldType(): String? {
        return "data_type"
    }

    override fun fieldComment(): String? {
        return "column_comment"
    }

    override fun fieldKey(): String? {
        return "column_key"
    }
}