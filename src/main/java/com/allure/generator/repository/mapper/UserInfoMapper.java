
package com.allure.generator.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.allure.generator.repository.entity.UserInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 功能描述:
 *
 * @author lWX1117952
 * @since 2022-10-19
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfoEntity> {
}
