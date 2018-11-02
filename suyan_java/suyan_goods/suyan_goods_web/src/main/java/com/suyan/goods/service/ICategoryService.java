package com.suyan.goods.service;

import com.suyan.goods.req.CategoryDTO;
import com.suyan.goods.req.CategoryQueryDTO;
import com.suyan.goods.resp.CategoryCascaderODTO;
import com.suyan.goods.resp.CategoryODTO;
import com.suyan.common.resp.QueryResultODTO;
import com.suyan.common.result.Result;

import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <goods>
 * @Comments: <对外API 类目管理接口>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-02>
 * @Modify Date: <2018-11-02>
 * @Version: <1.0>
 */
public interface ICategoryService {

    /**
     * 
     * 删除类目
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @param updateUser
     * @param updateUserName
     * @return
     */
    Result<Integer> deleteCategory(Long id, String updateUser, String updateUserName);
    
    /**
     * 
     * 创建类目
     * 
     * @author lixavier
     * @version 1.0.0
     * @param categoryDTO
     * @return
     */
    Result<Long> createCategory(CategoryDTO categoryDTO);

    /**
     *
     * 批量创建类目
     *
     * @author lixavier
     * @version 1.0.0
     * @param categoryDTOs
     * @return
     */
    Result<Integer> batchCreate(List<CategoryDTO> categoryDTOs);

    /**
     * 
     * 更新类目
     * 
     * @author lixavier
     * @version 1.0.0
     * @param categoryDTO
     * @return
     */
    Result<Integer> updateCategory(CategoryDTO categoryDTO);
    
    /**
     * 
     * 根据ID获取类目信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @return
     */
    Result<CategoryODTO> getCategory(Long id);

    /**
     * 
     * 分页查询类目信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param categoryQueryDTO
     * @return
     */
    Result<QueryResultODTO<CategoryODTO>> queryCategory(CategoryQueryDTO categoryQueryDTO);

    Result<Boolean> sort(List<CategoryDTO> categoryList);

}