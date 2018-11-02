package com.suyan.mmc.service.impl;

import com.suyan.mmc.biz.UserCouponBiz;
import com.suyan.mmc.convertor.UserCouponConvertor;
import com.suyan.mmc.model.UserCoupon;
import com.suyan.mmc.req.UserCouponDTO;
import com.suyan.mmc.req.UserCouponQueryDTO;
import com.suyan.mmc.resp.UserCouponODTO;
import com.suyan.common.resp.QueryResultODTO;
import com.suyan.common.result.Result;
import com.suyan.mmc.service.IUserCouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.suyan.mmc.validate.UserCouponValidate.validateForCreate;
import static com.suyan.mmc.validate.UserCouponValidate.validateForUpdate;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <mmc>
 * @Comments: <Dubbo Service 用户优惠券管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-10-18>
 * @Modify Date: <2018-10-18>
 * @Version: <1.0>
 */
@Service("userCouponService")
public class UserCouponServiceImpl implements IUserCouponService {
    private final Logger logger = LoggerFactory.getLogger(UserCouponServiceImpl.class);

    @Autowired
    private UserCouponBiz userCouponBiz;

    /**
     * 删除用户优惠券
     *
     * @param id
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public Result<Integer> deleteUserCoupon(Long id) {
        Result<Integer> result = Result.newSuccess();
        result.setDataMap(userCouponBiz.deleteUserCoupon(id));
        return result;
    }

    /**
     * 创建用户优惠券
     *
     * @param userCouponDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public Result<Long> createUserCoupon(UserCouponDTO userCouponDTO) {
        Result<Long> result = Result.newSuccess();
        UserCoupon userCoupon = UserCouponConvertor.toUserCoupon(userCouponDTO);
        if (!validateForCreate(userCoupon, result)) {
            return result;
        }
        result.setDataMap(userCouponBiz.createUserCoupon(userCoupon));
        return result;
    }

    @Override
    public Result<Integer> batchCreate(List<UserCouponDTO> userCouponDTOs) {
        Result<Integer> result = Result.newSuccess();
        List<UserCoupon> items = UserCouponConvertor.toUserCouponList(userCouponDTOs);
        result.setDataMap(userCouponBiz.batchCreateUserCoupon(items));
        return result;
    }

    /**
     * 更新用户优惠券
     *
     * @param userCouponDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public Result<Integer> updateUserCoupon(UserCouponDTO userCouponDTO) {
        Result<Integer> result = Result.newSuccess();
        UserCoupon userCoupon = UserCouponConvertor.toUserCoupon(userCouponDTO);
        if (!validateForUpdate(userCoupon, result)) {
            return result;
        }
        result.setDataMap(userCouponBiz.updateUserCoupon(userCoupon));
        return result;
    }

    /**
     * 根据ID获取用户优惠券信息
     *
     * @param id
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public Result<UserCouponODTO> getUserCoupon(Long id) {
        Result<UserCouponODTO> result = Result.newSuccess();
        UserCoupon userCoupon = userCouponBiz.getUserCoupon(id);
        UserCouponODTO userCouponODTO = UserCouponConvertor.toUserCouponODTO(userCoupon);
        result.setDataMap(userCouponODTO);
        return result;
    }

    /**
     * 分页查询用户优惠券信息
     *
     * @param userCouponQueryDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public Result<QueryResultODTO<UserCouponODTO>> queryUserCoupon(UserCouponQueryDTO userCouponQueryDTO) {
        Result<QueryResultODTO<UserCouponODTO>> result = Result.newSuccess();

        QueryResultODTO<UserCoupon> resultInfo = userCouponBiz.queryUserCoupon(userCouponQueryDTO);
        result.setDataMap(UserCouponConvertor.toQueryResult(resultInfo));

        return result;
    }
}