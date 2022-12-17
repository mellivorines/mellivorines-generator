package com.mellivorines.generator.config.query

import com.github.xiaoymin.knife4j.core.util.StrUtil
import com.mellivorines.generator.constants.DbType

class PostgreSqlQuery : AbstractQuery {
    override fun dbType(): DbType? {
        return DbType.PostgreSQL
    }

    override fun tableSql(tableName: String?): String? {
        val sql = StringBuilder()
        sql.append("select t1.tablename, obj_description(relfilenode, 'pg_class') as comments from pg_tables t1, pg_class t2 ")
        sql.append("where t1.tablename not like 'pg%' and t1.tablename not like 'sql_%' and t1.tablename = t2.relname ")
        // 表名查询
        if (StrUtil.isNotBlank(tableName)) {
            sql.append("and t1.tablename = '").append(tableName).append("' ")
        }
        return sql.toString()
    }

    override fun tableFieldsSql(): String? {
        return ("select t2.attname as columnName, pg_type.typname as dataType, col_description(t2.attrelid,t2.attnum) as columnComment,"
                + "(CASE t3.contype WHEN 'p' THEN 'PRI' ELSE '' END) as columnKey "
                + "from pg_class as t1, pg_attribute as t2 inner join pg_type on pg_type.oid = t2.atttypid "
                + "left join pg_constraint t3 on t2.attnum = t3.conkey[1] and t2.attrelid = t3.conrelid "
                + "where t1.relname = '%s' and t2.attrelid = t1.oid and t2.attnum>0")
    }

    override fun tableName(): String? {
        return "tablename"
    }

    override fun tableComment(): String? {
        return "comments"
    }

    override fun fieldName(): String? {
        return "columnName"
    }

    override fun fieldType(): String? {
        return "dataType"
    }

    override fun fieldComment(): String? {
        return "columnComment"
    }

    override fun fieldKey(): String? {
        return "columnKey"
    }
}