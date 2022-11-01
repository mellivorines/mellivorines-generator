
package com.mellivorines.generator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 功能描述:swagger配置
 *
 * @author lilinxi
 * @since 2022-10-19
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder().contact(new Contact("mellivorines", "", "lilinxi015@163.com"))
                        .title("mellivorines代码生成器").build())
                .select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.regex("(?!/error.*).*")).build()
                .groupName("mellivorines");
    }

}
