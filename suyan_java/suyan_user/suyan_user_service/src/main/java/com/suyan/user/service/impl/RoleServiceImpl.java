package com.suyan.user.service.impl;

import com.suyan.user.biz.RoleBiz;
import com.suyan.user.biz.convertor.RoleConvertor;
import com.suyan.user.model.Role;
import com.suyan.user.req.RoleDTO;
import com.suyan.user.req.RoleQueryDTO;
import com.suyan.user.resp.RoleODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;
import com.suyan.user.service.IRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.suyan.user.validate.RoleValidate.validateForCreate;
import static com.suyan.user.validate.RoleValidate.validateForUpdate;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <Dubbo Service 角色管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService {
    private final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleBiz roleBiz;

    /**
     * 删除角色
     *
     * @param id
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<Integer> deleteRole(Integer id) {
        UserResult<Integer> result = UserResult.newSuccess();
        result.setDataMap(roleBiz.deleteRole(id));
        return result;
    }

    /**
     * 创建角色
     *
     * @param roleDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<Integer> createRole(RoleDTO roleDTO) {
        UserResult<Integer> result = UserResult.newSuccess();
        Role role = RoleConvertor.toRole(roleDTO);
        if (!validateForCreate(role, result)) {
            return result;
        }
        result.setDataMap(roleBiz.createRole(role));
        return result;
    }

    @Override
    public UserResult<Integer> batchCreate(List<RoleDTO> roleDTOs) {
        UserResult<Integer> result = UserResult.newSuccess();
        List<Role> items = RoleConvertor.toRoleList(roleDTOs);
        result.setDataMap(roleBiz.batchCreateRole(items));
        return result;
    }

    /**
     * 更新角色
     *
     * @param roleDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<Integer> updateRole(RoleDTO roleDTO) {
        UserResult<Integer> result = UserResult.newSuccess();
        Role role = null;
        role = RoleConvertor.toRole(roleDTO);
        if (!validateForUpdate(role, result)) {
            return result;
        }
        result.setDataMap(roleBiz.updateRole(role));
        return result;
    }

    /**
     * 根据ID获取角色信息
     *
     * @param id
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<RoleODTO> getRole(Integer id) {
        UserResult<RoleODTO> result = UserResult.newSuccess();
        Role role = roleBiz.getRole(id);
        RoleODTO roleODTO = RoleConvertor.toRoleODTO(role);
        result.setDataMap(roleODTO);
        return result;
    }

    /**
     * 分页查询角色信息
     *
     * @param roleQueryDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<QueryResultODTO<RoleODTO>> queryRole(RoleQueryDTO roleQueryDTO) {
        UserResult<QueryResultODTO<RoleODTO>> result = UserResult.newSuccess();

        QueryResultODTO<Role> resultInfo = roleBiz.queryRole(roleQueryDTO);
        result.setDataMap(RoleConvertor.toQueryResult(resultInfo));

        return result;
    }

    @Override
    public UserResult<List<RoleODTO>> getRolesByUserOpenId(String userOpenId) {
        UserResult<List<RoleODTO>> result = UserResult.newSuccess();
        result.setDataMap(RoleConvertor.toRoleODTOList(roleBiz.getRolesByUserOpenId(userOpenId)));
        return result;
    }


}