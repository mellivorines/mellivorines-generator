<#if module??>
package ${PackageName}.config;
import ${PackageName}.entity.JimmerModule;
<#else>
package ${PackageName}.config;
import ${PackageName}.${module}.entity.JimmerModule;
</#if>
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.dialect.MySqlDialect;
import org.babyfish.jimmer.sql.runtime.ConnectionManager;
import org.babyfish.jimmer.sql.runtime.Executor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.function.Function;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.function.Function;

@Configuration
public class SqlClientConfig {
    @Bean
    public JSqlClient sqlClient(DataSource dataSource) {
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
                .setEntityManager(JimmerModule.ENTITY_MANAGER)
                .build();
    }
}
