package com.mellivorines.generator.service;

import java.util.zip.ZipOutputStream;

public interface GeneratorService {

    void downloadCode(Long tableId, ZipOutputStream zip);

    void generatorCode(Long tableId);
}
