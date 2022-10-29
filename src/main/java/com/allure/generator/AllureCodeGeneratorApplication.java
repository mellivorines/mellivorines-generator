
package com.allure.generator;

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
@MapperScan("com.allure.generator.repository.mapper")
public class AllureCodeGeneratorApplication {

    public static void main(String[] args) {
        System.out.println("http://localhost:3000/doc.html");
        SpringApplication.run(AllureCodeGeneratorApplication.class, args);
    }

}
