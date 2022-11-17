package com.mellivorines.generator.service.impl;

import com.mellivorines.generator.constants.CommonConstant;
import com.mellivorines.generator.constants.TemplateConstant;
import com.mellivorines.generator.service.GeneratorService;
import com.mellivorines.generator.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipOutputStream;

@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Override
    public void downloadCode(Integer tableId, ZipOutputStream zip) {
        //1.数据模型
        Map<String, Object> dataModel = getDataModel(tableId);
        //2.代码生成器信息
        //3.渲染模板并输出
        //4.添加到zip

    }

    @Override
    public void generatorCode(Integer tableId) {
        //1.数据模型
        //2.代码生成器信息
        //3.渲染模板并输出
    }

    private Map<String, Object> getDataModel(Integer tableId) {
        //1.表信息

        //2.数据模型
        Map<String, Object> dataModel = new HashMap<>();
        /*是否开启swagger*/
        dataModel.put(TemplateConstant.SWAGGER, true);

        //3.项目信息
        //3.1打包信息
        dataModel.put(TemplateConstant.PACKAGE, null);
        dataModel.put(TemplateConstant.PROJECT, null);
        //3.2项目的工程信息
        dataModel.put(TemplateConstant.GROUP, null);
        dataModel.put(TemplateConstant.ARTIFACT, null);
        dataModel.put(TemplateConstant.VERSION, null);

        //4.开发者信息
        dataModel.put(TemplateConstant.AUTHOR, null);
        dataModel.put(TemplateConstant.EMAIL, null);
        dataModel.put(TemplateConstant.URL, null);
        dataModel.put(TemplateConstant.TELEPHONE, null);
        dataModel.put(CommonConstant.DATE_TIME, DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
        dataModel.put(CommonConstant.DATE, DateUtils.format(new Date(), DateUtils.DATE_PATTERN));


        //5.设置字段分类

        //6.设置基类信息

        //7.导入的包列表

        //8.表信息

        //9.生成路径


        return dataModel;
    }
}
