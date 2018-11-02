package com.suyan.mmc.service;

import com.suyan.mmc.req.SubPromotionDTO;
import com.suyan.mmc.req.SubPromotionQueryDTO;
import com.suyan.mmc.resp.SubPromotionODTO;
import com.suyan.common.resp.QueryResultODTO;
import com.suyan.common.result.Result;

import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <mmc>
 * @Comments: <对外API 订单促销管理接口>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-10-18>
 * @Modify Date: <2018-10-18>
 * @Version: <1.0>
 */
public interface ISubPromotionService {

    /**
     * 
     * 删除订单促销
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @param updateUser
     * @param updateUserName
     * @return
     */
    Result<Integer> deleteSubPromotion(Long id, String updateUser, String updateUserName);
    
    /**
     * 
     * 创建订单促销
     * 
     * @author lixavier
     * @version 1.0.0
     * @param subPromotionDTO
     * @return
     */
    Result<Long> createSubPromotion(SubPromotionDTO subPromotionDTO);

    /**
     *
     * 批量创建订单促销
     *
     * @author lixavier
     * @version 1.0.0
     * @param subPromotionDTOs
     * @return
     */
    Result<Integer> batchCreate(List<SubPromotionDTO> subPromotionDTOs);

    /**
     * 
     * 更新订单促销
     * 
     * @author lixavier
     * @version 1.0.0
     * @param subPromotionDTO
     * @return
     */
    Result<Integer> updateSubPromotion(SubPromotionDTO subPromotionDTO);
    
    /**
     * 
     * 根据ID获取订单促销信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @return
     */
    Result<SubPromotionODTO> getSubPromotion(Long id);

    /**
     * 
     * 分页查询订单促销信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param subPromotionQueryDTO
     * @return
     */
    Result<QueryResultODTO<SubPromotionODTO>> querySubPromotion(SubPromotionQueryDTO subPromotionQueryDTO);

    /**
    * The following custom service interface about dubbo
    */


    Result<Integer> changeStatus(SubPromotionDTO subPromotionDTO);



}