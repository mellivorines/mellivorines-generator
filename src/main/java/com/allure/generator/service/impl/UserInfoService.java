
package com.allure.generator.service.impl;

import com.allure.generator.repository.dao.IUserInfoDao;
import com.allure.generator.repository.entity.UserInfoPO;
import com.allure.generator.service.IUserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<UserInfoPO> getAllUserInfo() {
        List<UserInfoPO> list = userInfoDao.list();
        return list;
    }

    /**
     * 添加用户
     *
     * @param userInfoPO 用户信息
     * @return 返回是否成功
     */
    @Override
    public String saveUserInfo(UserInfoPO userInfoPO) {

        userInfoPO.setCreator("lilinxi");
        userInfoPO.setUpdater("lilinxi");

        boolean save = userInfoDao.save(userInfoPO);
        return String.valueOf(save);
    }
}
