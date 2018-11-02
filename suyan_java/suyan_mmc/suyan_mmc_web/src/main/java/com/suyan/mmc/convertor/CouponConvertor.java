package com.suyan.mmc.convertor;

import com.suyan.mmc.constant.CommonStatusEnum;
import com.suyan.mmc.constant.CouponTypeEnum;
import com.suyan.mmc.model.Coupon;
import com.suyan.mmc.req.CouponDTO;
import com.suyan.mmc.resp.CouponODTO;
import com.suyan.common.resp.QueryResultODTO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <mmc>
 * @Comments: <Dubbo层优惠券转换类 Dubbo层的Info对象与dal层的model对象相互转换>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-10-18>
 * @Modify Date: <2018-10-18>
 * @Version: <1.0>
 */
public abstract class CouponConvertor {

    private static final BeanCopier beanCopierForCouponODTO = BeanCopier.create(Coupon.class, CouponODTO.class, false);
    private static final BeanCopier beanCopierForCoupon = BeanCopier.create(CouponDTO.class, Coupon.class, false);

    public static CouponODTO toCouponODTO(Coupon coupon) {
        if (coupon == null) {
            return null;
        }
        CouponODTO couponODTO = new CouponODTO();
        beanCopierForCouponODTO.copy(coupon, couponODTO, null);
        couponODTO.setCouponStatusDesc(CommonStatusEnum.getDescByValue(coupon.getCouponStatus()));
        couponODTO.setTypeDesc(CouponTypeEnum.getNameByValue(coupon.getTypeId()));
        return couponODTO;
    }

    public static Coupon toCoupon(CouponDTO couponDTO) {
        Coupon coupon = new Coupon();
        beanCopierForCoupon.copy(couponDTO, coupon, null);
        return coupon;
    }

    public static List<CouponODTO> toCouponODTOList(List<Coupon> couponList) {
        if (couponList == null || couponList.isEmpty()) {
            return null;
        }
        List<CouponODTO> couponInfoList = new ArrayList<CouponODTO>(couponList.size());
        for (Coupon coupon : couponList) {
            couponInfoList.add(toCouponODTO(coupon));
        }
        return couponInfoList;
    }

    public static List<Coupon> toCouponList(List<CouponDTO> couponDTOList) {
        if (couponDTOList == null || couponDTOList.isEmpty()) {
            return null;
        }
        List<Coupon> couponList = new ArrayList<Coupon>(couponDTOList.size());
        for (CouponDTO couponDTO : couponDTOList) {
            couponList.add(toCoupon(couponDTO));
        }
        return couponList;
    }

    public static QueryResultODTO<CouponODTO> toQueryResult(QueryResultODTO<Coupon> queryResult) {
        QueryResultODTO<CouponODTO> queryResultInfo = new QueryResultODTO<CouponODTO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toCouponODTOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}