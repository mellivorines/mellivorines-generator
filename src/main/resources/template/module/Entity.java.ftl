
<#if module??>
package ${package}.entity;
<#else>
package ${package}.${module}.entity;
</#if>
import org.babyfish.jimmer.sql.Column;
import org.babyfish.jimmer.sql.Entity;
import org.babyfish.jimmer.sql.Table;
import org.jetbrains.annotations.Nullable;

@Entity
@Table(name = "gen_base_class")
public interface BaseClass extends BaseEntity {

    @Nullable
    @Column(name = "package_name")
    String packageName();

    @Nullable
    @Column(name = "code")
    String code();

    @Nullable
    @Column(name = "fields")
    String fields();


    @Nullable
    @Column(name = "remark")
    String remark();
}
