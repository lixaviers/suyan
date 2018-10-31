package com.suyan.mmc.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.mmc.constant.CommonStatusEnum;
import com.suyan.mmc.constant.PromotionTypeEnum;
import com.suyan.mmc.dao.CouponMapper;
import com.suyan.mmc.dao.StatusLogMapper;
import com.suyan.mmc.exception.CommonBizException;
import com.suyan.mmc.model.Coupon;
import com.suyan.mmc.model.StatusLog;
import com.suyan.mmc.req.CouponQueryDTO;
import com.suyan.mmc.resp.base.QueryResultODTO;
import com.suyan.mmc.result.MmcResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <mmc>
 * @Comments: <业务层优惠券管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-10-18>
 * @Modify Date: <2018-10-18>
 * @Version: <1.0>
 */
@Service("couponBiz")
public class CouponBiz {
    private final Logger logger = LoggerFactory.getLogger(CouponBiz.class);

    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private StatusLogMapper statusLogMapper;

    @Autowired
    private DictionaryBiz dictionaryBiz;

    /**
     * 逻辑删除优惠券
     *
     * @param id
     * @param updateUser
     * @param updateUserName
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteCoupon(Long id, String updateUser, String updateUserName) {
        // TODO: Describe business logic and implement it
        int result = couponMapper.logicalDeleteByPrimaryKey(id, updateUser, updateUserName);
        return result;
    }

    /**
     * 创建优惠券
     *
     * @param coupon
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createCoupon(Coupon coupon) {

        coupon.setCouponNo(dictionaryBiz.getNumber());
        coupon.setCreateTime(null);
        coupon.setUpdateTime(null);
        coupon.setIsDeleted(false);
        couponMapper.insertSelective(coupon);
        return coupon.getId();
    }

    /**
     * 批量创建
     *
     * @param couponList
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateCoupon(List<Coupon> couponList) {
        // TODO: Describe business logic and implement it
        return couponMapper.insertBatch(couponList);
    }

    /**
     * 更新优惠券
     *
     * @param coupon
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateCoupon(Coupon coupon) {
        Integer result = null;
        Coupon couponLast = couponMapper.selectByPrimaryKeyForUpdate(coupon.getId());
        if (couponLast == null) {
            throw new CommonBizException(MmcResultCode.DATA_NOT_EXIST, "优惠券");
        }
        // TODO: Describe business logic and implement it
        result = couponMapper.updateByPrimaryKeySelective(coupon);
        return result;
    }

    /**
     * 根据ID获取优惠券信息
     *
     * @param id
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public Coupon getCoupon(Long id) {
        Coupon coupon = couponMapper.selectByPrimaryKey(id);
        if (coupon == null || coupon.getIsDeleted()) {
            throw new CommonBizException(MmcResultCode.DATA_NOT_EXIST, "优惠券");
        }
        return coupon;
    }

    /**
     * 分页查询优惠券信息
     *
     * @param couponQuery
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public QueryResultODTO<Coupon> queryCoupon(CouponQueryDTO couponQuery) {
        QueryResultODTO<Coupon> queryResult = new QueryResultODTO<Coupon>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(couponQuery.getPageNo(), couponQuery.getPageSize());
        List<Coupon> couponList = couponMapper.queryCoupon(couponQuery);
        PageInfo<Coupon> pageInfo = new PageInfo<Coupon>(couponList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(couponList);
        return queryResult;
    }


    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer changeStatus(Coupon coupon) {
        Coupon couponLast = couponMapper.selectByPrimaryKeyForUpdate(coupon.getId());
        if (couponLast == null) {
            throw new CommonBizException(MmcResultCode.DATA_NOT_EXIST, "优惠券");
        }
        if (CommonStatusEnum.ONLINE.equal(coupon.getCouponStatus())) {
            // 上线
            if (!CommonStatusEnum.SAVED.equal(couponLast.getCouponStatus())) {
                throw new CommonBizException(MmcResultCode.INVALID_CHANGE_STATUS, "优惠券");
            }
        } else if (CommonStatusEnum.SAVED.equal(coupon.getCouponStatus())) {
            // 下线
            if (!CommonStatusEnum.ONLINE.equal(couponLast.getCouponStatus())) {
                throw new CommonBizException(MmcResultCode.INVALID_CHANGE_STATUS, "优惠券");
            }
        } else if (CommonStatusEnum.STOPED.equal(coupon.getCouponStatus())) {
            // 中止
            if (!CommonStatusEnum.ONLINE.equal(couponLast.getCouponStatus())
                    && !CommonStatusEnum.ONGOING.equal(couponLast.getCouponStatus())) {
                throw new CommonBizException(MmcResultCode.INVALID_CHANGE_STATUS, "优惠券");
            }
        } else if (CommonStatusEnum.CANCELED.equal(coupon.getCouponStatus())) {
            // 取消
            if (!CommonStatusEnum.ONLINE.equal(couponLast.getCouponStatus())
                    && !CommonStatusEnum.ONGOING.equal(couponLast.getCouponStatus())
                    && !CommonStatusEnum.STOPED.equal(couponLast.getCouponStatus())) {
                throw new CommonBizException(MmcResultCode.INVALID_CHANGE_STATUS, "优惠券");
            }
        }
        Integer result = couponMapper.updateByPrimaryKeySelective(coupon);

        if (result > 0) {
            // 添加状态变更记录
            StatusLog statusLog = new StatusLog();
            statusLog.setType(PromotionTypeEnum.COUPON.getValue());
            statusLog.setEntityId(coupon.getId());
            statusLog.setOldStatus(couponLast.getCouponStatus());
            statusLog.setNewStatus(coupon.getCouponStatus());
            statusLog.setOperationUser(coupon.getUpdateUser());
            statusLog.setOperationUserName(coupon.getUpdateUserName());
            statusLogMapper.insertSelective(statusLog);
        }

        return result;
    }


}