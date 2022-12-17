package com.mellivorines.generator.controller

import com.mellivorines.generator.entity.GenBaseClass
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.v3.oas.annotations.parameters.RequestBody
import org.babyfish.jimmer.sql.kt.KSqlClient
import org.babyfish.jimmer.sql.kt.ast.mutation.KDeleteResult
import org.babyfish.jimmer.sql.kt.ast.mutation.KSimpleSaveResult
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@Api(tags = ["作者信息"])
@RequestMapping("api/author")
class GenAuthorController(private val sqlclient:KSqlClient) {


    @GetMapping(value = ["/list"])
    @ApiOperation("所有基类")
    @ResponseBody
    fun getList(@RequestParam("page") page: Int?, @RequestParam("size") size: Int?): List<GenBaseClass?>? {
        return sqlclient.entities.findAll(GenBaseClass::class)
    }

    @PostMapping(value = ["/save"])
    @ApiOperation("保存基类")
    @ResponseBody
    fun save(@RequestBody genBaseClass: GenBaseClass): KSimpleSaveResult<GenBaseClass> {
        return sqlclient.entities.save(genBaseClass)
    }

    @PutMapping(value = ["/update"])
    @ApiOperation("更新基类")
    @ResponseBody
    fun update(@RequestBody genBaseClass: GenBaseClass): KSimpleSaveResult<GenBaseClass> {
        return sqlclient.entities.save(genBaseClass)
    }

    @DeleteMapping(value = ["/delete"])
    @ApiOperation("删除基类")
    @ResponseBody
    fun delete(@RequestBody ids: List<Long>): KDeleteResult {
        return sqlclient.entities.batchDelete(GenBaseClass::class, ids)
    }
}