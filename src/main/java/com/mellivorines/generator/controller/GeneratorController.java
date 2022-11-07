package com.mellivorines.generator.controller;

import com.mellivorines.generator.constants.CommonConstant;
import com.mellivorines.generator.utils.FreemarkerUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "代码生成相关")
@RequestMapping("code/generator")
public class GeneratorController {

    private static final String ftlPath = "src/main/resources/template";

    @GetMapping(value = "/module")
    @ApiOperation("生成模块")
    @ResponseBody
    public void generateModule() throws Exception {

        String templateFilePath = ftlPath + CommonConstant.SLASH + CommonConstant.GeneratorType.MODULE;
        String templateFileName = "build.gradle";
        String outFileClassPath = "src/main";

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("rootProject", "lilinxi");

        FreemarkerUtil.generatorByCustom(templateFilePath, templateFileName, dataModel, outFileClassPath + CommonConstant.SLASH + "build.gradle");

    }

    @GetMapping(value = "/project")
    @ApiOperation("生成模块")
    @ResponseBody
    public void generateProject() throws Exception {

        String templateFilePath = ftlPath + CommonConstant.SLASH + CommonConstant.GeneratorType.PROJECT;
        String templateFileName = "build.gradle";
        String outFileClassPath = "src/main";

        Map<String, Object> dataModel = new HashMap<>();

        dataModel.put("rootProject", "lilinxi");
        FreemarkerUtil.initConfig(templateFilePath, templateFileName);
        FreemarkerUtil.generator(dataModel, outFileClassPath + CommonConstant.SLASH + "build.gradle");

    }
}
