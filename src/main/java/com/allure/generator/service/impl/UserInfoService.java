
package com.allure.generator.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.allure.generator.model.UserInfoVO;
import com.allure.generator.repository.dao.IUserInfoDao;
import com.allure.generator.repository.entity.UserInfoPO;
import com.allure.generator.service.IUserInfoService;

import cn.hutool.core.bean.BeanUtil;
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
    public List<UserInfoVO> getAllUserInfo() {
        return BeanUtil.copyToList(userInfoDao.list(), UserInfoVO.class);
    }

    /**
     * 添加用户
     *
     * @param userInfoVO 用户信息
     * @return 返回是否成功
     */
    @Override
    public String saveUserInfo(UserInfoVO userInfoVO) {

        UserInfoPO userInfoPO = BeanUtil.copyProperties(userInfoVO, UserInfoPO.class);
        userInfoPO.setCreator("lilinxi");
        userInfoPO.setUpdater("lilinxi");

        return String.valueOf(userInfoDao.save(userInfoPO));
    }

    /**
     * 更新用户
     *
     * @param userInfoVO 用户信息
     * @return 返回是否成功
     */
    @Override
    public String updateUserInfo(UserInfoVO userInfoVO) {

        UserInfoPO userInfoPO = BeanUtil.copyProperties(userInfoVO, UserInfoPO.class);
        userInfoPO.setUpdater("lilinxi");

        return String.valueOf(userInfoDao.updateById(userInfoPO));
    }

    /**
     * 删除用户
     *
     * @param ids 主键id
     * @return 返回是否成功
     */
    @Override
    public String deleteUserInfo(List<Integer> ids) {
        return String.valueOf(userInfoDao.removeBatchByIds(ids));
    }
}
