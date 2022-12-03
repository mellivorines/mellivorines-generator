package com.mellivorines.generator.utils;

import com.mellivorines.generator.config.AppProperties;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
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

    public static boolean checkFile(MultipartFile multiFile, AppProperties appProperties) {
        if (multiFile.isEmpty()) {
            return false;
        }
        String filename = multiFile.getOriginalFilename();
        String contentType = multiFile.getContentType();
        if (StringUtils.isBlank(filename)) {
            return false;
        }
        long size = multiFile.getSize();
        String suffix = filename.substring(filename.lastIndexOf("."));
        if (!ArrayUtils.contains(appProperties.getFileTypeArray(), suffix)) {
            return false;
        }
        double fileSize = size / (1024.0*1024.0);
        return !(fileSize > appProperties.getMaxFileSize());
    }
}
