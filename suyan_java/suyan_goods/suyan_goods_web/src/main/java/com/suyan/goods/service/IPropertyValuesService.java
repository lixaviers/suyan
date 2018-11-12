package com.suyan.goods.service;

import com.suyan.goods.req.PropertyValuesDTO;
import com.suyan.goods.req.PropertyValuesQueryDTO;
import com.suyan.goods.resp.PropertyValuesODTO;
import com.suyan.common.resp.QueryResultODTO;
import com.suyan.common.result.Result;

import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <goods>
 * @Comments: <对外API 属性值管理接口>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-12>
 * @Modify Date: <2018-11-12>
 * @Version: <1.0>
 */
public interface IPropertyValuesService {

    /**
     * 
     * 删除属性值
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @param updateUser
     * @param updateUserName
     * @return
     */
    Result<Integer> deletePropertyValues(Long id, String updateUser, String updateUserName);
    
    /**
     * 
     * 创建属性值
     * 
     * @author lixavier
     * @version 1.0.0
     * @param propertyValuesDTO
     * @return
     */
    Result<Long> createPropertyValues(PropertyValuesDTO propertyValuesDTO);

    /**
     *
     * 批量创建属性值
     *
     * @author lixavier
     * @version 1.0.0
     * @param propertyValuesDTOs
     * @return
     */
    Result<Integer> batchCreate(List<PropertyValuesDTO> propertyValuesDTOs);

    /**
     * 
     * 更新属性值
     * 
     * @author lixavier
     * @version 1.0.0
     * @param propertyValuesDTO
     * @return
     */
    Result<Integer> updatePropertyValues(PropertyValuesDTO propertyValuesDTO);
    
    /**
     * 
     * 根据ID获取属性值信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @return
     */
    Result<PropertyValuesODTO> getPropertyValues(Long id);

    /**
     * 
     * 分页查询属性值信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param propertyValuesQueryDTO
     * @return
     */
    Result<QueryResultODTO<PropertyValuesODTO>> queryPropertyValues(PropertyValuesQueryDTO propertyValuesQueryDTO);

    /**
    * The following custom service interface about dubbo
    */
}