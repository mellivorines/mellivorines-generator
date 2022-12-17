package com.mellivorines.generator.entity

import org.babyfish.jimmer.sql.Column
import org.babyfish.jimmer.sql.Entity
import org.babyfish.jimmer.sql.GeneratedValue
import org.babyfish.jimmer.sql.GenerationType
import org.babyfish.jimmer.sql.Id
import org.babyfish.jimmer.sql.Table

@Entity
@Table(name = "gen_table")
interface GenTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long

    @Column(name = "database_id")
    val databaseId: Long

    @Column(name = "table_name")
    val tableName: String?

    @Column(name = "table_comment")
    val tableComment: String?
}