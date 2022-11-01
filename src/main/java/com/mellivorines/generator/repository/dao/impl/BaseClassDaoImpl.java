
package com.mellivorines.generator.repository.dao.impl;

import com.mellivorines.generator.repository.entity.BaseClassPO;
import com.mellivorines.generator.repository.mapper.BaseClassMapper;
import org.springframework.stereotype.Service;

import com.mellivorines.generator.repository.dao.IBaseClassDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 功能描述:实体基类相关
 *
 * @author lilinxi
 * @since 2022-10-20
 */
@Service
public class BaseClassDaoImpl extends ServiceImpl<BaseClassMapper, BaseClassPO> implements IBaseClassDao {
}
