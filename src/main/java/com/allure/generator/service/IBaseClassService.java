
package com.allure.generator.service;

import java.util.List;

import com.allure.generator.repository.entity.BaseClassPO;

/**
 * 功能描述:实体基类相关
 *
 * @author lWX1117952
 * @since 2022-10-20
 */
public interface IBaseClassService {
    /**
     * 获取实体基类所有数据
     * 
     * @return 返回结果
     */
    List<BaseClassPO> getAll();

    /**
     * 保存实体基类
     * 
     * @param baseClassPO 实体基类数据
     * @return 返回是否保存成功
     */
    String save(BaseClassPO baseClassPO);
}
