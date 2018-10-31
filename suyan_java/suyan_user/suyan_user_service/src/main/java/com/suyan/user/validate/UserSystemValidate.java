package com.suyan.user.validate;

import com.suyan.user.model.UserSystem;
import com.suyan.user.result.UserResult;

import static com.suyan.user.util.ValidationUtil.isEmptyOrMoreThan;
import static com.suyan.user.util.ValidationUtil.isNull;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <service层用户系统验证类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public class UserSystemValidate {

    public static boolean validateForCreate(UserSystem userSystem, UserResult<?> message) {
        if (isEmptyOrMoreThan(message, UserSystem.USER_OPEN_ID, userSystem.getUserOpenId(), 16)) {
            return false;
        }

        if (isNull(message, UserSystem.SYSTEM_ID, userSystem.getSystemId())) {
            return false;
        }

        if (isNull(message, UserSystem.COMMON_STATUS, userSystem.getCommonStatus())) {
            return false;
        }
        if (isEmptyOrMoreThan(message, UserSystem.CREATE_USER, userSystem.getCreateUser(), 16)) {
            return false;
        }
        if (isEmptyOrMoreThan(message, UserSystem.UPDATE_USER, userSystem.getUpdateUser(), 16)) {
            return false;
        }
        return true;
    }
    
    public static boolean validateForUpdate(UserSystem userSystem, UserResult<?> message) {
        if (isNull(message, UserSystem.ID, userSystem.getId())) {
            return false;
        }
        return validateForCreate(userSystem, message);
    }
}