package com.suyan.user.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.user.dao.RoleResourceMapper;
import com.suyan.user.model.RoleResource;
import com.suyan.user.model.RoleResourceExample;
import com.suyan.user.req.RoleResourceQueryDTO;
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
 * @Comments: <业务层角色资源管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
@Service("roleResourceBiz")
public class RoleResourceBiz {
    private final Logger logger = LoggerFactory.getLogger(RoleResourceBiz.class);

    @Autowired
    RoleResourceMapper roleResourceMapper;

    /**
     * 删除角色资源
     *
     * @param id
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteRoleResource(Long id) {
        int result = roleResourceMapper.deleteByPrimaryKey(id);
        return result;
    }

    /**
     * 删除角色资源
     *
     * @param roleId
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteRoleResourcesByRoleId(Integer roleId) {
        RoleResourceExample example = new RoleResourceExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        return roleResourceMapper.deleteByExample(example);
    }

    /**
     * 创建角色资源
     *
     * @param roleResource
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createRoleResource(RoleResource roleResource) {
        roleResourceMapper.insertSelective(roleResource);
        return roleResource.getId();
    }

    /**
     * 批量创建
     *
     * @param roleResourceList
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateRoleResource(List<RoleResource> roleResourceList) {
        return roleResourceMapper.insertBatch(roleResourceList);
    }

    /**
     * 更新角色资源
     *
     * @param roleResource
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateRoleResource(RoleResource roleResource) {
        Integer result = null;
        RoleResource roleResourceLast = roleResourceMapper.selectByPrimaryKeyForUpdate(roleResource.getId());
        if (roleResourceLast == null) {
            // TODO：这里请写清楚
        }
        // TODO: Describe business logic and implement it
        result = roleResourceMapper.updateByPrimaryKeySelective(roleResource);
        return result;
    }

    /**
     * 根据ID获取角色资源信息
     *
     * @param id
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public RoleResource getRoleResource(Long id) {
        // TODO: Describe business logic and implement it
        RoleResource roleResource = roleResourceMapper.selectByPrimaryKey(id);
        return roleResource;
    }

    /**
     * 分页查询角色资源信息
     *
     * @param roleResourceQuery
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public QueryResultODTO<RoleResource> queryRoleResource(RoleResourceQueryDTO roleResourceQuery) {
        QueryResultODTO<RoleResource> queryResult = new QueryResultODTO<RoleResource>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(roleResourceQuery.getPageNo(), roleResourceQuery.getPageSize());
        List<RoleResource> roleResourceList = roleResourceMapper.queryRoleResource(roleResourceQuery);
        PageInfo<RoleResource> pageInfo = new PageInfo<RoleResource>(roleResourceList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(roleResourceList);
        return queryResult;
    }

}