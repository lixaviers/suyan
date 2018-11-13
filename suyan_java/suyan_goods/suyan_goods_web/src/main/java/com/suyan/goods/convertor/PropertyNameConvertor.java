package com.suyan.goods.convertor;

import com.suyan.goods.model.PropertyName;
import com.suyan.goods.req.PropertyNameDTO;
import com.suyan.goods.resp.PropertyNameODTO;
import com.suyan.common.resp.QueryResultODTO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <goods>
 * @Comments: <Dubbo层属性名转换类 Dubbo层的Info对象与dal层的model对象相互转换>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-12>
 * @Modify Date: <2018-11-12>
 * @Version: <1.0>
 */
public abstract class PropertyNameConvertor {

    private static final BeanCopier beanCopierForPropertyNameODTO = BeanCopier.create(PropertyName.class, PropertyNameODTO.class, false);
    private static final BeanCopier beanCopierForPropertyName = BeanCopier.create(PropertyNameDTO.class, PropertyName.class, false);

    public static PropertyNameODTO toPropertyNameODTO(PropertyName propertyName) {
        if (propertyName == null) {
            return null;
        }
        PropertyNameODTO propertyNameODTO = new PropertyNameODTO();
        beanCopierForPropertyNameODTO.copy(propertyName, propertyNameODTO, null);
        propertyNameODTO.setPropertyValuesList(PropertyValuesConvertor.toPropertyValuesODTOList(propertyName.getPropertyValuesList()));
        return propertyNameODTO;
    }

    public static PropertyName toPropertyName(PropertyNameDTO propertyNameDTO) {
        PropertyName propertyName = new PropertyName();
        beanCopierForPropertyName.copy(propertyNameDTO, propertyName, null);
        return propertyName;
    }

    public static List<PropertyNameODTO> toPropertyNameODTOList(List<PropertyName> propertyNameList) {
        if (propertyNameList == null || propertyNameList.isEmpty()) {
            return null;
        }
        List<PropertyNameODTO> propertyNameInfoList = new ArrayList<PropertyNameODTO>(propertyNameList.size());
        for (PropertyName propertyName : propertyNameList) {
            propertyNameInfoList.add(toPropertyNameODTO(propertyName));
        }
        return propertyNameInfoList;
    }

    public static List<PropertyName> toPropertyNameList(List<PropertyNameDTO> propertyNameDTOList) {
        if (propertyNameDTOList == null || propertyNameDTOList.isEmpty()) {
            return null;
        }
        List<PropertyName> propertyNameList = new ArrayList<PropertyName>(propertyNameDTOList.size());
        for (PropertyNameDTO propertyNameDTO : propertyNameDTOList) {
            propertyNameList.add(toPropertyName(propertyNameDTO));
        }
        return propertyNameList;
    }

    public static QueryResultODTO<PropertyNameODTO> toQueryResult(QueryResultODTO<PropertyName> queryResult) {
        QueryResultODTO<PropertyNameODTO> queryResultInfo = new QueryResultODTO<PropertyNameODTO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toPropertyNameODTOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}