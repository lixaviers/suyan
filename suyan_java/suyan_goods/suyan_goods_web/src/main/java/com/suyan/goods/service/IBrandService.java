package com.suyan.goods.service;

import com.suyan.goods.req.BrandDTO;
import com.suyan.goods.req.BrandQueryDTO;
import com.suyan.goods.resp.BrandODTO;
import com.suyan.common.resp.QueryResultODTO;
import com.suyan.common.result.Result;

import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <goods>
 * @Comments: <对外API 品牌管理接口>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-02>
 * @Modify Date: <2018-11-02>
 * @Version: <1.0>
 */
public interface IBrandService {

    /**
     * 
     * 删除品牌
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @param updateUser
     * @param updateUserName
     * @return
     */
    Result<Integer> deleteBrand(Long id, String updateUser, String updateUserName);
    
    /**
     * 
     * 创建品牌
     * 
     * @author lixavier
     * @version 1.0.0
     * @param brandDTO
     * @return
     */
    Result<Long> createBrand(BrandDTO brandDTO);

    /**
     *
     * 批量创建品牌
     *
     * @author lixavier
     * @version 1.0.0
     * @param brandDTOs
     * @return
     */
    Result<Integer> batchCreate(List<BrandDTO> brandDTOs);

    /**
     * 
     * 更新品牌
     * 
     * @author lixavier
     * @version 1.0.0
     * @param brandDTO
     * @return
     */
    Result<Integer> updateBrand(BrandDTO brandDTO);
    
    /**
     * 
     * 根据ID获取品牌信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @return
     */
    Result<BrandODTO> getBrand(Long id);

    /**
     * 
     * 分页查询品牌信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param brandQueryDTO
     * @return
     */
    Result<QueryResultODTO<BrandODTO>> queryBrand(BrandQueryDTO brandQueryDTO);

    /**
    * The following custom service interface about dubbo
    */
}