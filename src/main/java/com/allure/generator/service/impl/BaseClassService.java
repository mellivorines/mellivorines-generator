
package com.allure.generator.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.allure.generator.repository.dao.IBaseClassDao;
import com.allure.generator.repository.entity.BaseClassPO;
import com.allure.generator.service.IBaseClassService;

import lombok.AllArgsConstructor;

/**
 * 功能描述:
 *
 * @author lilinxi
 * @since 2022-10-20
 */
@Service
@AllArgsConstructor
public class BaseClassService implements IBaseClassService {

    private final IBaseClassDao iBaseClassDao;

    /**
     * 获取实体基类所有数据
     *
     * @return 返回结果
     */
    @Override
    public List<BaseClassPO> getAll() {

        return iBaseClassDao.list();
    }

    /**
     * 保存实体基类
     *
     * @param baseClassPO 实体基类数据
     * @return 返回是否保存成功
     */
    @Override
    public String save(BaseClassPO baseClassPO) {

        baseClassPO.setCreator("lilinxi");
        baseClassPO.setUpdater("lilinxi");

        boolean save = iBaseClassDao.save(baseClassPO);
        return String.valueOf(save);
    }
}
