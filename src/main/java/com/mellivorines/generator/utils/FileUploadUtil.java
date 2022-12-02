package com.mellivorines.generator.utils;

import com.mellivorines.generator.config.AppProperties;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileUploadUtil {

    public static boolean uploadToServer(MultipartFile multipartFile, String uploadPath, String uploadFileName) {
        File file = new File(uploadPath);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (!mkdirs) {
                return false;
            }
        }
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            inputStream = multipartFile.getInputStream();
            fileOutputStream = new FileOutputStream(uploadPath + uploadFileName);
            int length;
            byte[] bytes = new byte[1024];
            while ((length = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, length);
            }
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean newUploadToServer(MultipartFile multipartFile, String uploadPath, String uploadFileName) {
        File file = new File(uploadPath);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            if (!mkdirs) {
                return false;
            }
        }
        try {
            InputStream inputStream = multipartFile.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(uploadPath + uploadFileName);
            int copy = FileCopyUtils.copy(inputStream, outputStream);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean downloadToServer(String downloadUrl, String downloadPath, String downloadFileName) {
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        boolean flag = false;
        try {
            URL url = new URL(downloadUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            bufferedInputStream = new BufferedInputStream(connection.getInputStream());
            File file = new File(downloadPath);
            if (!file.exists()) {
                boolean mkdirs = file.mkdirs();
                if (!mkdirs) {
                    return false;
                }
            }
            String filePathName = downloadPath + File.separator + downloadFileName;
            byte[] bytes = new byte[1024];
            int size;
            fileOutputStream = new FileOutputStream(filePathName);
            while ((size = bufferedInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, size);
            }
            flag = true;
        } catch (Exception ignored) {
        } finally {
            try {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public static Pair<Boolean, String> checkFile(MultipartFile multiFile, AppProperties appProperties) {
        if (multiFile.isEmpty()) {
            return Pair.of(false, "文件为空");
        }
        //获取
        String filename = multiFile.getOriginalFilename();
        String contentType = multiFile.getContentType();
        if (StringUtils.isBlank(filename)) {
            return Pair.of(false, "文件名为空");
        }
        long size = multiFile.getSize();//字节
        //log.info("收到的请求文件信息：原生文件名：{},文件类型：{},文件大小：{}", filename, contentType, size);
        //获取文件后缀
        String suffix = filename.substring(filename.lastIndexOf("."));
        //判断配置的文件列表里是否支持该文件类型
        if (!ArrayUtils.contains(appProperties.getFileTypeArray(), suffix)) {
            return Pair.of(false, "不支持该类型文件上传");
        }
        double fileSize = size / 1024.0;//单位kb
        if (fileSize > appProperties.getMaxFileSize()) {
            return Pair.of(false, "文件大小超过限制");
        }
        return Pair.of(true, "验证通过");
    }
}
