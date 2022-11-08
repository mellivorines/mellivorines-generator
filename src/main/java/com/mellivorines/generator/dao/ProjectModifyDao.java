package com.mellivorines.generator.dao;

import com.mellivorines.generator.entity.ProjectModify;
import com.mellivorines.generator.entity.ProjectModifyFetcher;
import com.mellivorines.generator.entity.ProjectModifyTable;
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.fluent.Fluent;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ProjectModifyDao extends BaseDao<ProjectModifyTable, ProjectModify> {
    @Resource
    private JSqlClient sqlClient;

    @Override
    public List<ProjectModify> findAllByPage(Class<ProjectModifyTable> entityTableClazz, int page, int size) {
        Fluent fluent = sqlClient.createFluent();
        ProjectModifyTable projectModifyTable = new ProjectModifyTable();
        return fluent.query(projectModifyTable)
                .groupBy(projectModifyTable.id())
                .select(projectModifyTable.fetch(ProjectModifyFetcher.$.allTableFields()))
                .limit(size, (page - 1) * size)
                .execute();
    }
}
