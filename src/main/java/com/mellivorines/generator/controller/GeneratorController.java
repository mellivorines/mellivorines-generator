package com.mellivorines.generator.controller;

import cn.hutool.core.io.IoUtil;
import com.mellivorines.generator.constants.CommonConstant;
import com.mellivorines.generator.service.GeneratorService;
import com.mellivorines.generator.utils.FreemarkerUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipOutputStream;

@RestController
@Api(tags = "代码生成相关")
@RequestMapping("code/generator")
public class GeneratorController {

    @Resource
    GeneratorService generatorService;

    @GetMapping(value = "/module")
    @ApiOperation("生成模块")
    @ResponseBody
    public void generateModule() throws Exception {


        String templateFilePath = CommonConstant.TEMPLATE_FILE_BASE_PATH + CommonConstant.SLASH + CommonConstant.GeneratorType.MODULE;
        String templateFileName = "Controller.java";
        String outFileClassPath = "src/main";
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("package", "");
        dataModel.put("module", "");
        dataModel.put("ClassName", "baseClass");
        dataModel.put("isSwagger", false);

        FreemarkerUtil.generatorByCustom(templateFilePath, templateFileName, dataModel, outFileClassPath + CommonConstant.SLASH + "Controller.java");

    }

    @GetMapping(value = "/project")
    @ApiOperation("生成模块")
    @ResponseBody
    public void generateProject() throws Exception {

        String templateFilePath = CommonConstant.TEMPLATE_FILE_BASE_PATH + CommonConstant.SLASH + CommonConstant.GeneratorType.PROJECT;
        String templateFileName = "build.gradle";
        String outFileClassPath = "src/main";

        Map<String, Object> dataModel = new HashMap<>();

        dataModel.put("rootProject", "mellivorines");
        FreemarkerUtil.initConfig(templateFilePath, templateFileName);
        FreemarkerUtil.generator(dataModel, outFileClassPath + CommonConstant.SLASH + "build.gradle");

    }

    /**
     * 生成代码（zip压缩包）
     *
     * @param tableIds 表名
     * @param response 响应体
     * @throws Exception 异常
     */
    @ApiOperation("生成zip")
    @GetMapping("/download")
    public void download(String tableIds, HttpServletResponse response) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        // 生成代码
        for (String tableId : tableIds.split(CommonConstant.SEMICOLON)) {
            generatorService.downloadCode(Integer.valueOf(tableId), zip);
        }

        IoUtil.close(zip);

        // zip压缩包数据
        byte[] data = outputStream.toByteArray();

        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"project.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IoUtil.write(response.getOutputStream(), false, data);
    }
}
