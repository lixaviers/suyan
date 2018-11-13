package com.suyan.goods.service.impl;

import com.suyan.goods.biz.PropertyNameBiz;
import com.suyan.goods.convertor.PropertyNameConvertor;
import com.suyan.goods.model.PropertyName;
import com.suyan.goods.req.PropertyNameDTO;
import com.suyan.goods.req.PropertyNameQueryDTO;
import com.suyan.goods.resp.PropertyNameODTO;
import com.suyan.common.resp.QueryResultODTO;
import com.suyan.common.result.Result;
import com.suyan.goods.service.IPropertyNameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.suyan.goods.validate.PropertyNameValidate.validateForCreate;
import static com.suyan.goods.validate.PropertyNameValidate.validateForUpdate;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <goods>
 * @Comments: <Dubbo Service 属性名管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-12>
 * @Modify Date: <2018-11-12>
 * @Version: <1.0>
 */
@Service("propertyNameService")
public class PropertyNameServiceImpl implements IPropertyNameService {
    private final Logger logger = LoggerFactory.getLogger(PropertyNameServiceImpl.class);

    @Autowired
    private PropertyNameBiz propertyNameBiz;

    /**
     * 删除属性名
     *
     * @param id
     * @param updateUser
     * @param updateUserName
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public Result<Integer> deletePropertyName(Long id, String updateUser, String updateUserName) {
        Result<Integer> result = Result.newSuccess();
        result.setDataMap(propertyNameBiz.deletePropertyName(id, updateUser, updateUserName));
        return result;
    }

    /**
     * 创建属性名
     *
     * @param propertyNameDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public Result<Long> createPropertyName(PropertyNameDTO propertyNameDTO) {
        Result<Long> result = Result.newSuccess();
        PropertyName propertyName = PropertyNameConvertor.toPropertyName(propertyNameDTO);
        if (!validateForCreate(propertyName, result)) {
            return result;
        }
        result.setDataMap(propertyNameBiz.createPropertyName(propertyName));
        return result;
    }

    @Override
    public Result<Integer> batchCreate(List<PropertyNameDTO> propertyNameDTOs) {
        Result<Integer> result = Result.newSuccess();
        List<PropertyName> items = PropertyNameConvertor.toPropertyNameList(propertyNameDTOs);
        result.setDataMap(propertyNameBiz.batchCreatePropertyName(items));
        return result;
    }

    /**
     * 更新属性名
     *
     * @param propertyNameDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public Result<Integer> updatePropertyName(PropertyNameDTO propertyNameDTO) {
        Result<Integer> result = Result.newSuccess();
        PropertyName propertyName = null;
        propertyName = PropertyNameConvertor.toPropertyName(propertyNameDTO);
        if (!validateForUpdate(propertyName, result)) {
            return result;
        }
        result.setDataMap(propertyNameBiz.updatePropertyName(propertyName));
        return result;
    }

    /**
     * 根据ID获取属性名信息
     *
     * @param id
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public Result<PropertyNameODTO> getPropertyName(Long id) {
        Result<PropertyNameODTO> result = Result.newSuccess();
        PropertyName propertyName = propertyNameBiz.getPropertyName(id);
        PropertyNameODTO propertyNameODTO = PropertyNameConvertor.toPropertyNameODTO(propertyName);
        result.setDataMap(propertyNameODTO);
        return result;
    }

    /**
     * 分页查询属性名信息
     *
     * @param propertyNameQueryDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public Result<QueryResultODTO<PropertyNameODTO>> queryPropertyName(PropertyNameQueryDTO propertyNameQueryDTO) {
        Result<QueryResultODTO<PropertyNameODTO>> result = Result.newSuccess();
        QueryResultODTO<PropertyName> resultInfo = propertyNameBiz.queryPropertyName(propertyNameQueryDTO);
        result.setDataMap(PropertyNameConvertor.toQueryResult(resultInfo));
        return result;
    }

    @Override
    public Result<List<PropertyNameODTO>> getPropertysByCategoryId(Long categoryId) {
        Result<List<PropertyNameODTO>> result = Result.newSuccess();
        result.setDataMap(PropertyNameConvertor.toPropertyNameODTOList(propertyNameBiz.getPropertysByCategoryId(categoryId)));
        return result;
    }

}