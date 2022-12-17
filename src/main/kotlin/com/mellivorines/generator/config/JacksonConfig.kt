package com.mellivorines.generator.config

import org.babyfish.jimmer.jackson.ImmutableModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JacksonConfig {
    @Bean
    fun immutableModule(): ImmutableModule = ImmutableModule()
}