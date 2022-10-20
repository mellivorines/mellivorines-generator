
package com.allure.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;

@SpringBootApplication
@EnableKnife4j
@MapperScan("com.allure.generator.repository.mapper")
public class AllureCodeGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AllureCodeGeneratorApplication.class, args);
    }

}
