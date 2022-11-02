
package com.mellivorines.generator;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 功能描述:程序启动类
 *
 * @author lilinxi
 * @since 2022-10-19
 */
@SpringBootApplication
@EnableKnife4j
public class GeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneratorApplication.class, args);
    }

}
