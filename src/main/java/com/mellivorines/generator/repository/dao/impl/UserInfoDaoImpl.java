
package com.mellivorines.generator.repository.dao.impl;

import com.mellivorines.generator.repository.dao.IUserInfoDao;
import com.mellivorines.generator.repository.entity.UserInfoPO;
import com.mellivorines.generator.repository.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 功能描述:用户信息相关
 *
 * @author lilinxi
 * @since 2022-10-19
 */
@Service
public class UserInfoDaoImpl extends ServiceImpl<UserInfoMapper, UserInfoPO> implements IUserInfoDao {
}
