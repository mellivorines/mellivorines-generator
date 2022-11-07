package com.mellivorines.generator.controller;

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

    private static final String classPath = "src/main";
    private static final String ftlPath = "src/main/resources/template/project";
    private static final String ftlName = "build.gradle";

    @GetMapping(value = "/module")
    @ApiOperation("生成模块")
    @ResponseBody
    public void codeGenerator() throws Exception {

        Map<String, Object> dataModel = new HashMap<>();

        dataModel.put("rootProject", "lilinxi");

        FreemarkerUtil.generatorByCustom(ftlName,ftlPath,dataModel,classPath+"/"+"build.gradle");

    }
}
