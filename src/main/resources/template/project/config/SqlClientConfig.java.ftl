<#if module??>
package ${PackageName}.config;
import ${PackageName}.${project}Application;
import ${PackageName}.entity.BaseEntity;
<#else>
package ${PackageName}.config;
import ${PackageName}.${module}.${project}Application;
import ${PackageName}.${module}.entity.BaseEntity;
</#if>
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
        return JSqlClient.newBuilder()
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
                                BaseEntity.class.getPackage().getName()
                        )
                )
                .build();
    }
}
