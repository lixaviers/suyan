package com.suyan.user.service;

import com.suyan.user.req.RoleDTO;
import com.suyan.user.req.RoleQueryDTO;
import com.suyan.user.resp.RoleODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;

import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <对外API 角色管理接口>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public interface IRoleService {

    /**
     * 
     * 删除角色
     * 
     * @author lixavier
     * @version 1.0.0
    * @param id
     * @return
     */
    UserResult<Integer> deleteRole(Integer id);
    
    /**
     * 
     * 创建角色
     * 
     * @author lixavier
     * @version 1.0.0
     * @param roleDTO
     * @return
     */
    UserResult<Integer> createRole(RoleDTO roleDTO);

    /**
     *
     * 批量创建角色
     *
     * @author lixavier
     * @version 1.0.0
     * @param roleDTOs
     * @return
     */
    UserResult<Integer> batchCreate(List<RoleDTO> roleDTOs);

    /**
     * 
     * 更新角色
     * 
     * @author lixavier
     * @version 1.0.0
     * @param roleDTO
     * @return
     */
    UserResult<Integer> updateRole(RoleDTO roleDTO);
    
    /**
     * 
     * 根据ID获取角色信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @return
     */
    UserResult<RoleODTO> getRole(Integer id);

    /**
     * 
     * 分页查询角色信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param roleQueryDTO
     * @return
     */
    UserResult<QueryResultODTO<RoleODTO>> queryRole(RoleQueryDTO roleQueryDTO);

    /**
    * The following custom service interface about dubbo
    */


    /**
     * 根据用户openId查询角色
     * @param userOpenId
     * @return
     */
    UserResult<List<RoleODTO>> getRolesByUserOpenId(String userOpenId);

}