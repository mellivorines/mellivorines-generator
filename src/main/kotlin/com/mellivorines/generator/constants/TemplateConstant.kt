package com.mellivorines.generator.constants

interface TemplateConstant {
    companion object {
        /**
         * 模板类型：支持ftl和vm
         */
        const val FILE_TYPE_FTL = ".ftl"
        const val FILE_TYPE_VM = ".vm"

        /**
         * 是否开发swagger
         */
        const val SWAGGER = "swagger"

        /**
         * 包名
         */
        const val PACKAGE = "package"

        /**
         * 微服务专用模块
         */
        const val MODULE = "module"

        /**
         * 项目名称
         */
        const val PROJECT = "project"

        /**
         * 版本3件套
         */
        const val GROUP = "group"
        const val ARTIFACT = "artifact"
        const val VERSION = "version"

        /**
         * 作者相关
         */
        const val AUTHOR = "author"
        const val EMAIL = "email"
        const val URL = "url"
        const val TELEPHONE = "telephone"
    }
}