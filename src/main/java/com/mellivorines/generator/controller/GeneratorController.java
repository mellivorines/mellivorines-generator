package com.mellivorines.generator.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "代码生成相关")
@RequestMapping("code/generator")
public class GeneratorController {

    private static final String CLASS_PATH = "src/main";

    @GetMapping(value = "/dir")
    @ApiOperation("代码生成相关")
    @ResponseBody
    public void codeGenerator() throws Exception {

        Configuration configuration = new Configuration();

        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/template/java/project"));

        Map<String, Object> dataModel = new HashMap<>();

        dataModel.put("projectName", "asda");

        Template template = configuration.getTemplate("settings.gradle.ftl");

        File docFile = new File(CLASS_PATH + "\\" + "settings.gradle.gradle");

        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
        // 6、调用模板对象的process方法，生成文件。
        template.process(dataModel, out);
        out.flush();
        // 7、关闭流。
        out.close();
    }
}
