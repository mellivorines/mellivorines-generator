package com.mellivorines.generator.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Component
@ConfigurationProperties(value = "app")
public class AppProperties {

    /**
     * 上传路径
     */
    private String uploadPath = "";

    /**
     * 下载路径
     */
    private String downloadPath = "";

    /**
     * 文件类型
     */
    private String[] fileTypeArray;

    /**
     * 文件大小
     */
    private int maxFileSize;

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }

    public String[] getFileTypeArray() {
        return fileTypeArray;
    }

    public void setFileTypeArray(String[] fileTypeArray) {
        this.fileTypeArray = fileTypeArray;
    }

    public int getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(int maxFileSize) {
        this.maxFileSize = maxFileSize;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppProperties that = (AppProperties) o;
        return maxFileSize == that.maxFileSize && Objects.equals(uploadPath, that.uploadPath) && Objects.equals(downloadPath, that.downloadPath) && Arrays.equals(fileTypeArray, that.fileTypeArray);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(uploadPath, downloadPath, maxFileSize);
        result = 31 * result + Arrays.hashCode(fileTypeArray);
        return result;
    }
}
