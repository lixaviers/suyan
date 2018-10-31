package com.suyan.user.validate;

import com.suyan.user.constant.RoleStatusEnum;
import com.suyan.user.model.Role;
import com.suyan.user.result.UserResult;
import com.suyan.user.result.UserResultCode;

import static com.suyan.user.util.ValidationUtil.isEmptyOrMoreThan;
import static com.suyan.user.util.ValidationUtil.isNull;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <service层角色验证类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public class RoleValidate {

    public static boolean validateForCreate(Role role, UserResult<?> message) {
        if (isEmptyOrMoreThan(message, Role.ROLE_NAME, role.getRoleName(), 64)) {
            return false;
        }
        if (isEmptyOrMoreThan(message, Role.ROLE_CODE, role.getRoleCode(), 64)) {
            return false;
        }

        if (!RoleStatusEnum.exists(role.getRoleStatus())) {
            message.setErrorCode(UserResultCode.COMMON_PARAM_INVALID, Role.ROLE_STATUS);
            return false;
        }
        return true;
    }
    
    public static boolean validateForUpdate(Role role, UserResult<?> message) {
        if (isNull(message,Role.ID, role.getId())) {
            return false;
        }
        return validateForCreate(role, message);
    }
}