<#if module??>
package ${package}.controller;
import ${package}.entity.${ClassName?cap_first};
import ${package}.dao.${ClassName?cap_first}Fetcher;
import ${package}.entity.${ClassName?cap_first}Table;
<#else>
package ${package}.${module}.controller;
import ${package}.${module}.entity.${ClassName?cap_first};
import ${package}.${module}.dao.${ClassName?cap_first}Fetcher;
import ${package}.${module}.entity.${ClassName?cap_first}Table;
</#if>
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.fluent.Fluent;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ${ClassName?cap_first}Dao extends BaseDao<${ClassName?cap_first}Table, ${ClassName}> {
    @Resource
    private JSqlClient sqlClient;

    @Override
    public List<${ClassName}> findAllByPage(Class<${ClassName}Table> entityTableClazz, int page, int size) {
        Fluent fluent = sqlClient.createFluent();
        ${ClassName?cap_first}Table ${ClassName}Table = new ${ClassName?cap_first}Table();
        return fluent.query( ${ClassName}Table)
                .groupBy( ${ClassName}Table.id())
                .select( ${ClassName}Table.fetch( ${ClassName?cap_first}etcher.$.allTableFields()))
                .limit(size, (page - 1) * size)
                .execute();
    }
}
