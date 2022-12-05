package com.mellivorines.generator.controller;


import com.mellivorines.generator.dao.GenBaseClassDao;
import com.mellivorines.generator.entity.GenBaseClass;
import com.mellivorines.generator.entity.GenBaseClassTable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.babyfish.jimmer.sql.ast.mutation.DeleteResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = "基类处理")
@RequestMapping("api/base-class")
public class GenBaseClassController {
    @Resource
    GenBaseClassDao genBaseClassDao;

    @GetMapping(value = "/list")
    @ApiOperation("所有基类")
    @ResponseBody
    public List<GenBaseClass> getList(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return genBaseClassDao.findAllByPage(GenBaseClassTable.class, page, size);
    }

    @PostMapping(value = "/save")
    @ApiOperation("保存基类")
    @ResponseBody
    public GenBaseClass save(@RequestBody GenBaseClass genBaseClass) {
        return genBaseClassDao.save(genBaseClass);
    }

    @PutMapping(value = "/update")
    @ApiOperation("更新基类")
    @ResponseBody
    public GenBaseClass update(@RequestBody GenBaseClass genBaseClass) {
        return genBaseClassDao.update(genBaseClass);
    }

    @DeleteMapping(value = "/delete")
    @ApiOperation("删除基类")
    @ResponseBody
    public DeleteResult delete(@RequestBody List<Integer> ids) {
        return genBaseClassDao.batchDelete(GenBaseClassTable.class, ids);
    }
}
