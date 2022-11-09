<#if module??>
package ${package}.controller;
import ${package}.entity.${ClassName?cap_first};
import ${package}.dao.${ClassName?cap_first}Dao;
import ${package}.entity.${ClassName?cap_first}Table;
<#else>
package ${package}.${module}.controller;
import ${package}.${module}.entity.${ClassName?cap_first};
import ${package}.${module}.dao.${ClassName?cap_first}Dao;
import ${package}.${module}.entity.${ClassName?cap_first}Table;
</#if>
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.babyfish.jimmer.sql.ast.mutation.DeleteResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
<#if isSwagger == true>
@Api(tags = "基类处理")
</#if>
@RequestMapping("api/${ClassName?lower_case}")
public class ${ClassName?cap_first}Controller {

    @Resource
    ${ClassName?cap_first}Dao ${ClassName}Dao;

    @GetMapping(value = "/list")
    <#if isSwagger == true>
    @ApiOperation("获取所有基类")
    </#if>
    @ResponseBody
    public List<BaseClass> getList(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return ${ClassName}Dao.findAllByPage(${ClassName?cap_first}Table.class, page, size);
    }

    @PostMapping(value = "/save")
    <#if isSwagger == true>
    @ApiOperation("所有基类")
    </#if>
    @ResponseBody
    public ${ClassName?cap_first} save(@RequestBody ${ClassName?cap_first} ${ClassName}) {
        return ${ClassName}Dao.save(${ClassName});
    }

    @PutMapping(value = "/update")
    <#if isSwagger == true>
    @ApiOperation("更新基类")
    </#if>
    @ResponseBody
    public ${ClassName?cap_first} update(@RequestBody ${ClassName?cap_first} ${ClassName}) {
        return ${ClassName}Dao.update(${ClassName});
    }

    @DeleteMapping(value = "/delete")
    <#if isSwagger == true>
    @ApiOperation("删除基类")
    </#if>
    @ResponseBody
    public DeleteResult delete(@RequestBody List<Integer> ids) {
        return ${ClassName}Dao.batchDelete(${ClassName?cap_first}Table.class, ids);
    }
}
