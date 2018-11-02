package com.suyan.mmc.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.mmc.dao.UserCouponMapper;
import com.suyan.mmc.model.UserCoupon;
import com.suyan.mmc.req.UserCouponQueryDTO;
import com.suyan.common.resp.QueryResultODTO;
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
 * @Comments: <业务层用户优惠券管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-10-18>
 * @Modify Date: <2018-10-18>
 * @Version: <1.0>
 */
@Service("userCouponBiz")
public class UserCouponBiz {
    private final Logger logger = LoggerFactory.getLogger(UserCouponBiz.class);

    @Autowired
    UserCouponMapper userCouponMapper;

    /**
    *
    * 删除用户优惠券
    *
    * @author lixavier
    * @version 1.0.0
    * @param id
    * @return
    */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteUserCoupon(Long id){
        // TODO: Describe business logic and implement it
        int result = userCouponMapper.deleteByPrimaryKey(id);
        return result;    
    }
    
    /**
     * 
     * 创建用户优惠券
     * 
     * @author lixavier
     * @version 1.0.0
     * @param userCoupon
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createUserCoupon(UserCoupon userCoupon){
        // TODO: Describe business logic and implement it
        userCouponMapper.insertSelective( userCoupon );
        return userCoupon.getId();
    }

    /**
    *
    * 批量创建
    *
    * @author lixavier
    * @version 1.0.0
    * @param userCouponList
    * @return
    */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateUserCoupon(List<UserCoupon> userCouponList){
        // TODO: Describe business logic and implement it
        return userCouponMapper.insertBatch( userCouponList );
    }

    /**
     * 
     * 更新用户优惠券
     * 
     * @author lixavier
     * @version 1.0.0
     * @param userCoupon
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateUserCoupon(UserCoupon userCoupon){
        Integer result = null;
        UserCoupon userCouponLast = userCouponMapper.selectByPrimaryKeyForUpdate( userCoupon.getId() );
        if( userCouponLast == null){
            // TODO：这里请写清楚
        }
        // TODO: Describe business logic and implement it
        result = userCouponMapper.updateByPrimaryKeySelective( userCoupon );
        return result;    
    }
    
    /**
     * 
     * 根据ID获取用户优惠券信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public UserCoupon getUserCoupon( Long id ){
        // TODO: Describe business logic and implement it
        UserCoupon userCoupon = userCouponMapper.selectByPrimaryKey( id );
        return userCoupon;
    }

    /**
     * 
     * 分页查询用户优惠券信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param userCouponQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultODTO<UserCoupon> queryUserCoupon(UserCouponQueryDTO userCouponQuery) {
        QueryResultODTO<UserCoupon> queryResult = new QueryResultODTO<UserCoupon>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(userCouponQuery.getPageNo(), userCouponQuery.getPageSize());
        List<UserCoupon> userCouponList = userCouponMapper.queryUserCoupon(userCouponQuery);
        PageInfo<UserCoupon> pageInfo = new PageInfo<UserCoupon>(userCouponList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(userCouponList);
        return queryResult;
    }

}