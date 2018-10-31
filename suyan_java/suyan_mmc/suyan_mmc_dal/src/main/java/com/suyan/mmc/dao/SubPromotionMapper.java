package com.suyan.mmc.dao;

import com.suyan.mmc.model.SubPromotion;
import com.suyan.mmc.model.SubPromotionExample;
import com.suyan.mmc.req.SubPromotionQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubPromotionMapper {
    
    long countByExample(SubPromotionExample example);

    int deleteByExample(SubPromotionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SubPromotion record);

    int insertSelective(SubPromotion record);

    List<SubPromotion> selectByExample(SubPromotionExample example);

    SubPromotion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SubPromotion record, @Param("example") SubPromotionExample example);

    int updateByExample(@Param("record") SubPromotion record, @Param("example") SubPromotionExample example);

    int updateByPrimaryKeySelective(SubPromotion record);

    int updateByPrimaryKey(SubPromotion record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id,
            @Param("updateUser") String updateUser,
            @Param("updateUserName") String updateUserName
    );

    SubPromotion selectByPrimaryKeyForUpdate(Long id);

    List<SubPromotion> querySubPromotion(SubPromotionQueryDTO subPromotionQuery);

    int insertBatch(@Param("modelList") List<SubPromotion> modelList);



}