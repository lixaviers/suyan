package com.suyan.mmc.validate;

import com.suyan.mmc.constant.SubPromotionTypeEnum;
import com.suyan.mmc.model.Coupon;
import com.suyan.mmc.model.SubPromotion;
import com.suyan.common.result.Result;
import com.suyan.common.result.ResultCode;

import java.math.BigDecimal;

import static com.suyan.common.util.ValidationUtil.*;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <mmc>
 * @Comments: <service层订单促销验证类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-10-18>
 * @Modify Date: <2018-10-18>
 * @Version: <1.0>
 */
public class SubPromotionValidate {

    public static boolean validateForCreate(SubPromotion subPromotion, Result<?> message) {

        if (isMoreThan(message, SubPromotion.NAME, subPromotion.getName(), 64)) {
            return false;
        }
        if (SubPromotionTypeEnum.SUBPROMOTION_DISCOUNT.equal(subPromotion.getTypeId())) {
            // 折扣券
            if (isNull(message, Coupon.DISCOUNT_AMOUNT, subPromotion.getDiscountAmount())) {
                return false;
            }
            if (subPromotion.getDiscountAmount().compareTo(BigDecimal.TEN) >= 0 || subPromotion.getDiscountAmount().compareTo(BigDecimal.ZERO) <= 0) {
                message.setErrorCode(ResultCode.COMMON_MESSAGE, "折扣金额必须大于0小于10");
                return false;
            }
            subPromotion.setDiscountAmount(subPromotion.getDiscountAmount().divide(BigDecimal.TEN));
        }
        return true;
    }
    
    public static boolean validateForUpdate(SubPromotion subPromotion, Result<?> message) {
        if (isNull(message,SubPromotion.ID, subPromotion.getId())) {
            return false;
        }
        return validateForCreate(subPromotion, message);
    }
}