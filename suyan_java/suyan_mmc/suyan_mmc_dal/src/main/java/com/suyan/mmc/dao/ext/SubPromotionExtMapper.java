package com.suyan.mmc.dao.ext;

import org.apache.ibatis.annotations.Param;

public interface SubPromotionExtMapper {

    int updateCouponStatus(
            @Param("id") Long id,
            @Param("oldStatus") Byte oldStatus,
            @Param("newStatus") Byte newStatus
    );

}