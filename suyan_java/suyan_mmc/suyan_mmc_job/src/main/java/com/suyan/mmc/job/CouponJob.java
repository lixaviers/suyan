package com.suyan.mmc.job;

import com.suyan.mmc.constant.CommonStatusEnum;
import com.suyan.mmc.constant.PromotionTypeEnum;
import com.suyan.mmc.dao.CouponMapper;
import com.suyan.mmc.dao.StatusLogMapper;
import com.suyan.mmc.dao.ext.CouponExtMapper;
import com.suyan.mmc.model.Coupon;
import com.suyan.mmc.model.CouponExample;
import com.suyan.mmc.model.StatusLog;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CouponJob {
    private final Logger logger = LoggerFactory.getLogger(CouponJob.class);

    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private CouponExtMapper couponExtMapper;
    @Autowired
    private StatusLogMapper statusLogMapper;

    /**
     * 1分钟执行，单位：ms
     */
    @Scheduled(fixedRate = 60000)
    public void couponStart() {
        CouponExample example = new CouponExample();
        example.createCriteria().andIsDeletedEqualTo(false)
                .andStartTimeLessThanOrEqualTo(new Date())
                .andCouponStatusEqualTo(CommonStatusEnum.ONLINE.getValue())
                .andCouponPackageIdEqualTo(0l);
        List<Coupon> coupons = couponMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(coupons)) {
            for (Coupon coupon : coupons) {
                int count = couponExtMapper.updateCouponStatus(coupon.getId(), CommonStatusEnum.ONLINE.getValue(), CommonStatusEnum.ONGOING.getValue());
                if (count > 0) {
                    // 添加状态变更记录
                    StatusLog statusLog = new StatusLog();
                    statusLog.setType(PromotionTypeEnum.COUPON.getValue());
                    statusLog.setEntityId(coupon.getId());
                    statusLog.setOldStatus(CommonStatusEnum.ONLINE.getValue());
                    statusLog.setNewStatus(CommonStatusEnum.ONGOING.getValue());
                    statusLog.setOperationUser("mmc-job");
                    statusLog.setOperationUserName("mmc定时任务");
                    statusLogMapper.insertSelective(statusLog);
                }
            }
        }
    }

    /**
     * 1分钟执行，单位：ms
     */
    @Scheduled(fixedRate = 60000)
    public void couponEnd() {
        List<Byte> statusList = new ArrayList<>();
        statusList.add(CommonStatusEnum.ONLINE.getValue());
        statusList.add(CommonStatusEnum.ONGOING.getValue());
        statusList.add(CommonStatusEnum.STOPED.getValue());
        statusList.add(CommonStatusEnum.CANCELED.getValue());

        CouponExample example = new CouponExample();
        example.createCriteria().andIsDeletedEqualTo(false)
                .andEndTimeLessThanOrEqualTo(new Date())
                .andCouponStatusIn(statusList)
                .andCouponPackageIdEqualTo(0l);
        List<Coupon> coupons = couponMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(coupons)) {
            for (Coupon coupon : coupons) {
                couponExtMapper.updateCouponStatus(coupon.getId(), coupon.getCouponStatus(), CommonStatusEnum.ENDED.getValue());
                // 添加状态变更记录
                StatusLog statusLog = new StatusLog();
                statusLog.setType(PromotionTypeEnum.COUPON.getValue());
                statusLog.setEntityId(coupon.getId());
                statusLog.setOldStatus(coupon.getCouponStatus());
                statusLog.setNewStatus(CommonStatusEnum.ENDED.getValue());
                statusLog.setOperationUser("mmc-job");
                statusLog.setOperationUserName("mmc定时任务");
                statusLogMapper.insertSelective(statusLog);
            }
        }
    }
}
