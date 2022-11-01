
package com.mellivorines.generator.service;

import java.util.List;

import com.mellivorines.generator.model.BaseClassVO;

/**
 * 功能描述:实体基类相关
 *
 * @author lilinxi
 * @since 2022-10-20
 */
public interface IBaseClassService {
    /**
     * 获取实体基类所有数据
     *
     * @return 返回结果
     */
    List<BaseClassVO> getAll();

    /**
     * 保存实体基类
     *
     * @param baseClassVO 实体基类数据
     * @return 返回是否保存成功
     */
    String saveBaseClass(BaseClassVO baseClassVO);

    /**
     * 更新实体基类
     *
     * @param baseClassVO 实体基类数据
     * @return 返回是否更新成功
     */
    String updateBaseClass(BaseClassVO baseClassVO);

    /**
     * 删除实体基类
     *
     * @param ids 主键id
     * @return 返回是否删除成功
     */
    String deleteBaseClass(List<Integer> ids);
}
