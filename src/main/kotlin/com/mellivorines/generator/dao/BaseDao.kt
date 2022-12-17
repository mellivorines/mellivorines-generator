package com.mellivorines.generator.dao

import org.babyfish.jimmer.sql.ast.table.Table
import org.babyfish.jimmer.sql.fetcher.Fetcher
import org.babyfish.jimmer.sql.kt.KSqlClient
import org.babyfish.jimmer.sql.kt.ast.mutation.KBatchSaveResult
import org.babyfish.jimmer.sql.kt.ast.mutation.KDeleteResult
import org.springframework.stereotype.Repository
import kotlin.reflect.KClass

@Repository
abstract class BaseDao<T : Table<*>, E : Any>(private val sqlClient: KSqlClient) {
    fun save(entity: E): E {
        return sqlClient.entities.save(entity).modifiedEntity
    }

    fun batchSave(entities: Collection<E>): KBatchSaveResult<E> {
        return sqlClient.entities.batchSave(entities)
    }

    fun deleteById(entityTableClazz: KClass<T>, id: Any): KDeleteResult {
        return sqlClient.entities.delete(entityTableClazz, id)
    }

    fun batchDelete(entityClazz: KClass<T>, ids: Collection<*>): KDeleteResult {
        return sqlClient.entities.batchDelete(entityClazz, ids)
    }

    fun findById(entityClazz: KClass<E>, id: Any): E? {
        return sqlClient.entities.findById(entityClazz, id)
    }

    fun findById(fetcher: Fetcher<E>, id: Any): E? {
        return sqlClient.entities.findById(fetcher, id)
    }

    fun findAll(entityClazz: KClass<E>): List<E> {
        return sqlClient.entities.findAll(entityClazz)
    }
}