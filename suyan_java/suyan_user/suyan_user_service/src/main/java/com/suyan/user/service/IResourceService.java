package com.suyan.user.service;

import com.suyan.user.req.ResourceDTO;
import com.suyan.user.req.ResourceQueryDTO;
import com.suyan.user.resp.NavODTO;
import com.suyan.user.resp.ResourceODTO;
import com.suyan.user.resp.UserPermissionsODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;

import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <对外API 资源管理接口>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public interface IResourceService {

    /**
     * 删除资源
     *
     * @param id
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    UserResult<Integer> deleteResource(Long id, String updateUser, String updateUserName);

    /**
     * 创建资源
     *
     * @param resourceDTO
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    UserResult<Long> createResource(ResourceDTO resourceDTO);

    /**
     * 批量创建资源
     *
     * @param resourceDTOs
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    UserResult<Integer> batchCreate(List<ResourceDTO> resourceDTOs);

    /**
     * 更新资源
     *
     * @param resourceDTO
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    UserResult<Integer> updateResource(ResourceDTO resourceDTO);

    /**
     * 根据ID获取资源信息
     *
     * @param id
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    UserResult<ResourceODTO> getResource(Long id);

    /**
     * 分页查询资源信息
     *
     * @param resourceQueryDTO
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    UserResult<QueryResultODTO<ResourceODTO>> queryResource(ResourceQueryDTO resourceQueryDTO);


    /**
     * 根据用户openId获取资源列表
     *
     * @param userOpenId
     * @return
     */
    UserResult<NavODTO> getNav(String userOpenId);

    /**
     * 获取树资源
     *
     * @return
     */
    UserResult<List<ResourceODTO>> getTreeResource(Integer systemId);


    /**
     * 根据角色id获取资源列表
     *
     * @param roleId
     * @return
     */
    UserResult<List<ResourceODTO>> getResourcesByRoleId(Integer roleId);

    UserResult<UserPermissionsODTO> getResourceUrlByUserOpenId(String userOpenId);


}