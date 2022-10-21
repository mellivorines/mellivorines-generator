
package com.allure.generator.service;

import java.util.List;

import com.allure.generator.model.UserInfoVO;

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
    List<UserInfoVO> getAllUserInfo();

    /**
     * 添加用户
     *
     * @param userInfoVO 用户信息
     * @return 返回是否成功
     */
    String saveUserInfo(UserInfoVO userInfoVO);

    /**
     * 更新用户
     *
     * @param userInfoVO 用户信息
     * @return 返回是否成功
     */
    String updateUserInfo(UserInfoVO userInfoVO);

    /**
     * 删除用户
     *
     * @param ids 主键id
     * @return 返回是否成功
     */
    String deleteUserInfo(List<Integer> ids);
}
