package com.suyan.goods.dao;

import com.suyan.goods.model.Brand;
import com.suyan.goods.model.BrandExample;
import com.suyan.goods.req.BrandQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface BrandMapper {
    
    long countByExample(BrandExample example);

    int deleteByExample(BrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Brand record);

    int insertSelective(Brand record);

    List<Brand> selectByExample(BrandExample example);

    Brand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByExample(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id,
            @Param("updateUser") String updateUser,
            @Param("updateUserName") String updateUserName
    );

    Brand selectByPrimaryKeyForUpdate(Long id);

    List<Brand> queryBrand(BrandQueryDTO brandQuery);

    int insertBatch(@Param("modelList") List<Brand> modelList);



}