package com.suyan.goods.service.impl;

import com.suyan.goods.biz.PropertyValuesBiz;
import com.suyan.goods.convertor.PropertyValuesConvertor;
import com.suyan.goods.model.PropertyValues;
import com.suyan.goods.req.PropertyValuesDTO;
import com.suyan.goods.req.PropertyValuesQueryDTO;
import com.suyan.goods.resp.PropertyValuesODTO;
import com.suyan.common.resp.QueryResultODTO;
import com.suyan.common.result.Result;
import com.suyan.goods.service.IPropertyValuesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.suyan.goods.validate.PropertyValuesValidate.validateForCreate;
import static com.suyan.goods.validate.PropertyValuesValidate.validateForUpdate;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <goods>
 * @Comments: <Dubbo Service 属性值管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-12>
 * @Modify Date: <2018-11-12>
 * @Version: <1.0>
 */
@Service("propertyValuesService")
public class PropertyValuesServiceImpl implements IPropertyValuesService {
    private final Logger logger = LoggerFactory.getLogger(PropertyValuesServiceImpl.class);

    @Autowired
    private PropertyValuesBiz propertyValuesBiz;

    /**
     * 
     * 删除属性值
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param id
    * @param updateUser
    * @param updateUserName
     * @return
     */
    @Override
    public Result<Integer> deletePropertyValues(Long id , String updateUser, String updateUserName ){
        Result<Integer> result = Result.newSuccess();
        result.setDataMap(propertyValuesBiz.deletePropertyValues(id , updateUser, updateUserName ));
        return result;
    }
    
    /**
     * 
     * 创建属性值
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param propertyValuesDTO
     * @return
     */
    @Override
    public Result<Long> createPropertyValues(PropertyValuesDTO propertyValuesDTO){
        Result<Long> result = Result.newSuccess();
        PropertyValues propertyValues = PropertyValuesConvertor.toPropertyValues(propertyValuesDTO);
        if (!validateForCreate(propertyValues, result)) {
            return result;
        }
        result.setDataMap(propertyValuesBiz.createPropertyValues( propertyValues ));
        return  result;
    }

    @Override
    public Result<Integer> batchCreate(List<PropertyValuesDTO> propertyValuesDTOs ) {
            Result<Integer> result = Result.newSuccess();
        List<PropertyValues> items = PropertyValuesConvertor.toPropertyValuesList(propertyValuesDTOs);
        result.setDataMap(propertyValuesBiz.batchCreatePropertyValues(items));
        return result;
    }

    /**
     * 
     * 更新属性值
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param propertyValuesDTO
     * @return
     */
    @Override
    public Result<Integer> updatePropertyValues(PropertyValuesDTO propertyValuesDTO){
        Result<Integer> result = Result.newSuccess();
        PropertyValues propertyValues = null;
        propertyValues = PropertyValuesConvertor.toPropertyValues(propertyValuesDTO);
        if (!validateForUpdate(propertyValues, result)) {
            return result;
        }
        result.setDataMap(propertyValuesBiz.updatePropertyValues( propertyValues ));
        return result;
    }
    
    /**
     * 
     * 根据ID获取属性值信息
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param id
     * @return
     */
    @Override
    public Result<PropertyValuesODTO> getPropertyValues( Long id ){
        Result<PropertyValuesODTO> result  = Result.newSuccess();
        PropertyValues propertyValues = propertyValuesBiz.getPropertyValues( id );
        PropertyValuesODTO propertyValuesODTO = PropertyValuesConvertor.toPropertyValuesODTO(propertyValues);
        result.setDataMap(propertyValuesODTO);
        return result;
    }

    /**
     * 
     * 分页查询属性值信息
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param propertyValuesQueryDTO
     * @return
     */
    @Override
    public Result<QueryResultODTO<PropertyValuesODTO>> queryPropertyValues(PropertyValuesQueryDTO propertyValuesQueryDTO) {
        Result<QueryResultODTO<PropertyValuesODTO>> result = Result.newSuccess();

        QueryResultODTO<PropertyValues> resultInfo = propertyValuesBiz.queryPropertyValues(propertyValuesQueryDTO);
        result.setDataMap(PropertyValuesConvertor.toQueryResult(resultInfo));

        return result;
    }
}