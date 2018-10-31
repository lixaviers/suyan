package com.suyan.user.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.user.dao.UserRoleMapper;
import com.suyan.user.model.User;
import com.suyan.user.model.UserRole;
import com.suyan.user.model.UserRoleExample;
import com.suyan.user.req.UserRoleQueryDTO;
import com.suyan.user.resp.base.QueryResultODTO;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <业务层用户角色管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
@Service("userRoleBiz")
public class UserRoleBiz {
    private final Logger logger = LoggerFactory.getLogger(UserRoleBiz.class);

    @Autowired
    UserRoleMapper userRoleMapper;

    /**
     * 删除用户角色
     *
     * @param id
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteUserRole(Long id) {
        // TODO: Describe business logic and implement it
        int result = userRoleMapper.deleteByPrimaryKey(id);
        return result;
    }

    /**
     * 创建用户角色
     *
     * @param userRole
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createUserRole(UserRole userRole) {
        // TODO: Describe business logic and implement it
        userRoleMapper.insertSelective(userRole);
        return userRole.getId();
    }

    /**
     * 批量创建
     *
     * @param userRoleList
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateUserRole(List<UserRole> userRoleList) {
        // TODO: Describe business logic and implement it
        return userRoleMapper.insertBatch(userRoleList);
    }

    /**
     * 更新用户角色
     *
     * @param userRole
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateUserRole(UserRole userRole) {
        Integer result = null;
        UserRole userRoleLast = userRoleMapper.selectByPrimaryKeyForUpdate(userRole.getId());
        if (userRoleLast == null) {
            // TODO：这里请写清楚
        }
        // TODO: Describe business logic and implement it
        result = userRoleMapper.updateByPrimaryKeySelective(userRole);
        return result;
    }

    /**
     * 根据ID获取用户角色信息
     *
     * @param id
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public UserRole getUserRole(Long id) {
        // TODO: Describe business logic and implement it
        UserRole userRole = userRoleMapper.selectByPrimaryKey(id);
        return userRole;
    }

    /**
     * 分页查询用户角色信息
     *
     * @param userRoleQuery
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public QueryResultODTO<UserRole> queryUserRole(UserRoleQueryDTO userRoleQuery) {
        QueryResultODTO<UserRole> queryResult = new QueryResultODTO<UserRole>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(userRoleQuery.getPageNo(), userRoleQuery.getPageSize());
        List<UserRole> userRoleList = userRoleMapper.queryUserRole(userRoleQuery);
        PageInfo<UserRole> pageInfo = new PageInfo<UserRole>(userRoleList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(userRoleList);
        return queryResult;
    }

    /**
     * 用户角色授权
     *
     * @param user
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer authorize(User user) {
        // 删除之前的角色
        UserRoleExample example = new UserRoleExample();
        example.createCriteria().andUserOpenIdEqualTo(user.getOpenId());
        userRoleMapper.deleteByExample(example);

        if (CollectionUtils.isNotEmpty(user.getRoleIdList())) {
            List<UserRole> userRoleList = new ArrayList<>();
            for (Integer roleId : user.getRoleIdList()) {
                UserRole bean = new UserRole();
                bean.setRoleId(roleId);
                bean.setUserOpenId(user.getOpenId());
                bean.setCommonStatus((byte) 0);
                bean.setCreateTime(new Date());
                bean.setCreateUser(user.getUpdateUser());
                bean.setCreateUserName(user.getUpdateUserName());
                bean.setUpdateTime(new Date());
                bean.setUpdateUser(user.getUpdateUser());
                bean.setUpdateUserName(user.getUpdateUserName());
                userRoleList.add(bean);
            }
            userRoleMapper.insertBatch(userRoleList);
        }
        return 1;
    }

}