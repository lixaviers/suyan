package com.suyan.goods.biz;

import com.suyan.common.exception.CommonBizException;
import com.suyan.common.result.ResultCode;
import com.suyan.goods.dao.CategoryMapper;
import com.suyan.goods.dao.ext.CategoryExtMapper;
import com.suyan.goods.model.Category;
import com.suyan.goods.model.CategoryExample;
import com.suyan.goods.req.CategoryQueryDTO;
import com.suyan.common.resp.QueryResultODTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * @Project: <goods>
 * @Comments: <业务层类目管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-02>
 * @Modify Date: <2018-11-02>
 * @Version: <1.0>
 */
@Service("categoryBiz")
public class CategoryBiz {
    private final Logger logger = LoggerFactory.getLogger(CategoryBiz.class);

    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    CategoryExtMapper categoryExtMapper;

    /**
     * 逻辑删除类目
     *
     * @param id
     * @param updateUser
     * @param updateUserName
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteCategory(Long id, String updateUser, String updateUserName) {
        // TODO: Describe business logic and implement it
        int result = categoryMapper.logicalDeleteByPrimaryKey(id, updateUser, updateUserName);
        return result;
    }

    /**
     * 创建类目
     *
     * @param category
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createCategory(Category category) {
        category.setIsDeleted(false);
        if (category.getParentId() == null) {
            category.setParentId(0l);
        }
        category.setSortNumber(categoryExtMapper.getMaxSortNumberByParentId(category.getParentId()) + 1);
        category.setSortNumberWeb(categoryExtMapper.getMaxSortNumberWebByParentId(category.getParentId()) + 1);

        if (category.getParentId() != null && !category.getParentId().equals(0l)) {
            Category temp = getCategory(category.getParentId());
            category.setLevelType((byte) (temp.getLevelType() + 1));
        } else {
            category.setLevelType((byte) 1);
        }

        categoryMapper.insertSelective(category);
        return category.getId();
    }

    /**
     * 批量创建
     *
     * @param categoryList
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateCategory(List<Category> categoryList) {
        return categoryMapper.insertBatch(categoryList);
    }

    /**
     * 更新类目
     *
     * @param category
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateCategory(Category category) {
        Category categoryLast = categoryMapper.selectByPrimaryKeyForUpdate(category.getId());
        if (categoryLast == null) {
            throw new CommonBizException(ResultCode.DATA_NOT_EXIST, "类目");
        }
        category.setCreateTime(null);
        category.setCreateUser(null);
        category.setCreateUserName(null);
        category.setIsDeleted(null);
        Integer result = categoryMapper.updateByPrimaryKeySelective(category);
        return result;
    }

    /**
     * 根据ID获取类目信息
     *
     * @param id
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public Category getCategory(Long id) {
        Category category = categoryMapper.selectByPrimaryKey(id);
        if (category == null || category.getIsDeleted()) {
            throw new CommonBizException(ResultCode.DATA_NOT_EXIST, "类目");
        }
        return category;
    }

    /**
     * 分页查询类目信息
     *
     * @param categoryQuery
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public QueryResultODTO<Category> queryCategory(CategoryQueryDTO categoryQuery) {
        QueryResultODTO<Category> queryResult = new QueryResultODTO<Category>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(categoryQuery.getPageNo(), categoryQuery.getPageSize());
        List<Category> categoryList = categoryMapper.queryCategory(categoryQuery);
        PageInfo<Category> pageInfo = new PageInfo<Category>(categoryList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(categoryList);
        return queryResult;
    }


    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public boolean sort(List<Category> categoryList) {
        int index = 1;
        for (Category category : categoryList) {
            Category temp = new Category();
            temp.setId(category.getId());
            temp.setSortNumber(index);
            categoryMapper.updateByPrimaryKeySelective(temp);
            index++;
        }
        return true;
    }

}