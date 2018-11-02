package com.suyan.mmc.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.common.exception.CommonBizException;
import com.suyan.mmc.constant.CommonStatusEnum;
import com.suyan.mmc.constant.PromotionTypeEnum;
import com.suyan.mmc.dao.StatusLogMapper;
import com.suyan.mmc.dao.SubPromotionMapper;
import com.suyan.mmc.model.StatusLog;
import com.suyan.mmc.model.SubPromotion;
import com.suyan.mmc.req.SubPromotionQueryDTO;
import com.suyan.common.resp.QueryResultODTO;
import com.suyan.common.result.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <mmc>
 * @Comments: <业务层订单促销管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-10-18>
 * @Modify Date: <2018-10-18>
 * @Version: <1.0>
 */
@Service("subPromotionBiz")
public class SubPromotionBiz {
    private final Logger logger = LoggerFactory.getLogger(SubPromotionBiz.class);

    @Autowired
    private SubPromotionMapper subPromotionMapper;
    @Autowired
    private StatusLogMapper statusLogMapper;

    /**
     * 逻辑删除订单促销
     *
     * @param id
     * @param updateUser
     * @param updateUserName
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteSubPromotion(Long id, String updateUser, String updateUserName) {
        // TODO: Describe business logic and implement it
        int result = subPromotionMapper.logicalDeleteByPrimaryKey(id, updateUser, updateUserName);
        return result;
    }

    /**
     * 创建订单促销
     *
     * @param subPromotion
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createSubPromotion(SubPromotion subPromotion) {
        subPromotion.setCreateTime(null);
        subPromotion.setUpdateTime(null);
        subPromotion.setIsDeleted(false);
        subPromotionMapper.insertSelective(subPromotion);
        return subPromotion.getId();
    }

    /**
     * 批量创建
     *
     * @param subPromotionList
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateSubPromotion(List<SubPromotion> subPromotionList) {
        // TODO: Describe business logic and implement it
        return subPromotionMapper.insertBatch(subPromotionList);
    }

    /**
     * 更新订单促销
     *
     * @param subPromotion
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateSubPromotion(SubPromotion subPromotion) {
        Integer result = null;
        SubPromotion subPromotionLast = subPromotionMapper.selectByPrimaryKeyForUpdate(subPromotion.getId());
        if (subPromotionLast == null) {
            throw new CommonBizException(ResultCode.DATA_NOT_EXIST, "订单促销");
        }
        // TODO: Describe business logic and implement it
        result = subPromotionMapper.updateByPrimaryKeySelective(subPromotion);
        return result;
    }

    /**
     * 根据ID获取订单促销信息
     *
     * @param id
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public SubPromotion getSubPromotion(Long id) {
        SubPromotion subPromotion = subPromotionMapper.selectByPrimaryKey(id);
        if (subPromotion == null || subPromotion.getIsDeleted()) {
            throw new CommonBizException(ResultCode.DATA_NOT_EXIST, "订单促销");
        }
        return subPromotion;
    }

    /**
     * 分页查询订单促销信息
     *
     * @param subPromotionQuery
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public QueryResultODTO<SubPromotion> querySubPromotion(SubPromotionQueryDTO subPromotionQuery) {
        QueryResultODTO<SubPromotion> queryResult = new QueryResultODTO<SubPromotion>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(subPromotionQuery.getPageNo(), subPromotionQuery.getPageSize());
        List<SubPromotion> subPromotionList = subPromotionMapper.querySubPromotion(subPromotionQuery);
        PageInfo<SubPromotion> pageInfo = new PageInfo<SubPromotion>(subPromotionList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(subPromotionList);
        return queryResult;
    }


    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer changeStatus(SubPromotion subPromotion) {
        SubPromotion subPromotionLast = subPromotionMapper.selectByPrimaryKeyForUpdate(subPromotion.getId());
        if (subPromotionLast == null) {
            throw new CommonBizException(ResultCode.DATA_NOT_EXIST, "订单促销");
        }
        if (CommonStatusEnum.ONLINE.equal(subPromotion.getPromotionStatus())) {
            // 上线
            if (!CommonStatusEnum.SAVED.equal(subPromotionLast.getPromotionStatus())) {
                throw new CommonBizException(ResultCode.INVALID_CHANGE_STATUS, "订单促销");
            }
        } else if (CommonStatusEnum.SAVED.equal(subPromotion.getPromotionStatus())) {
            // 下线
            if (!CommonStatusEnum.ONLINE.equal(subPromotionLast.getPromotionStatus())) {
                throw new CommonBizException(ResultCode.INVALID_CHANGE_STATUS, "订单促销");
            }
        } else if (CommonStatusEnum.STOPED.equal(subPromotion.getPromotionStatus())) {
            // 中止
            if (!CommonStatusEnum.ONLINE.equal(subPromotionLast.getPromotionStatus())
                    && !CommonStatusEnum.ONGOING.equal(subPromotionLast.getPromotionStatus())) {
                throw new CommonBizException(ResultCode.INVALID_CHANGE_STATUS, "订单促销");
            }
        } else if (CommonStatusEnum.CANCELED.equal(subPromotion.getPromotionStatus())) {
            // 取消
            if (!CommonStatusEnum.ONLINE.equal(subPromotionLast.getPromotionStatus())
                    && !CommonStatusEnum.ONGOING.equal(subPromotionLast.getPromotionStatus())
                    && !CommonStatusEnum.STOPED.equal(subPromotionLast.getPromotionStatus())) {
                throw new CommonBizException(ResultCode.INVALID_CHANGE_STATUS, "订单促销");
            }
        }
        Integer result = subPromotionMapper.updateByPrimaryKeySelective(subPromotion);
        if (result > 0) {
            // 添加状态变更记录
            StatusLog statusLog = new StatusLog();
            statusLog.setType(PromotionTypeEnum.SUB_PROMOTION.getValue());
            statusLog.setEntityId(subPromotion.getId());
            statusLog.setOldStatus(subPromotionLast.getPromotionStatus());
            statusLog.setNewStatus(subPromotion.getPromotionStatus());
            statusLog.setOperationUser(subPromotion.getUpdateUser());
            statusLog.setOperationUserName(subPromotion.getUpdateUserName());
            statusLogMapper.insertSelective(statusLog);
        }
        return result;
    }


}