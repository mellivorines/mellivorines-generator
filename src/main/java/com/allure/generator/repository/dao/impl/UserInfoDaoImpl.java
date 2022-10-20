
package com.allure.generator.repository.dao.impl;

import org.springframework.stereotype.Service;

import com.allure.generator.repository.dao.IUserInfoDao;
import com.allure.generator.repository.entity.UserInfoEntity;
import com.allure.generator.repository.mapper.UserInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 功能描述:
 *
 * @author lilinxi
 * @since 2022-10-19
 */
@Service
public class UserInfoDaoImpl extends ServiceImpl<UserInfoMapper, UserInfoEntity> implements IUserInfoDao {
}
