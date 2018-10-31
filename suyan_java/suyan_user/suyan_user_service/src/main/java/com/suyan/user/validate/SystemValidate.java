package com.suyan.user.validate;

import com.suyan.user.model.System;
import com.suyan.user.result.UserResult;

import static com.suyan.user.util.ValidationUtil.*;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <service层系统验证类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public class SystemValidate {

    public static boolean validateForCreate(System system, UserResult<?> message) {
        if (isEmptyOrMoreThan(message, System.NAME, system.getName(), 64)) {
            return false;
        }
        if (isEmptyOrMoreThan(message, System.SYS_CODE, system.getSysCode(), 32)) {
            return false;
        }

        if (isMoreThan(message, System.LINK, system.getLink(), 255)) {
            return false;
        }

        if (isMoreThan(message, System.ICON, system.getIcon(), 255)) {
            return false;
        }

        if (isNull(message, System.SYS_STATUS, system.getSysStatus())) {
            return false;
        }

        return true;
    }
    
    public static boolean validateForUpdate(System system, UserResult<?> message) {
        if (isNull(message, System.ID, system.getId())) {
            return false;
        }
        return validateForCreate(system, message);
    }
}