package com.mellivorines.generator.config

import com.mellivorines.generator.constants.UserInfoConstant
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class SwaggerConfig {
    @Bean
    fun docket(): Docket {
        return Docket(DocumentationType.OAS_30)
                .apiInfo(
                        ApiInfoBuilder()
                                .contact(Contact(UserInfoConstant.AUTHOR, UserInfoConstant.URL, UserInfoConstant.EMAIL))
                                .title(UserInfoConstant.TITLE)
                                .build()
                )
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("(?!/error.*).*")).build()
                .groupName(UserInfoConstant.AUTHOR)
    }
}