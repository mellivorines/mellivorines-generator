package com.mellivorines.generator.controller;

import com.mellivorines.generator.config.MyDataSource;
import com.mellivorines.generator.constants.DbType;
import com.mellivorines.generator.dao.GenDatasourceDao;
import com.mellivorines.generator.dao.GenTableDao;
import com.mellivorines.generator.entity.GenDatasource;
import com.mellivorines.generator.entity.GenDatasourceTable;
import com.mellivorines.generator.entity.GenTable;
import com.mellivorines.generator.model.GenDatasourceModel;
import com.mellivorines.generator.model.GenTableModel;
import com.mellivorines.generator.utils.DatabaseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.babyfish.jimmer.sql.ast.mutation.BatchSaveResult;
import org.babyfish.jimmer.sql.ast.mutation.DeleteResult;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(tags = "数据源")
@RequestMapping("api/datasource")
public class GenDatasourceController {
    @Resource
    GenDatasourceDao datasourceDao;

    @Resource
    GenTableDao genTableDao;

    @GetMapping(value = "/list")
    @ApiOperation("所有数据库连接")
    @ResponseBody
    public List<GenDatasource> getList(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return datasourceDao.findAllByPage(GenDatasourceTable.class, page, size);
    }

    @PostMapping(value = "/save")
    @ApiOperation("保存数据库连接")
    @ResponseBody
    public GenDatasource save(@RequestBody GenDatasource genDatasource) {
        return datasourceDao.save(genDatasource);
    }

    @PutMapping(value = "/update")
    @ApiOperation("更新数据库连接")
    @ResponseBody
    public GenDatasource update(@RequestBody GenDatasource genDatasource) {
        return datasourceDao.update(genDatasource);
    }

    @DeleteMapping(value = "/delete")
    @ApiOperation("删除数据库连接")
    @ResponseBody
    public DeleteResult delete(@RequestBody List<Integer> ids) {
        return datasourceDao.batchDelete(GenDatasourceTable.class, ids);
    }

    @ApiOperation("测试数据库连接")
    @GetMapping("test/{id}")
    public boolean test(@PathVariable("id") Integer id) {
        try {
            GenDatasource genDatasource = datasourceDao.findById(GenDatasource.class, id).get();
            GenDatasourceModel genDatasourceModel = new GenDatasourceModel();
            BeanUtils.copyProperties(genDatasource, genDatasourceModel);
            DatabaseUtil.getConnection(new MyDataSource(genDatasourceModel));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @ApiOperation("根据数据源ID，获取全部数据表")
    @GetMapping("table/list/{id}")
    public BatchSaveResult<GenTable> tableList(@PathVariable("id") Long id) {
        try {
            GenDatasource genDatasource = datasourceDao.findById(GenDatasource.class, id).get();
            GenDatasourceModel genDatasourceModel = new GenDatasourceModel();
            BeanUtils.copyProperties(genDatasource, genDatasourceModel);
            MyDataSource myDataSource = new MyDataSource(genDatasourceModel);
            myDataSource.setDbType(DbType.MySQL);
            List<GenTableModel> tableList = DatabaseUtil.getTableList(myDataSource);
            List<GenTable> collect = tableList.stream().map(GenTableModel::toGenTable).collect(Collectors.toList());
            return genTableDao.batchSave(collect);
        } catch (Exception e) {
            return null;
        }
    }
}
