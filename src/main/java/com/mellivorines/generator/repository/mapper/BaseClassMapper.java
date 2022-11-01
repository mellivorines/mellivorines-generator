
package com.mellivorines.generator.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mellivorines.generator.repository.entity.BaseClassPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 功能描述:实体基类相关
 *
 * @author lilinxi
 * @since 2022-10-20
 */
@Mapper
public interface BaseClassMapper extends BaseMapper<BaseClassPO> {
}
