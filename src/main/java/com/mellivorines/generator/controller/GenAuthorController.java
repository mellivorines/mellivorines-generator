package com.mellivorines.generator.controller;

import com.mellivorines.generator.dao.GenAuthorDao;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = "作者信息")
@RequestMapping("api/author")
public class GenAuthorController {
    @Resource
    GenAuthorDao genAuthorDao;
}
