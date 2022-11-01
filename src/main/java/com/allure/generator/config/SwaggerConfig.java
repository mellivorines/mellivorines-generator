
package com.allure.generator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder().contact(new Contact("allure", "", "lilinxi015@163.com"))
                        .title("allure代码生成器").build())
                .select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.regex("(?!/error.*).*")).build()
                .groupName("allure");
    }

}
