package com.suyan.mmc.validate;

import com.suyan.mmc.constant.CouponTypeEnum;
import com.suyan.mmc.model.Coupon;
import com.suyan.common.result.Result;
import com.suyan.common.result.ResultCode;

import java.math.BigDecimal;

import static com.suyan.common.util.ValidationUtil.*;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <mmc>
 * @Comments: <service层优惠券验证类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-10-18>
 * @Modify Date: <2018-10-18>
 * @Version: <1.0>
 */
public class CouponValidate {

    public static boolean validateForCreate(Coupon coupon, Result<?> message) {

        if (isMoreThan(message, Coupon.COUPON_NAME, coupon.getCouponName(), 64)) {
            return false;
        }

        if (CouponTypeEnum.COUPON_DISCOUNT.equal(coupon.getTypeId())) {
            // 折扣券
            if (isNull(message, Coupon.DISCOUNT_AMOUNT, coupon.getDiscountAmount())) {
                return false;
            }
            if (isNull(message, Coupon.COUPON_STATUS, coupon.getCouponStatus())) {
                return false;
            }
            if (coupon.getDiscountAmount().compareTo(BigDecimal.TEN) >= 0 || coupon.getDiscountAmount().compareTo(BigDecimal.ZERO) <= 0) {
                message.setErrorCode(ResultCode.COMMON_MESSAGE, "折扣金额必须大于0小于10");
                return false;
            }
            coupon.setDiscountAmount(coupon.getDiscountAmount().divide(BigDecimal.TEN));
        }

        return true;
    }

    public static boolean validateForUpdate(Coupon coupon, Result<?> message) {
        if (isNull(message, Coupon.ID, coupon.getId())) {
            return false;
        }
        return validateForCreate(coupon, message);
    }
}