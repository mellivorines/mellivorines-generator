package com.mellivorines.generator.service.impl;

import com.mellivorines.generator.service.GeneratorService;
import org.springframework.stereotype.Service;

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
    public void generatorCode(Long tableId) {
        //1.数据模型
        //2.代码生成器信息
        //3.渲染模板并输出
    }

    private Map<String, Object> getDataModel(Integer tableId) {
        //1.表信息

        //2.数据模型
        Map<String, Object> dataModel = new HashMap<>();

        //3.项目信息

        //4.开发者信息

        //5.设置字段分类

        //6.设置基类信息

        //7.导入的包列表

        //8.表信息

        //9.生成路径


        return dataModel;
    }
}
