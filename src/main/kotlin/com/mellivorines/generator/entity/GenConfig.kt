package com.mellivorines.generator.entity

import org.babyfish.jimmer.sql.Column
import org.babyfish.jimmer.sql.Entity
import org.babyfish.jimmer.sql.GeneratedValue
import org.babyfish.jimmer.sql.GenerationType
import org.babyfish.jimmer.sql.Id
import org.babyfish.jimmer.sql.Table

@Entity
@Table(name = "gen_config")
interface GenConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long

    @Column(name = "project")
    val project: String?

    @Column(name = "module")
    val module: String?

    @Column(name = "group")
    val group: String?

    @Column(name = "artifact")
    val artifact: String?

    @Column(name = "version")
    val version: String?
}