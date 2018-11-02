package com.suyan.mmc.convertor;

import com.suyan.mmc.model.UserCoupon;
import com.suyan.mmc.req.UserCouponDTO;
import com.suyan.mmc.resp.UserCouponODTO;
import com.suyan.common.resp.QueryResultODTO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <mmc>
 * @Comments: <Dubbo层用户优惠券转换类 Dubbo层的Info对象与dal层的model对象相互转换>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-10-18>
 * @Modify Date: <2018-10-18>
 * @Version: <1.0>
 */
public abstract class UserCouponConvertor {

    private static final BeanCopier beanCopierForUserCouponODTO = BeanCopier.create(UserCoupon.class, UserCouponODTO.class, false);
    private static final BeanCopier beanCopierForUserCoupon = BeanCopier.create(UserCouponDTO.class, UserCoupon.class, false);

    public static UserCouponODTO toUserCouponODTO(UserCoupon userCoupon) {
        if (userCoupon == null) {
            return null;
        }
        UserCouponODTO userCouponODTO = new UserCouponODTO();
        beanCopierForUserCouponODTO.copy(userCoupon, userCouponODTO, null);
        return userCouponODTO;
    }

    public static UserCoupon toUserCoupon(UserCouponDTO userCouponDTO) {
        UserCoupon userCoupon = new UserCoupon();
        beanCopierForUserCoupon.copy(userCouponDTO, userCoupon, null);
        return userCoupon;
    }

    public static List<UserCouponODTO> toUserCouponODTOList(List<UserCoupon> userCouponList) {
        if (userCouponList == null || userCouponList.isEmpty()) {
            return null;
        }
        List<UserCouponODTO> userCouponInfoList = new ArrayList<UserCouponODTO>(userCouponList.size());
        for (UserCoupon userCoupon : userCouponList) {
            userCouponInfoList.add(toUserCouponODTO(userCoupon));
        }
        return userCouponInfoList;
    }

    public static List<UserCoupon> toUserCouponList(List<UserCouponDTO> userCouponDTOList) {
        if (userCouponDTOList == null || userCouponDTOList.isEmpty()) {
            return null;
        }
        List<UserCoupon> userCouponList = new ArrayList<UserCoupon>(userCouponDTOList.size());
        for (UserCouponDTO userCouponDTO : userCouponDTOList) {
            userCouponList.add(toUserCoupon(userCouponDTO));
        }
        return userCouponList;
    }

    public static QueryResultODTO<UserCouponODTO> toQueryResult(QueryResultODTO<UserCoupon> queryResult) {
        QueryResultODTO<UserCouponODTO> queryResultInfo = new QueryResultODTO<UserCouponODTO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toUserCouponODTOList(queryResult.getRecords()));
        return queryResultInfo;
        }
}