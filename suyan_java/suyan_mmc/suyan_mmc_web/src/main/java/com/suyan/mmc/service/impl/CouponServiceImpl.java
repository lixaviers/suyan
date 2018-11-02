package com.suyan.mmc.service.impl;

import com.suyan.mmc.biz.CouponBiz;
import com.suyan.mmc.convertor.CouponConvertor;
import com.suyan.mmc.model.Coupon;
import com.suyan.mmc.req.CouponDTO;
import com.suyan.mmc.req.CouponQueryDTO;
import com.suyan.mmc.resp.CouponODTO;
import com.suyan.common.resp.QueryResultODTO;
import com.suyan.common.result.Result;
import com.suyan.mmc.service.ICouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.suyan.mmc.validate.CouponValidate.validateForCreate;
import static com.suyan.mmc.validate.CouponValidate.validateForUpdate;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <mmc>
 * @Comments: <Dubbo Service 优惠券管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-10-18>
 * @Modify Date: <2018-10-18>
 * @Version: <1.0>
 */
@Service("couponService")
public class CouponServiceImpl implements ICouponService {
    private final Logger logger = LoggerFactory.getLogger(CouponServiceImpl.class);

    @Autowired
    private CouponBiz couponBiz;

    /**
     * 删除优惠券
     *
     * @param id
     * @param updateUser
     * @param updateUserName
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public Result<Integer> deleteCoupon(Long id, String updateUser, String updateUserName) {
        Result<Integer> result = Result.newSuccess();
        result.setDataMap(couponBiz.deleteCoupon(id, updateUser, updateUserName));
        return result;
    }

    /**
     * 创建优惠券
     *
     * @param couponDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public Result<Long> createCoupon(CouponDTO couponDTO) {
        Result<Long> result = Result.newSuccess();
        Coupon coupon = CouponConvertor.toCoupon(couponDTO);
        if (!validateForCreate(coupon, result)) {
            return result;
        }
        result.setDataMap(couponBiz.createCoupon(coupon));
        return result;
    }

    @Override
    public Result<Integer> batchCreate(List<CouponDTO> couponDTOs) {
        Result<Integer> result = Result.newSuccess();
        List<Coupon> items = CouponConvertor.toCouponList(couponDTOs);
        result.setDataMap(couponBiz.batchCreateCoupon(items));
        return result;
    }

    /**
     * 更新优惠券
     *
     * @param couponDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public Result<Integer> updateCoupon(CouponDTO couponDTO) {
        Result<Integer> result = Result.newSuccess();
        Coupon coupon = CouponConvertor.toCoupon(couponDTO);
        if (!validateForUpdate(coupon, result)) {
            return result;
        }
        result.setDataMap(couponBiz.updateCoupon(coupon));
        return result;
    }

    /**
     * 根据ID获取优惠券信息
     *
     * @param id
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public Result<CouponODTO> getCoupon(Long id) {
        Result<CouponODTO> result = Result.newSuccess();
        Coupon coupon = couponBiz.getCoupon(id);
        CouponODTO couponODTO = CouponConvertor.toCouponODTO(coupon);
        result.setDataMap(couponODTO);
        return result;
    }

    /**
     * 分页查询优惠券信息
     *
     * @param couponQueryDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public Result<QueryResultODTO<CouponODTO>> queryCoupon(CouponQueryDTO couponQueryDTO) {
        Result<QueryResultODTO<CouponODTO>> result = Result.newSuccess();

        QueryResultODTO<Coupon> resultInfo = couponBiz.queryCoupon(couponQueryDTO);
        result.setDataMap(CouponConvertor.toQueryResult(resultInfo));

        return result;
    }

    @Override
    public Result<Integer> changeStatus(CouponDTO couponDTO) {
        Result<Integer> result = Result.newSuccess();
        Coupon coupon = CouponConvertor.toCoupon(couponDTO);
        result.setDataMap(couponBiz.changeStatus(coupon));
        return result;
    }
}