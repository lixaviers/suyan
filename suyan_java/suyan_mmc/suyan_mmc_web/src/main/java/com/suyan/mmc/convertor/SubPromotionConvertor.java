package com.suyan.mmc.convertor;

import com.suyan.mmc.constant.CommonStatusEnum;
import com.suyan.mmc.constant.CouponTypeEnum;
import com.suyan.mmc.constant.SubPromotionTypeEnum;
import com.suyan.mmc.model.SubPromotion;
import com.suyan.mmc.req.SubPromotionDTO;
import com.suyan.mmc.resp.SubPromotionODTO;
import com.suyan.common.resp.QueryResultODTO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <mmc>
 * @Comments: <Dubbo层订单促销转换类 Dubbo层的Info对象与dal层的model对象相互转换>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-10-18>
 * @Modify Date: <2018-10-18>
 * @Version: <1.0>
 */
public abstract class SubPromotionConvertor {

    private static final BeanCopier beanCopierForSubPromotionODTO = BeanCopier.create(SubPromotion.class, SubPromotionODTO.class, false);
    private static final BeanCopier beanCopierForSubPromotion = BeanCopier.create(SubPromotionDTO.class, SubPromotion.class, false);

    public static SubPromotionODTO toSubPromotionODTO(SubPromotion subPromotion) {
        if (subPromotion == null) {
            return null;
        }
        SubPromotionODTO subPromotionODTO = new SubPromotionODTO();
        beanCopierForSubPromotionODTO.copy(subPromotion, subPromotionODTO, null);
        subPromotionODTO.setPromotionStatusDesc(CommonStatusEnum.getDescByValue(subPromotion.getPromotionStatus()));
        subPromotionODTO.setTypeDesc(SubPromotionTypeEnum.getNameByValue(subPromotion.getTypeId()));
        return subPromotionODTO;
    }

    public static SubPromotion toSubPromotion(SubPromotionDTO subPromotionDTO) {
        SubPromotion subPromotion = new SubPromotion();
        beanCopierForSubPromotion.copy(subPromotionDTO, subPromotion, null);
        return subPromotion;
    }

    public static List<SubPromotionODTO> toSubPromotionODTOList(List<SubPromotion> subPromotionList) {
        if (subPromotionList == null || subPromotionList.isEmpty()) {
            return null;
        }
        List<SubPromotionODTO> subPromotionInfoList = new ArrayList<SubPromotionODTO>(subPromotionList.size());
        for (SubPromotion subPromotion : subPromotionList) {
            subPromotionInfoList.add(toSubPromotionODTO(subPromotion));
        }
        return subPromotionInfoList;
    }

    public static List<SubPromotion> toSubPromotionList(List<SubPromotionDTO> subPromotionDTOList) {
        if (subPromotionDTOList == null || subPromotionDTOList.isEmpty()) {
            return null;
        }
        List<SubPromotion> subPromotionList = new ArrayList<SubPromotion>(subPromotionDTOList.size());
        for (SubPromotionDTO subPromotionDTO : subPromotionDTOList) {
            subPromotionList.add(toSubPromotion(subPromotionDTO));
        }
        return subPromotionList;
    }

    public static QueryResultODTO<SubPromotionODTO> toQueryResult(QueryResultODTO<SubPromotion> queryResult) {
        QueryResultODTO<SubPromotionODTO> queryResultInfo = new QueryResultODTO<SubPromotionODTO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toSubPromotionODTOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}