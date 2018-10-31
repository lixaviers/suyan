package com.suyan.user.service;

import com.suyan.user.req.UserRoleDTO;
import com.suyan.user.req.UserRoleQueryDTO;
import com.suyan.user.resp.UserRoleODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;

import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <对外API 用户角色管理接口>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public interface IUserRoleService {

    /**
     * 
     * 删除用户角色
     * 
     * @author lixavier
     * @version 1.0.0
    * @param id
     * @return
     */
    UserResult<Integer> deleteUserRole(Long id);
    
    /**
     * 
     * 创建用户角色
     * 
     * @author lixavier
     * @version 1.0.0
     * @param userRoleDTO
     * @return
     */
    UserResult<Long> createUserRole(UserRoleDTO userRoleDTO);

    /**
     *
     * 批量创建用户角色
     *
     * @author lixavier
     * @version 1.0.0
     * @param userRoleDTOs
     * @return
     */
    UserResult<Integer> batchCreate(List<UserRoleDTO> userRoleDTOs);

    /**
     * 
     * 更新用户角色
     * 
     * @author lixavier
     * @version 1.0.0
     * @param userRoleDTO
     * @return
     */
    UserResult<Integer> updateUserRole(UserRoleDTO userRoleDTO);
    
    /**
     * 
     * 根据ID获取用户角色信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @return
     */
    UserResult<UserRoleODTO> getUserRole(Long id);

    /**
     * 
     * 分页查询用户角色信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param userRoleQueryDTO
     * @return
     */
    UserResult<QueryResultODTO<UserRoleODTO>> queryUserRole(UserRoleQueryDTO userRoleQueryDTO);

    /**
    * The following custom service interface about dubbo
    */
}