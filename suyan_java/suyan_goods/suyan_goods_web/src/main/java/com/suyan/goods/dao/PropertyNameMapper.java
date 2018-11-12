package com.suyan.goods.dao;

import com.suyan.goods.model.PropertyName;
import com.suyan.goods.model.PropertyNameExample;
import com.suyan.goods.req.PropertyNameQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface PropertyNameMapper {
    
    long countByExample(PropertyNameExample example);

    int deleteByExample(PropertyNameExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PropertyName record);

    int insertSelective(PropertyName record);

    List<PropertyName> selectByExample(PropertyNameExample example);

    PropertyName selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PropertyName record, @Param("example") PropertyNameExample example);

    int updateByExample(@Param("record") PropertyName record, @Param("example") PropertyNameExample example);

    int updateByPrimaryKeySelective(PropertyName record);

    int updateByPrimaryKey(PropertyName record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id,
            @Param("updateUser") String updateUser,
            @Param("updateUserName") String updateUserName
    );

    PropertyName selectByPrimaryKeyForUpdate(Long id);

    List<PropertyName> queryPropertyName(PropertyNameQueryDTO propertyNameQuery);

    int insertBatch(@Param("modelList") List<PropertyName> modelList);



}