package com.suyan.user.validate;

import com.suyan.user.model.UserRole;
import com.suyan.user.result.UserResult;

import static com.suyan.user.util.ValidationUtil.isEmptyOrMoreThan;
import static com.suyan.user.util.ValidationUtil.isNull;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <service层用户角色验证类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public class UserRoleValidate {

    public static boolean validateForCreate(UserRole userRole, UserResult<?> message) {
        if (isEmptyOrMoreThan(message, UserRole.USER_OPEN_ID, userRole.getUserOpenId(), 16)) {
            return false;
        }

        if (isNull(message,UserRole.ROLE_ID, userRole.getRoleId())) {
            return false;
        }

        if (isNull(message,UserRole.COMMON_STATUS, userRole.getCommonStatus())) {
            return false;
        }
        if (isEmptyOrMoreThan(message, UserRole.CREATE_USER, userRole.getCreateUser(), 16)) {
            return false;
        }
        if (isEmptyOrMoreThan(message, UserRole.UPDATE_USER, userRole.getUpdateUser(), 16)) {
            return false;
        }
        return true;
    }
    
    public static boolean validateForUpdate(UserRole userRole, UserResult<?> message) {
        if (isNull(message,UserRole.ID, userRole.getId())) {
            return false;
        }
        return validateForCreate(userRole, message);
    }
}