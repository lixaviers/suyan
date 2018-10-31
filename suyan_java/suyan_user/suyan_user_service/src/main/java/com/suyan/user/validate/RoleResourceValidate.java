package com.suyan.user.validate;

import com.suyan.user.model.RoleResource;
import com.suyan.user.result.UserResult;

import static com.suyan.user.util.ValidationUtil.isEmptyOrMoreThan;
import static com.suyan.user.util.ValidationUtil.isNull;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <service层角色资源验证类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public class RoleResourceValidate {

    public static boolean validateForCreate(RoleResource roleResource, UserResult<?> message) {

        if (isNull(message,RoleResource.ROLE_ID, roleResource.getRoleId())) {
            return false;
        }

        if (isNull(message,RoleResource.RESOURCE_ID, roleResource.getResourceId())) {
            return false;
        }

        if (isNull(message,RoleResource.COMMON_STATUS, roleResource.getCommonStatus())) {
            return false;
        }
        if (isEmptyOrMoreThan(message, RoleResource.CREATE_USER, roleResource.getCreateUser(), 16)) {
            return false;
        }
        if (isEmptyOrMoreThan(message, RoleResource.UPDATE_USER, roleResource.getUpdateUser(), 16)) {
            return false;
        }
        return true;
    }
    
    public static boolean validateForUpdate(RoleResource roleResource, UserResult<?> message) {
        if (isNull(message,RoleResource.ID, roleResource.getId())) {
            return false;
        }
        return validateForCreate(roleResource, message);
    }
}