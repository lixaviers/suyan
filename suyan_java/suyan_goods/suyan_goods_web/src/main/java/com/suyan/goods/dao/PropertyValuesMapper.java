package com.suyan.goods.dao;

import com.suyan.goods.model.PropertyValues;
import com.suyan.goods.model.PropertyValuesExample;
import com.suyan.goods.req.PropertyValuesQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface PropertyValuesMapper {
    
    long countByExample(PropertyValuesExample example);

    int deleteByExample(PropertyValuesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PropertyValues record);

    int insertSelective(PropertyValues record);

    List<PropertyValues> selectByExample(PropertyValuesExample example);

    PropertyValues selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PropertyValues record, @Param("example") PropertyValuesExample example);

    int updateByExample(@Param("record") PropertyValues record, @Param("example") PropertyValuesExample example);

    int updateByPrimaryKeySelective(PropertyValues record);

    int updateByPrimaryKey(PropertyValues record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id,
            @Param("updateUser") String updateUser,
            @Param("updateUserName") String updateUserName
    );

    PropertyValues selectByPrimaryKeyForUpdate(Long id);

    List<PropertyValues> queryPropertyValues(PropertyValuesQueryDTO propertyValuesQuery);

    int insertBatch(@Param("modelList") List<PropertyValues> modelList);



}