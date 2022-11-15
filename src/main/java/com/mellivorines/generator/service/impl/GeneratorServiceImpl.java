package com.mellivorines.generator.service.impl;

import com.mellivorines.generator.service.GeneratorService;
import org.springframework.stereotype.Service;

import java.util.zip.ZipOutputStream;

@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Override
    public void downloadCode(Long tableId, ZipOutputStream zip) {
        //1.数据模型
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
}
