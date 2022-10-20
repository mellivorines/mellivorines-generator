
package com.allure.generator.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.allure.generator.repository.entity.UserInfoPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 功能描述:
 *
 * @author lilinxi
 * @since 2022-10-19
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfoPO> {
}
