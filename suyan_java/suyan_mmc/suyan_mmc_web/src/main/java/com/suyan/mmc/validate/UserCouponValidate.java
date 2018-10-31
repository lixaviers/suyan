package com.suyan.mmc.validate;

import com.suyan.mmc.model.UserCoupon;
import com.suyan.mmc.result.MmcResult;

import static com.suyan.mmc.util.ValidationUtil.isEmptyOrMoreThan;
import static com.suyan.mmc.util.ValidationUtil.isNull;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <mmc>
 * @Comments: <service层用户优惠券验证类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-10-18>
 * @Modify Date: <2018-10-18>
 * @Version: <1.0>
 */
public class UserCouponValidate {

    public static boolean validateForCreate(UserCoupon userCoupon, MmcResult<?> message) {

        if (isNull(message,UserCoupon.COUPON_ID, userCoupon.getCouponId())) {
            return false;
        }
        if (isEmptyOrMoreThan(message, UserCoupon.COUPON_CODE, userCoupon.getCouponCode(), 32)) {
            return false;
        }
        if (isEmptyOrMoreThan(message, UserCoupon.USER_OPEN_ID, userCoupon.getUserOpenId(), 32)) {
            return false;
        }
        if (isEmptyOrMoreThan(message, UserCoupon.MOBILE, userCoupon.getMobile(), 16)) {
            return false;
        }
        if (isEmptyOrMoreThan(message, UserCoupon.ORDER_NO, userCoupon.getOrderNo(), 32)) {
            return false;
        }

        if (isNull(message,UserCoupon.COUPON_STATUS, userCoupon.getCouponStatus())) {
            return false;
        }
        if (isEmptyOrMoreThan(message, UserCoupon.CREATE_USER, userCoupon.getCreateUser(), 32)) {
            return false;
        }
        if (isEmptyOrMoreThan(message, UserCoupon.UPDATE_USER, userCoupon.getUpdateUser(), 32)) {
            return false;
        }
        return true;
    }
    
    public static boolean validateForUpdate(UserCoupon userCoupon, MmcResult<?> message) {
        if (isNull(message,UserCoupon.ID, userCoupon.getId())) {
            return false;
        }
        return validateForCreate(userCoupon, message);
    }
}