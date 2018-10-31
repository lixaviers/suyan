package com.suyan.mmc.dao;

import com.suyan.mmc.model.Coupon;
import com.suyan.mmc.model.CouponExample;
import com.suyan.mmc.req.CouponQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponMapper {
    
    long countByExample(CouponExample example);

    int deleteByExample(CouponExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    List<Coupon> selectByExample(CouponExample example);

    Coupon selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Coupon record, @Param("example") CouponExample example);

    int updateByExample(@Param("record") Coupon record, @Param("example") CouponExample example);

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id,
            @Param("updateUser") String updateUser,
            @Param("updateUserName") String updateUserName
    );

    Coupon selectByPrimaryKeyForUpdate(Long id);

    List<Coupon> queryCoupon(CouponQueryDTO couponQuery);

    int insertBatch(@Param("modelList") List<Coupon> modelList);



}