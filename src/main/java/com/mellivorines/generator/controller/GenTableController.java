package com.mellivorines.generator.controller;

import com.mellivorines.generator.config.MyDataSource;
import com.mellivorines.generator.constants.DbType;
import com.mellivorines.generator.dao.GenDatasourceDao;
import com.mellivorines.generator.dao.GenTableDao;
import com.mellivorines.generator.entity.GenDatasource;
import com.mellivorines.generator.model.GenDatasourceModel;
import com.mellivorines.generator.model.GenTableModel;
import com.mellivorines.generator.utils.DatabaseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = "表名")
@RequestMapping("api/table")
public class GenTableController {
    @Resource
    GenTableDao genTableDao;

    @Resource
    GenDatasourceDao datasourceDao;

    @ApiOperation("根据数据源ID，获取全部数据表")
    @GetMapping("/{id}")
    public boolean tableList(@PathVariable("id") Long id) {
        try {
            GenDatasource genDatasource = datasourceDao.findById(GenDatasource.class, id).get();
            GenDatasourceModel genDatasourceModel = new GenDatasourceModel();
            BeanUtils.copyProperties(genDatasource, genDatasourceModel);
            MyDataSource myDataSource = new MyDataSource(genDatasourceModel);
            myDataSource.setDbType(DbType.MySQL);
            List<GenTableModel> tableList = DatabaseUtil.getTableList(myDataSource);
            tableList.forEach(genTableModel -> genTableDao.save(genTableModel.toGenTable()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
