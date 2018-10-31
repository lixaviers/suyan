package com.suyan.user.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.user.dao.UserSystemMapper;
import com.suyan.user.model.UserSystem;
import com.suyan.user.req.UserSystemQueryDTO;
import com.suyan.user.resp.base.QueryResultODTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <业务层用户系统管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
@Service("userSystemBiz")
public class UserSystemBiz {
    private final Logger logger = LoggerFactory.getLogger(UserSystemBiz.class);

    @Autowired
    UserSystemMapper userSystemMapper;

    /**
    *
    * 删除用户系统
    *
    * @author lixavier
    * @version 1.0.0
    * @param id
    * @return
    */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteUserSystem(Long id){
        // TODO: Describe business logic and implement it
        int result = userSystemMapper.deleteByPrimaryKey(id);
        return result;    
    }
    
    /**
     * 
     * 创建用户系统
     * 
     * @author lixavier
     * @version 1.0.0
     * @param userSystem
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createUserSystem(UserSystem userSystem){
        // TODO: Describe business logic and implement it
        userSystemMapper.insertSelective( userSystem );
        return userSystem.getId();
    }

    /**
    *
    * 批量创建
    *
    * @author lixavier
    * @version 1.0.0
    * @param userSystemList
    * @return
    */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateUserSystem(List<UserSystem> userSystemList){
        // TODO: Describe business logic and implement it
        return userSystemMapper.insertBatch( userSystemList );
    }

    /**
     * 
     * 更新用户系统
     * 
     * @author lixavier
     * @version 1.0.0
     * @param userSystem
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateUserSystem(UserSystem userSystem){
        Integer result = null;
        UserSystem userSystemLast = userSystemMapper.selectByPrimaryKeyForUpdate( userSystem.getId() );
        if( userSystemLast == null){
            // TODO：这里请写清楚
        }
        // TODO: Describe business logic and implement it
        result = userSystemMapper.updateByPrimaryKeySelective( userSystem );
        return result;    
    }
    
    /**
     * 
     * 根据ID获取用户系统信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public UserSystem getUserSystem(Long id ){
        // TODO: Describe business logic and implement it
        UserSystem userSystem = userSystemMapper.selectByPrimaryKey( id );
        return userSystem;
    }

    /**
     * 
     * 分页查询用户系统信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param userSystemQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultODTO<UserSystem> queryUserSystem(UserSystemQueryDTO userSystemQuery) {
        QueryResultODTO<UserSystem> queryResult = new QueryResultODTO<UserSystem>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(userSystemQuery.getPageNo(), userSystemQuery.getPageSize());
        List<UserSystem> userSystemList = userSystemMapper.queryUserSystem(userSystemQuery);
        PageInfo<UserSystem> pageInfo = new PageInfo<UserSystem>(userSystemList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(userSystemList);
        return queryResult;
    }

}