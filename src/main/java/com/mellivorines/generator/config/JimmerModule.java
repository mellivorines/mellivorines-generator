package com.mellivorines.generator.config;

import com.mellivorines.generator.entity.GenAuthor;
import com.mellivorines.generator.entity.GenBaseClass;
import com.mellivorines.generator.entity.GenDatasource;
import com.mellivorines.generator.entity.GenFieldType;
import com.mellivorines.generator.entity.GenTable;
import org.babyfish.jimmer.sql.runtime.EntityManager;

public class JimmerModule {
    public static final EntityManager ENTITY_MANAGER = new EntityManager(
            GenAuthor.class,
            GenBaseClass.class,
            GenDatasource.class,
            GenFieldType.class,
            GenTable.class,
            GenFieldType.class
    );

    public JimmerModule() {
    }

}
