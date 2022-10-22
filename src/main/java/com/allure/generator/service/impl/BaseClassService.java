
package com.allure.generator.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.allure.generator.model.BaseClassVO;
import com.allure.generator.repository.dao.IBaseClassDao;
import com.allure.generator.repository.entity.BaseClassPO;
import com.allure.generator.service.IBaseClassService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能描述:实体类的基类视图相关
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
    public List<BaseClassVO> getAll() {
        return BeanUtil.copyToList(iBaseClassDao.list(), BaseClassVO.class);
    }

    /**
     * 保存实体基类
     *
     * @param baseClassVO 实体基类数据
     * @return 返回是否保存成功
     */
    @Override
    public String saveBaseClass(BaseClassVO baseClassVO) {
        BaseClassPO baseClassPO = BeanUtil.copyProperties(baseClassVO, BaseClassPO.class);
        baseClassPO.setCreator("lilinxi");
        baseClassPO.setUpdater("lilinxi");
        boolean save = iBaseClassDao.save(baseClassPO);
        return String.valueOf(save);
    }

    /**
     * 更新实体基类
     *
     * @param baseClassVO 实体基类数据
     * @return 返回是否更新成功
     */
    @Override
    public String updateBaseClass(BaseClassVO baseClassVO) {
        BaseClassPO baseClassPO = BeanUtil.copyProperties(baseClassVO, BaseClassPO.class);
        baseClassPO.setUpdater("lilinxi");
        return String.valueOf(iBaseClassDao.updateById(baseClassPO));
    }

    /**
     * 删除实体基类
     *
     * @param ids 主键id
     * @return 返回是否删除成功
     */
    @Override
    public String deleteBaseClass(List<Integer> ids) {
        return String.valueOf(iBaseClassDao.removeBatchByIds(ids));
    }
}
