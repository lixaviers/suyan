package com.suyan.goods.service.impl;

import com.suyan.goods.biz.CategoryBiz;
import com.suyan.goods.convertor.CategoryConvertor;
import com.suyan.goods.model.Category;
import com.suyan.goods.req.CategoryDTO;
import com.suyan.goods.req.CategoryQueryDTO;
import com.suyan.goods.resp.CategoryCascaderODTO;
import com.suyan.goods.resp.CategoryODTO;
import com.suyan.common.resp.QueryResultODTO;
import com.suyan.common.result.Result;
import com.suyan.goods.service.ICategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.suyan.goods.validate.CategoryValidate.validateForCreate;
import static com.suyan.goods.validate.CategoryValidate.validateForUpdate;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <goods>
 * @Comments: <Dubbo Service 类目管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-02>
 * @Modify Date: <2018-11-02>
 * @Version: <1.0>
 */
@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {
    private final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryBiz categoryBiz;

    /**
     * 删除类目
     *
     * @param id
     * @param updateUser
     * @param updateUserName
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public Result<Integer> deleteCategory(Long id, String updateUser, String updateUserName) {
        Result<Integer> result = Result.newSuccess();
        result.setDataMap(categoryBiz.deleteCategory(id, updateUser, updateUserName));
        return result;
    }

    /**
     * 创建类目
     *
     * @param categoryDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public Result<Long> createCategory(CategoryDTO categoryDTO) {
        Result<Long> result = Result.newSuccess();
        Category category = CategoryConvertor.toCategory(categoryDTO);
        if (!validateForCreate(category, result)) {
            return result;
        }
        result.setDataMap(categoryBiz.createCategory(category));
        return result;
    }

    @Override
    public Result<Integer> batchCreate(List<CategoryDTO> categoryDTOs) {
        Result<Integer> result = Result.newSuccess();
        List<Category> items = CategoryConvertor.toCategoryList(categoryDTOs);
        result.setDataMap(categoryBiz.batchCreateCategory(items));
        return result;
    }

    /**
     * 更新类目
     *
     * @param categoryDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public Result<Integer> updateCategory(CategoryDTO categoryDTO) {
        Result<Integer> result = Result.newSuccess();
        Category category = null;
        category = CategoryConvertor.toCategory(categoryDTO);
        if (!validateForUpdate(category, result)) {
            return result;
        }
        result.setDataMap(categoryBiz.updateCategory(category));
        return result;
    }

    /**
     * 根据ID获取类目信息
     *
     * @param id
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public Result<CategoryODTO> getCategory(Long id) {
        Result<CategoryODTO> result = Result.newSuccess();
        Category category = categoryBiz.getCategory(id);
        CategoryODTO categoryODTO = CategoryConvertor.toCategoryODTO(category);
        result.setDataMap(categoryODTO);
        return result;
    }

    /**
     * 分页查询类目信息
     *
     * @param categoryQueryDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public Result<QueryResultODTO<CategoryODTO>> queryCategory(CategoryQueryDTO categoryQueryDTO) {
        Result<QueryResultODTO<CategoryODTO>> result = Result.newSuccess();

        QueryResultODTO<Category> resultInfo = categoryBiz.queryCategory(categoryQueryDTO);
        result.setDataMap(CategoryConvertor.toQueryResult(resultInfo));

        return result;
    }

    @Override
    public Result<Boolean> sort(List<CategoryDTO> categoryList) {
        Result<Boolean> result = Result.newSuccess();
        result.setDataMap(categoryBiz.sort(CategoryConvertor.toCategoryList(categoryList)));
        return result;
    }
}