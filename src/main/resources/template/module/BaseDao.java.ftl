<#if module??>
package ${package}.dao;
<#else>
package ${package}.${module}.dao;
</#if>
import org.babyfish.jimmer.sql.JSqlClient;
import org.babyfish.jimmer.sql.ast.mutation.BatchSaveResult;
import org.babyfish.jimmer.sql.ast.mutation.DeleteResult;
import org.babyfish.jimmer.sql.ast.mutation.SaveMode;
import org.babyfish.jimmer.sql.ast.mutation.SimpleSaveResult;
import org.babyfish.jimmer.sql.ast.table.Table;
import org.babyfish.jimmer.sql.fetcher.Fetcher;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public abstract class BaseDao<T extends Table<?>, E> {

        @Resource
        private JSqlClient sqlClient;

        public E save(E entity) {
                return sqlClient.getEntities().save(entity).getModifiedEntity();
        }

        public BatchSaveResult<E> batchSave(Collection<E> entities) {
                return sqlClient.getEntities().batchSave(entities);
        }

        public SimpleSaveResult<E> insert(E entity) {
                return sqlClient.getEntities().saveCommand(entity).configure(it -> it.setMode(SaveMode.INSERT_ONLY)).execute();
        }
        public BatchSaveResult<E> batchInsert(Collection<E> entities) {
                return sqlClient.getEntities().batchSaveCommand(entities).configure(it -> it.setMode(SaveMode.INSERT_ONLY)).execute();
        }

        public DeleteResult deleteById(Class<T> entityTableClazz, Object id) {
                return sqlClient.getEntities().delete(entityTableClazz, id);
        }

        public DeleteResult batchDelete(Class<T> entityClazz, Collection<?> ids) {
                return sqlClient.getEntities().batchDelete(entityClazz, ids);
                }

        public E update(E entity) {
                return sqlClient.getEntities().saveCommand(entity).configure(it -> it.setMode(SaveMode.UPDATE_ONLY)).execute().getModifiedEntity();
        }

        public Optional<E> findById(Class<E> entityClazz, Object id) {
                return Optional.ofNullable(sqlClient.getEntities().findById(entityClazz, id));
        }

        public Optional<E> findById(Fetcher<E> fetcher, Object id) {
                return Optional.ofNullable(sqlClient.getEntities().findById(fetcher, id));
        }

        public List<E> findAll(Class<E> entityClazz) {
                return sqlClient.getEntities().findAll(entityClazz);
        }

        public abstract List<E> findAllByPage(Class<T> entityTableClazz, int page, int size);

}
