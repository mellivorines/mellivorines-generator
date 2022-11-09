<#if module??>
package ${PackageName}.config;
<#else>
package ${PackageName}.config;
</#if>

import org.babyfish.jimmer.jackson.ImmutableModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {
    @Bean
    public ImmutableModule immutableModule() {
        return new ImmutableModule();
    }
}
