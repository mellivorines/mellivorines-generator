package com.mellivorines.generator.service;

import com.mellivorines.generator.entity.GenAuthor;
import com.mellivorines.generator.entity.GenConfig;

import java.util.zip.ZipOutputStream;

public interface GeneratorService {

    void downloadCode(GenConfig genConfig, GenAuthor genAuthor, Integer tableId, ZipOutputStream zip);

    void generatorCode(Integer tableId);
}
