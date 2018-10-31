package com.suyan.user.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.user.dao.RoleMapper;
import com.suyan.user.dao.ext.ResourceExtMapper;
import com.suyan.user.dao.ext.RoleExtMapper;
import com.suyan.user.exception.CommonBizException;
import com.suyan.user.model.Role;
import com.suyan.user.model.RoleExample;
import com.suyan.user.model.RoleResource;
import com.suyan.user.req.RoleQueryDTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResultCode;
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
 * @Comments: <业务层角色管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
@Service("roleBiz")
public class RoleBiz {
    private final Logger logger = LoggerFactory.getLogger(RoleBiz.class);

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleExtMapper roleExtMapper;
    @Autowired
    private ResourceExtMapper resourceExtMapper;

    @Autowired
    private RoleResourceBiz roleResourceBiz;

    /**
     * 删除角色
     *
     * @param id
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteRole(Integer id) {
        // TODO: Describe business logic and implement it
        int result = roleMapper.deleteByPrimaryKey(id);
        return result;
    }

    /**
     * 创建角色
     *
     * @param role
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer createRole(Role role) {
        RoleExample example = new RoleExample();
        example.createCriteria().andIsDeletedEqualTo(false).andRoleCodeEqualTo(role.getRoleCode());
        List<Role> roleList = roleMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(roleList)) {
            throw new CommonBizException(UserResultCode.DATA_EXIST, Role.ROLE_CODE);
        }
        role.setSortNumber(1);
        role.setCreateTime(null);
        role.setUpdateTime(null);
        role.setIsDeleted(false);
        roleMapper.insertSelective(role);

        doAuthorize(role);
        return role.getId();
    }

    /**
     * 批量创建
     *
     * @param roleList
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateRole(List<Role> roleList) {
        // TODO: Describe business logic and implement it
        return roleMapper.insertBatch(roleList);
    }

    /**
     * 更新角色
     *
     * @param role
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateRole(Role role) {
        Integer result = null;
        Role roleLast = roleMapper.selectByPrimaryKeyForUpdate(role.getId());
        if (roleLast == null) {
            throw new CommonBizException(UserResultCode.DATA_NOT_EXIST, "角色");
        }

        RoleExample example = new RoleExample();
        example.createCriteria().andIsDeletedEqualTo(false).andRoleCodeEqualTo(role.getRoleCode());
        List<Role> roleList = roleMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(roleList)) {
            if (!roleList.get(0).getId().equals(role.getId())) {
                throw new CommonBizException(UserResultCode.DATA_EXIST, Role.ROLE_CODE);
            }
        }

        role.setCreateUser(null);
        role.setCreateUserName(null);
        role.setCreateTime(null);
        role.setUpdateTime(null);

        result = roleMapper.updateByPrimaryKeySelective(role);

        doAuthorize(role);
        return result;
    }

    /**
     * 根据ID获取角色信息
     *
     * @param id
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public Role getRole(Integer id) {
        Role role = roleMapper.selectByPrimaryKey(id);
        if (role == null || role.getIsDeleted()) {
            throw new CommonBizException(UserResultCode.DATA_NOT_EXIST, "角色");
        }
        role.setResourceIdList(resourceExtMapper.getResourceIdListByRoleId(id));
        return role;
    }

    /**
     * 分页查询角色信息
     *
     * @param roleQuery
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public QueryResultODTO<Role> queryRole(RoleQueryDTO roleQuery) {
        QueryResultODTO<Role> queryResult = new QueryResultODTO<Role>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(roleQuery.getPageNo(), roleQuery.getPageSize());
        List<Role> roleList = roleMapper.queryRole(roleQuery);
        PageInfo<Role> pageInfo = new PageInfo<Role>(roleList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(roleList);
        return queryResult;
    }


    /**
     * 角色授权
     *
     * @param role
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer doAuthorize(Role role) {
        // delete
        roleResourceBiz.deleteRoleResourcesByRoleId(role.getId());

        if (CollectionUtils.isNotEmpty(role.getResourceIdList())) {
            List<RoleResource> roleResourceList = new ArrayList<>();
            for (Long resourceId : role.getResourceIdList()) {
                if (resourceId > 0) {
                    RoleResource roleResource = new RoleResource();
                    roleResource.setResourceId(resourceId);
                    roleResource.setRoleId(role.getId());
                    roleResource.setCommonStatus((byte) 0);
                    roleResource.setCreateTime(new Date());
                    roleResource.setCreateUser(role.getUpdateUser());
                    roleResource.setCreateUserName(role.getUpdateUserName());
                    roleResource.setUpdateTime(new Date());
                    roleResource.setUpdateUser(role.getUpdateUser());
                    roleResource.setUpdateUserName(role.getUpdateUserName());
                    roleResourceList.add(roleResource);
                }
            }
            roleResourceBiz.batchCreateRoleResource(roleResourceList);
        }
        return 1;
    }

    @Transactional(readOnly = true)
    public List<Role> getRolesByUserOpenId(String userOpenId) {
        return roleExtMapper.getRolesByUserOpenId(userOpenId);
    }

}