package com.mellivorines.generator.entity

import org.babyfish.jimmer.sql.Column
import org.babyfish.jimmer.sql.Entity
import org.babyfish.jimmer.sql.GeneratedValue
import org.babyfish.jimmer.sql.GenerationType
import org.babyfish.jimmer.sql.Id
import org.babyfish.jimmer.sql.Table

@Entity
@Table(name = "gen_datasource")
interface GenDatasource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long

    @Column(name = "db_type")
    val dbType: String?

    @Column(name = "conn_name")
    val connName: String?

    @Column(name = "conn_url")
    val connUrl: String?

    @Column(name = "username")
    val username: String?

    @Column(name = "password")
    val password: String?
}