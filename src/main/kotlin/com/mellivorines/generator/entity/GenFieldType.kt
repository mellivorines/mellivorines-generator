package com.mellivorines.generator.entity

import org.babyfish.jimmer.sql.Column
import org.babyfish.jimmer.sql.Entity
import org.babyfish.jimmer.sql.GeneratedValue
import org.babyfish.jimmer.sql.GenerationType
import org.babyfish.jimmer.sql.Id
import org.babyfish.jimmer.sql.Table

@Entity
@Table(name = "gen_field_type")
interface GenFieldType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long

    @Column(name = "column_type")
    val columnType: String?

    @Column(name = "attr_type")
    val attrType: String?

    @Column(name = "package_name")
    val packageName: String?
}