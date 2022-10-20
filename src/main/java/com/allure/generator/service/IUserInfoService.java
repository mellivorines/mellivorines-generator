
package com.allure.generator.service;

import com.allure.generator.repository.entity.UserInfoPO;

import java.util.List;

/**
 * 功能描述:
 *
 * @author lilinxi
 * @since 2022-10-19
 */
public interface IUserInfoService {
    /**
     * 获取所有用户信息
     *
     * @return 返回结果
     */
    List<UserInfoPO> getAllUserInfo();

    /**
     * 添加用户
     * 
     * @param userInfoPO 用户信息
     * @return 返回是否成功
     */
    String saveUserInfo(UserInfoPO userInfoPO);
}
