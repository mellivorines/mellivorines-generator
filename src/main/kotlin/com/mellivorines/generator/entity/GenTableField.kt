package com.mellivorines.generator.entity

import org.babyfish.jimmer.sql.Column
import org.babyfish.jimmer.sql.Entity
import org.babyfish.jimmer.sql.GeneratedValue
import org.babyfish.jimmer.sql.GenerationType
import org.babyfish.jimmer.sql.Id
import org.babyfish.jimmer.sql.Table

@Entity
@Table(name = "gen_table_field")
interface GenTableField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long

    @Column(name = "table_id")
    val tableId: Long

    @Column(name = "column_name")
    val columnName: String?

    @Column(name = "data_type")
    val dataType: String?

    @Column(name = "column_comment")
    val columnComment: String?

    @Column(name = "column_key")
    val columnKey: String?
}