package com.mellivorines.generator.utils;

import com.mellivorines.generator.constants.CommonConstant;
import com.mellivorines.generator.constants.TemplateTypeConstant;
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

    public static void initConfig(String templateFilePath, String templateFileName) throws IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setDirectoryForTemplateLoading(new File(templateFilePath));
        configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_31));
        temp = configuration.getTemplate(templateFileName + TemplateTypeConstant.FILE_TYPE_FTL);
    }

    public static void generator(Map<String, Object> map, String outFileName) throws IOException, TemplateException {
        FileWriter fileWriter = new FileWriter(outFileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        temp.process(map, bufferedWriter);
        bufferedWriter.flush();
        fileWriter.close();
    }

    public static void generatorByCustom(String templateFilePath, String templateFileName, Map<String, Object> map, String outFileName) throws IOException, TemplateException {

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setDirectoryForTemplateLoading(new File(templateFilePath));
        configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_31));
        temp = configuration.getTemplate(templateFileName + TemplateTypeConstant.FILE_TYPE_FTL);

        FileWriter fileWriter = new FileWriter(outFileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        temp.process(map, bufferedWriter);
        bufferedWriter.flush();
        fileWriter.close();
    }


}
