
package com.allure.generator.service;

import java.util.List;

import com.allure.generator.repository.entity.UserInfoEntity;

/**
 * 功能描述:
 *
 * @author lWX1117952
 * @since 2022-10-19
 */
public interface IUserInfoService {
    /**
     * 获取所有用户信息
     *
     * @return 返回结果
     */
    List<UserInfoEntity> getAllUserInfo();

    /**
     * 添加用户
     * 
     * @param userInfoEntity 用户信息
     * @return 返回是否成功
     */
    String saveUserInfo(UserInfoEntity userInfoEntity);
}
