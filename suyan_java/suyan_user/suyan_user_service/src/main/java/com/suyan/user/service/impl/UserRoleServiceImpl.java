package com.suyan.user.service.impl;

import com.suyan.user.biz.UserRoleBiz;
import com.suyan.user.biz.convertor.UserRoleConvertor;
import com.suyan.user.model.UserRole;
import com.suyan.user.req.UserRoleDTO;
import com.suyan.user.req.UserRoleQueryDTO;
import com.suyan.user.resp.UserRoleODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;
import com.suyan.user.service.IUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.suyan.user.validate.UserRoleValidate.validateForCreate;
import static com.suyan.user.validate.UserRoleValidate.validateForUpdate;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <Dubbo Service 用户角色管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements IUserRoleService {
    private final Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);

    @Autowired
    private UserRoleBiz userRoleBiz;

    /**
     * 
     * 删除用户角色
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param id
     * @return
     */
    @Override
    public UserResult<Integer> deleteUserRole(Long id ){
        UserResult<Integer> result = UserResult.newSuccess();
        result.setDataMap(userRoleBiz.deleteUserRole(id ));
        return result;
    }
    
    /**
     * 
     * 创建用户角色
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param userRoleDTO
     * @return
     */
    @Override
    public UserResult<Long> createUserRole(UserRoleDTO userRoleDTO){
        UserResult<Long> result = UserResult.newSuccess();
        UserRole userRole = UserRoleConvertor.toUserRole(userRoleDTO);
        if (!validateForCreate(userRole, result)) {
            return result;
        }
        result.setDataMap(userRoleBiz.createUserRole( userRole ));
        return  result;
    }

    @Override
    public UserResult<Integer> batchCreate(List<UserRoleDTO> userRoleDTOs ) {
            UserResult<Integer> result = UserResult.newSuccess();
        List<UserRole> items = UserRoleConvertor.toUserRoleList(userRoleDTOs);
        result.setDataMap(userRoleBiz.batchCreateUserRole(items));
        return result;
    }

    /**
     * 
     * 更新用户角色
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param userRoleDTO
     * @return
     */
    @Override
    public UserResult<Integer> updateUserRole(UserRoleDTO userRoleDTO){
        UserResult<Integer> result = UserResult.newSuccess();
        UserRole userRole = null;
        userRole = UserRoleConvertor.toUserRole(userRoleDTO);
        if (!validateForUpdate(userRole, result)) {
            return result;
        }
        result.setDataMap(userRoleBiz.updateUserRole( userRole ));
        return result;
    }
    
    /**
     * 
     * 根据ID获取用户角色信息
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param id
     * @return
     */
    @Override
    public UserResult<UserRoleODTO> getUserRole( Long id ){
        UserResult<UserRoleODTO> result  = UserResult.newSuccess();
        UserRole userRole = userRoleBiz.getUserRole( id );
        UserRoleODTO userRoleODTO = UserRoleConvertor.toUserRoleODTO(userRole);
        result.setDataMap(userRoleODTO);
        return result;
    }

    /**
     * 
     * 分页查询用户角色信息
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param userRoleQueryDTO
     * @return
     */
    @Override
    public UserResult<QueryResultODTO<UserRoleODTO>> queryUserRole(UserRoleQueryDTO userRoleQueryDTO) {
        UserResult<QueryResultODTO<UserRoleODTO>> result = UserResult.newSuccess();

        QueryResultODTO<UserRole> resultInfo = userRoleBiz.queryUserRole(userRoleQueryDTO);
        result.setDataMap(UserRoleConvertor.toQueryResult(resultInfo));

        return result;
    }
}