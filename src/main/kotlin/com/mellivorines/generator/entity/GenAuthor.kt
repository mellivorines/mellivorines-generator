package com.mellivorines.generator.entity

import org.babyfish.jimmer.sql.Column
import org.babyfish.jimmer.sql.Entity
import org.babyfish.jimmer.sql.GeneratedValue
import org.babyfish.jimmer.sql.GenerationType
import org.babyfish.jimmer.sql.Id
import org.babyfish.jimmer.sql.Table


@Entity
@Table(name = "gen_author")
interface GenAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long

    @Column(name = "author")
    val author: String?

    @Column(name = "url")
    val url: String?

    @Column(name = "email")
    val email: String?

    @Column(name = "telephone")
    val telephone: String?
}