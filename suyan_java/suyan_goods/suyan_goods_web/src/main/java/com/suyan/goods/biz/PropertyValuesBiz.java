package com.suyan.goods.biz;

import com.suyan.goods.dao.PropertyValuesMapper;
import com.suyan.goods.model.PropertyValues;
import com.suyan.goods.req.PropertyValuesQueryDTO;
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
 * @Comments: <业务层属性值管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-12>
 * @Modify Date: <2018-11-12>
 * @Version: <1.0>
 */
@Service("propertyValuesBiz")
public class PropertyValuesBiz {
    private final Logger logger = LoggerFactory.getLogger(PropertyValuesBiz.class);

    @Autowired
    PropertyValuesMapper propertyValuesMapper;

    /**
    *
    * 逻辑删除属性值
    *
    * @author lixavier
    * @version 1.0.0
    * @param id
    * @param updateUser
    * @param updateUserName
    * @return
    */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deletePropertyValues(Long id, String updateUser, String updateUserName){
        // TODO: Describe business logic and implement it
        int result = propertyValuesMapper.logicalDeleteByPrimaryKey(id,updateUser,updateUserName);
        return result;
    }
    
    /**
     * 
     * 创建属性值
     * 
     * @author lixavier
     * @version 1.0.0
     * @param propertyValues
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createPropertyValues(PropertyValues propertyValues){
        // TODO: Describe business logic and implement it
        propertyValuesMapper.insertSelective( propertyValues );
        return propertyValues.getId();
    }

    /**
    *
    * 批量创建
    *
    * @author lixavier
    * @version 1.0.0
    * @param propertyValuesList
    * @return
    */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreatePropertyValues(List<PropertyValues> propertyValuesList){
        // TODO: Describe business logic and implement it
        return propertyValuesMapper.insertBatch( propertyValuesList );
    }

    /**
     * 
     * 更新属性值
     * 
     * @author lixavier
     * @version 1.0.0
     * @param propertyValues
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updatePropertyValues(PropertyValues propertyValues){
        Integer result = null;
        PropertyValues propertyValuesLast = propertyValuesMapper.selectByPrimaryKeyForUpdate( propertyValues.getId() );
        if( propertyValuesLast == null){
            // TODO：这里请写清楚
        }
        // TODO: Describe business logic and implement it
        result = propertyValuesMapper.updateByPrimaryKeySelective( propertyValues );
        return result;    
    }
    
    /**
     * 
     * 根据ID获取属性值信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public PropertyValues getPropertyValues( Long id ){
        // TODO: Describe business logic and implement it
        PropertyValues propertyValues = propertyValuesMapper.selectByPrimaryKey( id );
        return propertyValues;
    }

    /**
     * 
     * 分页查询属性值信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param propertyValuesQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultODTO<PropertyValues> queryPropertyValues(PropertyValuesQueryDTO propertyValuesQuery) {
        QueryResultODTO<PropertyValues> queryResult = new QueryResultODTO<PropertyValues>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(propertyValuesQuery.getPageNo(), propertyValuesQuery.getPageSize());
        List<PropertyValues> propertyValuesList = propertyValuesMapper.queryPropertyValues(propertyValuesQuery);
        PageInfo<PropertyValues> pageInfo = new PageInfo<PropertyValues>(propertyValuesList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(propertyValuesList);
        return queryResult;
    }

}