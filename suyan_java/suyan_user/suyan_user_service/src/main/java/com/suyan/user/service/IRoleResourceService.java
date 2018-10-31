package com.suyan.user.service;

import com.suyan.user.req.RoleResourceDTO;
import com.suyan.user.req.RoleResourceQueryDTO;
import com.suyan.user.resp.RoleResourceODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;

import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <对外API 角色资源管理接口>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public interface IRoleResourceService {

    /**
     * 
     * 删除角色资源
     * 
     * @author lixavier
     * @version 1.0.0
    * @param id
     * @return
     */
    UserResult<Integer> deleteRoleResource(Long id);
    
    /**
     * 
     * 创建角色资源
     * 
     * @author lixavier
     * @version 1.0.0
     * @param roleResourceDTO
     * @return
     */
    UserResult<Long> createRoleResource(RoleResourceDTO roleResourceDTO);

    /**
     *
     * 批量创建角色资源
     *
     * @author lixavier
     * @version 1.0.0
     * @param roleResourceDTOs
     * @return
     */
    UserResult<Integer> batchCreate(List<RoleResourceDTO> roleResourceDTOs);

    /**
     * 
     * 更新角色资源
     * 
     * @author lixavier
     * @version 1.0.0
     * @param roleResourceDTO
     * @return
     */
    UserResult<Integer> updateRoleResource(RoleResourceDTO roleResourceDTO);
    
    /**
     * 
     * 根据ID获取角色资源信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @return
     */
    UserResult<RoleResourceODTO> getRoleResource(Long id);

    /**
     * 
     * 分页查询角色资源信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param roleResourceQueryDTO
     * @return
     */
    UserResult<QueryResultODTO<RoleResourceODTO>> queryRoleResource(RoleResourceQueryDTO roleResourceQueryDTO);

    /**
    * The following custom service interface about dubbo
    */
}