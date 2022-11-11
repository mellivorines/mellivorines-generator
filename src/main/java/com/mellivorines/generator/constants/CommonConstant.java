package com.mellivorines.generator.constants;

public interface CommonConstant {

    String SLASH = "/";

    String TEMPLATE_FILE_BASE_PATH="src/main/resources/template";

    interface TemplateType {

        String FILE_TYPE = ".ftl";
    }

    interface GeneratorType {

        String MODULE = "module";

        String PROJECT = "project";
    }
}
