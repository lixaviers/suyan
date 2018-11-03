package com.suyan.goods.biz;

import com.suyan.common.exception.CommonBizException;
import com.suyan.common.result.ResultCode;
import com.suyan.goods.dao.BrandMapper;
import com.suyan.goods.dao.ext.BrandExtMapper;
import com.suyan.goods.model.Brand;
import com.suyan.goods.req.BrandQueryDTO;
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
 * @Comments: <业务层品牌管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-02>
 * @Modify Date: <2018-11-02>
 * @Version: <1.0>
 */
@Service("brandBiz")
public class BrandBiz {
    private final Logger logger = LoggerFactory.getLogger(BrandBiz.class);

    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private BrandExtMapper brandExtMapper;

    /**
     * 逻辑删除品牌
     *
     * @param id
     * @param updateUser
     * @param updateUserName
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteBrand(Long id, String updateUser, String updateUserName) {
        // TODO: Describe business logic and implement it
        int result = brandMapper.logicalDeleteByPrimaryKey(id, updateUser, updateUserName);
        return result;
    }

    /**
     * 创建品牌
     *
     * @param brand
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createBrand(Brand brand) {
        // TODO: Describe business logic and implement it
        brandMapper.insertSelective(brand);
        return brand.getId();
    }

    /**
     * 批量创建
     *
     * @param brandList
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateBrand(List<Brand> brandList) {
        // TODO: Describe business logic and implement it
        return brandMapper.insertBatch(brandList);
    }

    /**
     * 更新品牌
     *
     * @param brand
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateBrand(Brand brand) {
        Integer result = null;
        Brand brandLast = brandMapper.selectByPrimaryKeyForUpdate(brand.getId());
        if (brandLast == null) {
            // TODO：这里请写清楚
        }
        // TODO: Describe business logic and implement it
        result = brandMapper.updateByPrimaryKeySelective(brand);
        return result;
    }

    /**
     * 根据ID获取品牌信息
     *
     * @param id
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public Brand getBrand(Long id) {
        Brand brand = brandExtMapper.getBrandById(id);
        if (brand == null) {
            throw new CommonBizException(ResultCode.DATA_NOT_EXIST, "品牌");
        }
        return brand;
    }

    /**
     * 分页查询品牌信息
     *
     * @param brandQuery
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public QueryResultODTO<Brand> queryBrand(BrandQueryDTO brandQuery) {
        QueryResultODTO<Brand> queryResult = new QueryResultODTO<Brand>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(brandQuery.getPageNo(), brandQuery.getPageSize());
        List<Brand> brandList = brandMapper.queryBrand(brandQuery);
        PageInfo<Brand> pageInfo = new PageInfo<Brand>(brandList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(brandList);
        return queryResult;
    }

}