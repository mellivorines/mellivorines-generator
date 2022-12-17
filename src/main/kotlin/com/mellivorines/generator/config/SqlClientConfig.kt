package com.mellivorines.generator.config

import com.mellivorines.generator.entity.ENTITY_MANAGER
import org.babyfish.jimmer.sql.dialect.MySqlDialect
import org.babyfish.jimmer.sql.kt.KSqlClient
import org.babyfish.jimmer.sql.kt.newKSqlClient
import org.babyfish.jimmer.sql.runtime.Executor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DataSourceUtils
import java.sql.Connection
import javax.sql.DataSource

@Configuration
class SqlClientConfig {
    @Bean
    fun sqlClient(dataSource: DataSource): KSqlClient {
        return newKSqlClient {
            setConnectionManager {
                val con: Connection = DataSourceUtils.getConnection(dataSource)
                try {
                    proceed(con)
                } finally {
                    DataSourceUtils.releaseConnection(con, dataSource)
                }
            }
            setExecutor(Executor.log())
            setDialect(MySqlDialect())
            setEntityManager(ENTITY_MANAGER)
        }
    }
}