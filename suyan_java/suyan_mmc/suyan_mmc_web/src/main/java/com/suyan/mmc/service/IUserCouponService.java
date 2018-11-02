package com.suyan.mmc.service;

import com.suyan.mmc.req.UserCouponDTO;
import com.suyan.mmc.req.UserCouponQueryDTO;
import com.suyan.mmc.resp.UserCouponODTO;
import com.suyan.common.resp.QueryResultODTO;
import com.suyan.common.result.Result;

import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <mmc>
 * @Comments: <对外API 用户优惠券管理接口>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-10-18>
 * @Modify Date: <2018-10-18>
 * @Version: <1.0>
 */
public interface IUserCouponService {

    /**
     * 
     * 删除用户优惠券
     * 
     * @author lixavier
     * @version 1.0.0
    * @param id
     * @return
     */
    Result<Integer> deleteUserCoupon(Long id);
    
    /**
     * 
     * 创建用户优惠券
     * 
     * @author lixavier
     * @version 1.0.0
     * @param userCouponDTO
     * @return
     */
    Result<Long> createUserCoupon(UserCouponDTO userCouponDTO);

    /**
     *
     * 批量创建用户优惠券
     *
     * @author lixavier
     * @version 1.0.0
     * @param userCouponDTOs
     * @return
     */
    Result<Integer> batchCreate(List<UserCouponDTO> userCouponDTOs);

    /**
     * 
     * 更新用户优惠券
     * 
     * @author lixavier
     * @version 1.0.0
     * @param userCouponDTO
     * @return
     */
    Result<Integer> updateUserCoupon(UserCouponDTO userCouponDTO);
    
    /**
     * 
     * 根据ID获取用户优惠券信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @return
     */
    Result<UserCouponODTO> getUserCoupon(Long id);

    /**
     * 
     * 分页查询用户优惠券信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param userCouponQueryDTO
     * @return
     */
    Result<QueryResultODTO<UserCouponODTO>> queryUserCoupon(UserCouponQueryDTO userCouponQueryDTO);

    /**
    * The following custom service interface about dubbo
    */
}