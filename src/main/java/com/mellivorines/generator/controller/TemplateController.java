package com.mellivorines.generator.controller;

import com.mellivorines.generator.config.AppProperties;
import com.mellivorines.generator.utils.FileUploadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static com.mellivorines.generator.constants.CommonConstant.SLASH;

@RestController
@Api(tags = "模版相关")
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    private AppProperties appProperties;

    @PutMapping(value = "/upload")
    @ApiOperation("上传模版")
    @ResponseBody
    public boolean uploadTemplate(@RequestParam(value = "file") MultipartFile multipartFile,
                                  @RequestParam(value = "path") String path,
                                  @RequestParam(value = "name") String uploadFileName) {
        if (FileUploadUtil.checkFile(multipartFile, appProperties)){
            return FileUploadUtil.uploadToServer(multipartFile, StringUtils.join(appProperties.getUploadPath(), path, SLASH), uploadFileName);
        }else {
            return false;
        }
    }


}
