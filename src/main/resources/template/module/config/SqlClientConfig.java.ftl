package com.mellivorines.generator.config;

import com.mellivorines.generator.GeneratorApplication;
import com.mellivorines.generator.entity.BaseClass;
import com.mellivorines.generator.entity.UserInfo;
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.dialect.MySqlDialect;
import org.babyfish.jimmer.sql.runtime.ConnectionManager;
import org.babyfish.jimmer.sql.runtime.EntityManager;
import org.babyfish.jimmer.sql.runtime.Executor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.function.Function;

@Configuration
public class SqlClientConfig {
@Bean
public JSqlClient sqlClient(
DataSource dataSource
) {
JSqlClient sqlClient = JSqlClient.newBuilder()
.setConnectionManager(
new ConnectionManager() {
@Override
public <R> R execute(Function<Connection, R> block) {
    Connection con = DataSourceUtils.getConnection(dataSource);
    try {
    return block.apply(con);
    } finally {
    DataSourceUtils.releaseConnection(con, dataSource);
    }
    }
    }
    )
    .setDialect(new MySqlDialect())
    .setExecutor(Executor.log())
    .setEntityManager(
    new EntityManager(
    GeneratorApplication.class.getClassLoader(),
    UserInfo.class.getPackage().getName(),
    BaseClass.class.getPackage().getName()
    )
    )
    .build();
    return sqlClient;
    }
    }
