package com.mellivorines.generator.utils;


import cn.hutool.core.io.IoUtil;
import com.mellivorines.generator.exception.BizException;
import freemarker.template.Template;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

public class TemplateUtil {

    public static String getTemplateContent(String content, Map<String, Object> dataModel) {
        if (dataModel.isEmpty()) {
            return content;
        }
        StringReader stringReader = new StringReader(content);
        StringWriter stringWriter = new StringWriter();
        try {
            // 渲染模板
            String templateName = dataModel.get("templateName").toString();
            Template template = new Template(templateName, stringReader, null, "utf-8");
            template.process(dataModel, stringWriter);
        } catch (Exception e) {
            throw new BizException("渲染模板失败，请检查模板语法", e);
        }

        content = stringWriter.toString();

        IoUtil.close(stringReader);
        IoUtil.close(stringWriter);

        return content;

    }
}
