package com.mellivorines.generator

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableKnife4j
class GeneratorApplication

fun main(args: Array<String>) {
    runApplication<GeneratorApplication>(*args)
}
