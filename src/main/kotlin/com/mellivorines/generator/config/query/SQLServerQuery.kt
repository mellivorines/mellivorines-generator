package com.mellivorines.generator.config.query

import com.github.xiaoymin.knife4j.core.util.StrUtil
import com.mellivorines.generator.constants.DbType

class SQLServerQuery : AbstractQuery {
    override fun dbType(): DbType? {
        return DbType.SQLServer
    }

    override fun tableSql(tableName: String?): String? {
        val sql = StringBuilder()
        sql.append("SELECT DISTINCT d.name as table_name, f.value as table_comment FROM syscolumns a " +
                "LEFT JOIN systypes b ON a.xusertype= b.xusertype " +
                "INNER JOIN sysobjects d ON a.id= d.id  AND d.xtype= 'U' AND d.name<> 'dtproperties' " +
                "LEFT JOIN syscomments e ON a.cdefault= e.id " +
                "LEFT JOIN sys.extended_properties g ON a.id= g.major_id AND a.colid= g.minor_id " +
                "LEFT JOIN sys.extended_properties f ON d.id= f.major_id AND f.minor_id= 0 ")
        sql.append("where 1=1 ")
        // 表名查询
        if (StrUtil.isNotBlank(tableName)) {
            sql.append("and d.name = '").append(tableName).append("' ")
        }
        sql.append("order by d.name asc")
        return sql.toString()
    }

    override fun tableName(): String? {
        return "table_name"
    }

    override fun tableComment(): String? {
        return "table_comment"
    }

    override fun tableFieldsSql(): String? {
        return " Select SCOL.NAME as column_name, STYPE.NAME AS data_type , (case when(\n" +
                "  SELECT COUNT (*) AS Is_PK\n" +
                " FROM syscolumns\n" +
                " JOIN sysindexkeys ON syscolumns.id = sysindexkeys.id AND syscolumns.colid = sysindexkeys.colid\n" +
                " JOIN sysindexes ON syscolumns.id = sysindexes.id AND sysindexkeys.indid = sysindexes.indid\n" +
                " JOIN sysobjects ON sysindexes.name = sysobjects.name AND sysobjects.xtype = 'PK'\n" +
                " WHERE syscolumns.name = SCOL.NAME AND syscolumns.id = SCOL.ID\n" +
                " ) > 0 then 'PRI' else '' end) column_key,    \n" +
                "\t(SELECT SYS.EXTENDED_PROPERTIES.VALUE FROM SYSCOLUMNS  \n" +
                "\tINNER JOIN SYS.EXTENDED_PROPERTIES ON SYSCOLUMNS.ID = SYS.EXTENDED_PROPERTIES.MAJOR_ID   \n" +
                "\tAND SYSCOLUMNS.COLID = SYS.EXTENDED_PROPERTIES.MINOR_ID \n" +
                "\tINNER JOIN SYSOBJECTS ON SYSCOLUMNS.ID = SYSOBJECTS.ID  \n" +
                "\tWHERE SYSOBJECTS.NAME = SO.NAME AND SYSCOLUMNS.NAME = SCOL.NAME) AS column_comment  \n" +
                "\tfrom SYSCOLUMNS AS SCOL\n" +
                "\tLEFT JOIN SYSOBJECTS SO ON SO.ID=SCOL.ID \n" +
                "\tLEFT JOIN SYSTYPES AS STYPE ON STYPE.xtype=SCOL.xtype\n" +
                "\tWhere \n" +
                "\tSCOL.ID=OBJECT_ID('%s')\n" +
                "\tAND STYPE.NAME<>'SYSNAME'"
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