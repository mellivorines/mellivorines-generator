
package com.mellivorines.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;

/**
 * 功能描述:程序启动类
 *
 * @author lilinxi
 * @since 2022-10-19
 */
@SpringBootApplication
@EnableKnife4j
@MapperScan("com.mellivorines.generator.repository.mapper")
public class GeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneratorApplication.class, args);
    }

}
