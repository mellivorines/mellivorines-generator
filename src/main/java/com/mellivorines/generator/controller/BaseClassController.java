package com.mellivorines.generator.controller;


import com.mellivorines.generator.dao.BaseClassDao;
import com.mellivorines.generator.entity.BaseClass;
import com.mellivorines.generator.entity.BaseClassTable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.babyfish.jimmer.sql.ast.mutation.DeleteResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = "基类处理")
@RequestMapping("api/base-class")
public class BaseClassController {
    @Resource
    BaseClassDao baseClassDao;

    @GetMapping(value = "/list")
    @ApiOperation("所有基类")
    @ResponseBody
    public List<BaseClass> getList(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return baseClassDao.findAllByPage(BaseClassTable.class, page, size);
    }

    @PostMapping(value = "/save")
    @ApiOperation("保存基类")
    @ResponseBody
    public BaseClass save(@RequestBody BaseClass baseClass) {
        return baseClassDao.save(baseClass);
    }

    @PutMapping(value = "/update")
    @ApiOperation("更新基类")
    @ResponseBody
    public BaseClass update(@RequestBody BaseClass baseClass) {
        return baseClassDao.update(baseClass);
    }

    @DeleteMapping(value = "/delete")
    @ApiOperation("删除基类")
    @ResponseBody
    public DeleteResult delete(@RequestBody List<Integer> ids) {
        return baseClassDao.batchDelete(BaseClassTable.class, ids);
    }
}
