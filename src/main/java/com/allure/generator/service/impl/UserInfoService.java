
package com.allure.generator.service.impl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.allure.generator.repository.dao.IUserInfoDao;
import com.allure.generator.repository.entity.UserInfoEntity;
import com.allure.generator.service.IUserInfoService;

import lombok.AllArgsConstructor;

/**
 * 功能描述:
 *
 * @author lilinxi
 * @since 2022-10-19
 */
@Service
@AllArgsConstructor
public class UserInfoService implements IUserInfoService {

    private final IUserInfoDao userInfoDao;

    /**
     * 获取所有用户信息
     *
     * @return 返回结果
     */
    @Override
    public List<UserInfoEntity> getAllUserInfo() {
        List<UserInfoEntity> list = userInfoDao.list();
        return list;
    }

    /**
     * 添加用户
     *
     * @param userInfoEntity 用户信息
     * @return 返回是否成功
     */
    @Override
    public String saveUserInfo(UserInfoEntity userInfoEntity) {

        userInfoEntity.setCreator("lilinxi");
        userInfoEntity.setUpdater("lilinxi");

        boolean save = userInfoDao.save(userInfoEntity);
        return String.valueOf(save);
    }
}
