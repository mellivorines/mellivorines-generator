
package com.mellivorines.generator.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mellivorines.generator.repository.entity.UserInfoPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 功能描述:用户信息相关
 *
 * @author lilinxi
 * @since 2022-10-19
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfoPO> {
}
