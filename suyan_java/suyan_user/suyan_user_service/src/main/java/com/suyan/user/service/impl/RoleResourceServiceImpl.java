package com.suyan.user.service.impl;

import com.suyan.user.biz.RoleResourceBiz;
import com.suyan.user.biz.convertor.RoleResourceConvertor;
import com.suyan.user.model.RoleResource;
import com.suyan.user.req.RoleResourceDTO;
import com.suyan.user.req.RoleResourceQueryDTO;
import com.suyan.user.resp.RoleResourceODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;
import com.suyan.user.service.IRoleResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.suyan.user.validate.RoleResourceValidate.validateForCreate;
import static com.suyan.user.validate.RoleResourceValidate.validateForUpdate;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <Dubbo Service 角色资源管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
@Service("roleResourceService")
public class RoleResourceServiceImpl implements IRoleResourceService {
    private final Logger logger = LoggerFactory.getLogger(RoleResourceServiceImpl.class);

    @Autowired
    private RoleResourceBiz roleResourceBiz;

    /**
     * 删除角色资源
     *
     * @param id
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<Integer> deleteRoleResource(Long id) {
        UserResult<Integer> result = UserResult.newSuccess();
        result.setDataMap(roleResourceBiz.deleteRoleResource(id));
        return result;
    }

    /**
     * 创建角色资源
     *
     * @param roleResourceDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<Long> createRoleResource(RoleResourceDTO roleResourceDTO) {
        UserResult<Long> result = UserResult.newSuccess();
        RoleResource roleResource = RoleResourceConvertor.toRoleResource(roleResourceDTO);
        if (!validateForCreate(roleResource, result)) {
            return result;
        }
        result.setDataMap(roleResourceBiz.createRoleResource(roleResource));
        return result;
    }

    @Override
    public UserResult<Integer> batchCreate(List<RoleResourceDTO> roleResourceDTOs) {
        UserResult<Integer> result = UserResult.newSuccess();
        List<RoleResource> items = RoleResourceConvertor.toRoleResourceList(roleResourceDTOs);
        result.setDataMap(roleResourceBiz.batchCreateRoleResource(items));
        return result;
    }

    /**
     * 更新角色资源
     *
     * @param roleResourceDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<Integer> updateRoleResource(RoleResourceDTO roleResourceDTO) {
        UserResult<Integer> result = UserResult.newSuccess();
        RoleResource roleResource = null;
        roleResource = RoleResourceConvertor.toRoleResource(roleResourceDTO);
        if (!validateForUpdate(roleResource, result)) {
            return result;
        }
        result.setDataMap(roleResourceBiz.updateRoleResource(roleResource));
        return result;
    }

    /**
     * 根据ID获取角色资源信息
     *
     * @param id
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<RoleResourceODTO> getRoleResource(Long id) {
        UserResult<RoleResourceODTO> result = UserResult.newSuccess();
        RoleResource roleResource = roleResourceBiz.getRoleResource(id);
        RoleResourceODTO roleResourceODTO = RoleResourceConvertor.toRoleResourceODTO(roleResource);
        result.setDataMap(roleResourceODTO);
        return result;
    }

    /**
     * 分页查询角色资源信息
     *
     * @param roleResourceQueryDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<QueryResultODTO<RoleResourceODTO>> queryRoleResource(RoleResourceQueryDTO roleResourceQueryDTO) {
        UserResult<QueryResultODTO<RoleResourceODTO>> result = UserResult.newSuccess();

        QueryResultODTO<RoleResource> resultInfo = roleResourceBiz.queryRoleResource(roleResourceQueryDTO);
        result.setDataMap(RoleResourceConvertor.toQueryResult(resultInfo));

        return result;
    }
}