package com.mellivorines.generator.service.impl;

import com.mellivorines.generator.constants.CommonConstant;
import com.mellivorines.generator.constants.TemplateConstant;
import com.mellivorines.generator.dao.GenTableDao;
import com.mellivorines.generator.dao.GenTableFieldDao;
import com.mellivorines.generator.entity.GenAuthor;
import com.mellivorines.generator.entity.GenConfig;
import com.mellivorines.generator.entity.GenTable;
import com.mellivorines.generator.entity.GenTableField;
import com.mellivorines.generator.service.GeneratorService;
import com.mellivorines.generator.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Resource
    GenTableDao genTableDao;

    @Resource
    GenTableFieldDao genTableFieldDao;

    @Override
    public void downloadCode(GenConfig genConfig, GenAuthor genAuthor, Integer tableId, ZipOutputStream zip) {
        //1.数据模型
        Map<String, Object> dataModel = getDataModel(genConfig,genAuthor,tableId);
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

    private Map<String, Object> getDataModel(GenConfig genConfig, GenAuthor genAuthor, Integer tableId) {
        //1.表信息
        GenTable genTable = genTableDao.findById(GenTable.class, tableId).get();
        List<GenTableField> genTableFieldList = genTableFieldDao.findAllByTableID(GenTableField.class, genTable.id());
        //2.数据模型
        Map<String, Object> dataModel = new HashMap<>();
        /*是否开启swagger*/
        dataModel.put(TemplateConstant.SWAGGER, true);

        //项目信息
        //打包信息
        dataModel.put(TemplateConstant.PACKAGE, genConfig.project());
        dataModel.put(TemplateConstant.PROJECT, genConfig.project());
        //项目的工程信息
        dataModel.put(TemplateConstant.GROUP, genConfig.group());
        dataModel.put(TemplateConstant.ARTIFACT, genConfig.artifact());
        dataModel.put(TemplateConstant.VERSION, genConfig.version());

        //开发者信息
        dataModel.put(TemplateConstant.AUTHOR, genAuthor.author());
        dataModel.put(TemplateConstant.EMAIL, genAuthor.email());
        dataModel.put(TemplateConstant.URL, genAuthor.url());
        dataModel.put(TemplateConstant.TELEPHONE, genAuthor.telephone());
        dataModel.put(CommonConstant.DATE_TIME, DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
        dataModel.put(CommonConstant.DATE, DateUtils.format(new Date(), DateUtils.DATE_PATTERN));

        //表信息
        dataModel.put("tableName", genTable.tableName());// 表名
        dataModel.put("tableComment", genTable.tableComment());// 表描述
        dataModel.put("fieldList",genTableFieldList);// 表字段

        //5.设置字段分类

        //6.设置基类信息

        //7.导入的包列表


        //9.生成路径


        return dataModel;
    }
}
