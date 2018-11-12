package com.suyan.goods.service;

import com.suyan.goods.req.PropertyNameDTO;
import com.suyan.goods.req.PropertyNameQueryDTO;
import com.suyan.goods.resp.PropertyNameODTO;
import com.suyan.common.resp.QueryResultODTO;
import com.suyan.common.result.Result;

import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <goods>
 * @Comments: <对外API 属性名管理接口>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-12>
 * @Modify Date: <2018-11-12>
 * @Version: <1.0>
 */
public interface IPropertyNameService {

    /**
     * 
     * 删除属性名
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @param updateUser
     * @param updateUserName
     * @return
     */
    Result<Integer> deletePropertyName(Long id, String updateUser, String updateUserName);
    
    /**
     * 
     * 创建属性名
     * 
     * @author lixavier
     * @version 1.0.0
     * @param propertyNameDTO
     * @return
     */
    Result<Long> createPropertyName(PropertyNameDTO propertyNameDTO);

    /**
     *
     * 批量创建属性名
     *
     * @author lixavier
     * @version 1.0.0
     * @param propertyNameDTOs
     * @return
     */
    Result<Integer> batchCreate(List<PropertyNameDTO> propertyNameDTOs);

    /**
     * 
     * 更新属性名
     * 
     * @author lixavier
     * @version 1.0.0
     * @param propertyNameDTO
     * @return
     */
    Result<Integer> updatePropertyName(PropertyNameDTO propertyNameDTO);
    
    /**
     * 
     * 根据ID获取属性名信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @return
     */
    Result<PropertyNameODTO> getPropertyName(Long id);

    /**
     * 
     * 分页查询属性名信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param propertyNameQueryDTO
     * @return
     */
    Result<QueryResultODTO<PropertyNameODTO>> queryPropertyName(PropertyNameQueryDTO propertyNameQueryDTO);

    /**
    * The following custom service interface about dubbo
    */
}