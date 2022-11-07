package com.mellivorines.generator.utils;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FreemarkerUtil {
    private static Template temp;

    public static void initConfig(String ftlName,String ftlPath) throws IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setDirectoryForTemplateLoading(new File(ftlPath));
        configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_31));
        temp = configuration.getTemplate(ftlName + ".ftl");
    }

    public static void generator(Map<String, Object> map, String fileName) throws IOException, TemplateException {
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        temp.process(map, bufferedWriter);
        bufferedWriter.flush();
        fileWriter.close();
    }

    public static void generatorByCustom(String templateFileName,String templateFilePath,Map<String, Object> map, String fileName) throws IOException, TemplateException {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setDirectoryForTemplateLoading(new File(templateFilePath));
        configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_31));
        temp = configuration.getTemplate(templateFileName + ".ftl");

        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        temp.process(map, bufferedWriter);
        bufferedWriter.flush();
        fileWriter.close();
    }


}
