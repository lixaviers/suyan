package com.suyan.goods.biz;

import com.suyan.goods.dao.PropertyNameMapper;
import com.suyan.goods.model.PropertyName;
import com.suyan.goods.req.PropertyNameQueryDTO;
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
 * @Comments: <业务层属性名管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-12>
 * @Modify Date: <2018-11-12>
 * @Version: <1.0>
 */
@Service("propertyNameBiz")
public class PropertyNameBiz {
    private final Logger logger = LoggerFactory.getLogger(PropertyNameBiz.class);

    @Autowired
    PropertyNameMapper propertyNameMapper;

    /**
    *
    * 逻辑删除属性名
    *
    * @author lixavier
    * @version 1.0.0
    * @param id
    * @param updateUser
    * @param updateUserName
    * @return
    */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deletePropertyName(Long id, String updateUser, String updateUserName){
        // TODO: Describe business logic and implement it
        int result = propertyNameMapper.logicalDeleteByPrimaryKey(id,updateUser,updateUserName);
        return result;
    }
    
    /**
     * 
     * 创建属性名
     * 
     * @author lixavier
     * @version 1.0.0
     * @param propertyName
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createPropertyName(PropertyName propertyName){
        // TODO: Describe business logic and implement it
        propertyNameMapper.insertSelective( propertyName );
        return propertyName.getId();
    }

    /**
    *
    * 批量创建
    *
    * @author lixavier
    * @version 1.0.0
    * @param propertyNameList
    * @return
    */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreatePropertyName(List<PropertyName> propertyNameList){
        // TODO: Describe business logic and implement it
        return propertyNameMapper.insertBatch( propertyNameList );
    }

    /**
     * 
     * 更新属性名
     * 
     * @author lixavier
     * @version 1.0.0
     * @param propertyName
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updatePropertyName(PropertyName propertyName){
        Integer result = null;
        PropertyName propertyNameLast = propertyNameMapper.selectByPrimaryKeyForUpdate( propertyName.getId() );
        if( propertyNameLast == null){
            // TODO：这里请写清楚
        }
        // TODO: Describe business logic and implement it
        result = propertyNameMapper.updateByPrimaryKeySelective( propertyName );
        return result;    
    }
    
    /**
     * 
     * 根据ID获取属性名信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public PropertyName getPropertyName( Long id ){
        // TODO: Describe business logic and implement it
        PropertyName propertyName = propertyNameMapper.selectByPrimaryKey( id );
        return propertyName;
    }

    /**
     * 
     * 分页查询属性名信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param propertyNameQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultODTO<PropertyName> queryPropertyName(PropertyNameQueryDTO propertyNameQuery) {
        QueryResultODTO<PropertyName> queryResult = new QueryResultODTO<PropertyName>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(propertyNameQuery.getPageNo(), propertyNameQuery.getPageSize());
        List<PropertyName> propertyNameList = propertyNameMapper.queryPropertyName(propertyNameQuery);
        PageInfo<PropertyName> pageInfo = new PageInfo<PropertyName>(propertyNameList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(propertyNameList);
        return queryResult;
    }

}