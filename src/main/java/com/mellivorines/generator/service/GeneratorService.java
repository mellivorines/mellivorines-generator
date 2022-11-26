package com.mellivorines.generator.service;

import java.util.zip.ZipOutputStream;

public interface GeneratorService {

    void downloadCode(Integer tableId, ZipOutputStream zip);

    void generatorCode(Integer tableId);
}
