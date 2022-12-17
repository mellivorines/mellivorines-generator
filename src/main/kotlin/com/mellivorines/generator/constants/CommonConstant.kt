package com.mellivorines.generator.constants

interface CommonConstant {
    interface GeneratorType {
        companion object {
            const val MODULE = "module"
            const val PROJECT = "project"
        }
    }

    companion object {
        const val SLASH = "/"
        const val SEMICOLON = ","
        const val HORIZONTAL = "_"
        const val SPACE = " "
        const val POINT = "."
        const val DATE_TIME = "datetime"
        const val DATE = "date"
        const val TEMPLATE_FILE_BASE_PATH = "src/main/resources/template"
    }
}