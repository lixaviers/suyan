package com.suyan.mmc.job;

import com.suyan.mmc.constant.CommonStatusEnum;
import com.suyan.mmc.constant.PromotionTypeEnum;
import com.suyan.mmc.dao.CouponMapper;
import com.suyan.mmc.dao.StatusLogMapper;
import com.suyan.mmc.dao.SubPromotionMapper;
import com.suyan.mmc.dao.ext.CouponExtMapper;
import com.suyan.mmc.dao.ext.SubPromotionExtMapper;
import com.suyan.mmc.model.*;
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
public class SubPromotionJob {
    private final Logger logger = LoggerFactory.getLogger(SubPromotionJob.class);

    @Autowired
    private SubPromotionMapper subPromotionMapper;
    @Autowired
    private SubPromotionExtMapper subPromotionExtMapper;
    @Autowired
    private StatusLogMapper statusLogMapper;

    /**
     * 1分钟执行，单位：ms
     */
    @Scheduled(fixedRate = 60000)
    public void couponStart() {
        SubPromotionExample example = new SubPromotionExample();
        example.createCriteria().andIsDeletedEqualTo(false)
                .andStartTimeLessThanOrEqualTo(new Date())
                .andPromotionStatusEqualTo(CommonStatusEnum.ONLINE.getValue());
        List<SubPromotion> subPromotionList = subPromotionMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(subPromotionList)) {
            for (SubPromotion subPromotion : subPromotionList) {
                int count = subPromotionExtMapper.updateCouponStatus(subPromotion.getId(), CommonStatusEnum.ONLINE.getValue(), CommonStatusEnum.ONGOING.getValue());
                if (count > 0) {
                    // 添加状态变更记录
                    StatusLog statusLog = new StatusLog();
                    statusLog.setType(PromotionTypeEnum.SUB_PROMOTION.getValue());
                    statusLog.setEntityId(subPromotion.getId());
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

        SubPromotionExample example = new SubPromotionExample();
        example.createCriteria().andIsDeletedEqualTo(false)
                .andEndTimeLessThanOrEqualTo(new Date())
                .andPromotionStatusIn(statusList);
        List<SubPromotion> subPromotionList = subPromotionMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(subPromotionList)) {
            for (SubPromotion subPromotion : subPromotionList) {
                int count = subPromotionExtMapper.updateCouponStatus(subPromotion.getId(), subPromotion.getPromotionStatus(), CommonStatusEnum.ENDED.getValue());
                if (count > 0) {
                    // 添加状态变更记录
                    StatusLog statusLog = new StatusLog();
                    statusLog.setType(PromotionTypeEnum.SUB_PROMOTION.getValue());
                    statusLog.setEntityId(subPromotion.getId());
                    statusLog.setOldStatus(subPromotion.getPromotionStatus());
                    statusLog.setNewStatus(CommonStatusEnum.ENDED.getValue());
                    statusLog.setOperationUser("mmc-job");
                    statusLog.setOperationUserName("mmc定时任务");
                    statusLogMapper.insertSelective(statusLog);
                }
            }
        }
    }
}
