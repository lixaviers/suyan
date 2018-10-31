package com.suyan.mmc.service;

import com.suyan.mmc.req.CouponDTO;
import com.suyan.mmc.req.CouponQueryDTO;
import com.suyan.mmc.resp.CouponODTO;
import com.suyan.mmc.resp.base.QueryResultODTO;
import com.suyan.mmc.result.MmcResult;

import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <mmc>
 * @Comments: <对外API 优惠券管理接口>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-10-18>
 * @Modify Date: <2018-10-18>
 * @Version: <1.0>
 */
public interface ICouponService {

    /**
     * 
     * 删除优惠券
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @param updateUser
     * @param updateUserName
     * @return
     */
    MmcResult<Integer> deleteCoupon(Long id, String updateUser, String updateUserName);
    
    /**
     * 
     * 创建优惠券
     * 
     * @author lixavier
     * @version 1.0.0
     * @param couponDTO
     * @return
     */
    MmcResult<Long> createCoupon(CouponDTO couponDTO);

    /**
     *
     * 批量创建优惠券
     *
     * @author lixavier
     * @version 1.0.0
     * @param couponDTOs
     * @return
     */
    MmcResult<Integer> batchCreate(List<CouponDTO> couponDTOs);

    /**
     * 
     * 更新优惠券
     * 
     * @author lixavier
     * @version 1.0.0
     * @param couponDTO
     * @return
     */
    MmcResult<Integer> updateCoupon(CouponDTO couponDTO);
    
    /**
     * 
     * 根据ID获取优惠券信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @return
     */
    MmcResult<CouponODTO> getCoupon(Long id);

    /**
     * 
     * 分页查询优惠券信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param couponQueryDTO
     * @return
     */
    MmcResult<QueryResultODTO<CouponODTO>> queryCoupon(CouponQueryDTO couponQueryDTO);


    /**
     * 修改优惠券状态
     * @param couponDTO
     * @return
     */
    MmcResult<Integer> changeStatus(CouponDTO couponDTO);
}