package com.mellivorines.generator.config.query

import com.github.xiaoymin.knife4j.core.util.StrUtil
import com.mellivorines.generator.constants.DbType

class OracleQuery : AbstractQuery {
    override fun dbType(): DbType? {
        return DbType.Oracle
    }

    override fun tableSql(tableName: String?): String? {
        val sql = StringBuilder()
        sql.append("select dt.table_name, dtc.comments from user_tables dt,user_tab_comments dtc ")
        sql.append("where dt.table_name = dtc.table_name ")
        // 表名查询
        if (StrUtil.isNotBlank(tableName)) {
            sql.append("and dt.table_name = '").append(tableName).append("' ")
        }
        sql.append("order by dt.table_name asc")
        return sql.toString()
    }

    override fun tableName(): String? {
        return "table_name"
    }

    override fun tableComment(): String? {
        return "comments"
    }

    override fun tableFieldsSql(): String? {
        return ("SELECT A.COLUMN_NAME, A.DATA_TYPE, B.COMMENTS,DECODE(C.POSITION, '1', 'PRI') KEY FROM ALL_TAB_COLUMNS A "
                + " INNER JOIN ALL_COL_COMMENTS B ON A.TABLE_NAME = B.TABLE_NAME AND A.COLUMN_NAME = B.COLUMN_NAME AND B.OWNER = '#schema'"
                + " LEFT JOIN ALL_CONSTRAINTS D ON D.TABLE_NAME = A.TABLE_NAME AND D.CONSTRAINT_TYPE = 'P' AND D.OWNER = '#schema'"
                + " LEFT JOIN ALL_CONS_COLUMNS C ON C.CONSTRAINT_NAME = D.CONSTRAINT_NAME AND C.COLUMN_NAME=A.COLUMN_NAME AND C.OWNER = '#schema'"
                + "WHERE A.OWNER = '#schema' AND A.TABLE_NAME = '%s' ORDER BY A.COLUMN_ID ")
    }

    override fun fieldName(): String? {
        return "COLUMN_NAME"
    }

    override fun fieldType(): String? {
        return "DATA_TYPE"
    }

    override fun fieldComment(): String? {
        return "COMMENTS"
    }

    override fun fieldKey(): String? {
        return "KEY"
    }
}