package com.suyan.goods.convertor;

import com.suyan.goods.model.PropertyValues;
import com.suyan.goods.req.PropertyValuesDTO;
import com.suyan.goods.resp.PropertyValuesODTO;
import com.suyan.common.resp.QueryResultODTO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <goods>
 * @Comments: <Dubbo层属性值转换类 Dubbo层的Info对象与dal层的model对象相互转换>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-12>
 * @Modify Date: <2018-11-12>
 * @Version: <1.0>
 */
public abstract class PropertyValuesConvertor {

    private static final BeanCopier beanCopierForPropertyValuesODTO = BeanCopier.create(PropertyValues.class, PropertyValuesODTO.class, false);
    private static final BeanCopier beanCopierForPropertyValues = BeanCopier.create(PropertyValuesDTO.class, PropertyValues.class, false);

    public static PropertyValuesODTO toPropertyValuesODTO(PropertyValues propertyValues) {
        if (propertyValues == null) {
            return null;
        }
        PropertyValuesODTO propertyValuesODTO = new PropertyValuesODTO();
        beanCopierForPropertyValuesODTO.copy(propertyValues, propertyValuesODTO, null);
        return propertyValuesODTO;
    }

    public static PropertyValues toPropertyValues(PropertyValuesDTO propertyValuesDTO) {
        PropertyValues propertyValues = new PropertyValues();
        beanCopierForPropertyValues.copy(propertyValuesDTO, propertyValues, null);
        return propertyValues;
    }

    public static List<PropertyValuesODTO> toPropertyValuesODTOList(List<PropertyValues> propertyValuesList) {
        if (propertyValuesList == null || propertyValuesList.isEmpty()) {
            return null;
        }
        List<PropertyValuesODTO> propertyValuesInfoList = new ArrayList<PropertyValuesODTO>(propertyValuesList.size());
        for (PropertyValues propertyValues : propertyValuesList) {
            propertyValuesInfoList.add(toPropertyValuesODTO(propertyValues));
        }
        return propertyValuesInfoList;
    }

    public static List<PropertyValues> toPropertyValuesList(List<PropertyValuesDTO> propertyValuesDTOList) {
        if (propertyValuesDTOList == null || propertyValuesDTOList.isEmpty()) {
            return null;
        }
        List<PropertyValues> propertyValuesList = new ArrayList<PropertyValues>(propertyValuesDTOList.size());
        for (PropertyValuesDTO propertyValuesDTO : propertyValuesDTOList) {
            propertyValuesList.add(toPropertyValues(propertyValuesDTO));
        }
        return propertyValuesList;
    }

    public static QueryResultODTO<PropertyValuesODTO> toQueryResult(QueryResultODTO<PropertyValues> queryResult) {
        QueryResultODTO<PropertyValuesODTO> queryResultInfo = new QueryResultODTO<PropertyValuesODTO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toPropertyValuesODTOList(queryResult.getRecords()));
        return queryResultInfo;
        }
}