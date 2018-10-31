package com.suyan.user.validate;

import com.suyan.user.model.OptLog;
import com.suyan.user.result.UserResult;

import static com.suyan.user.util.ValidationUtil.*;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <service层操作日志验证类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-18>
 * @Modify Date: <2018-09-18>
 * @Version: <1.0>
 */
public class OptLogValidate {

    public static boolean validateForCreate(OptLog optLog, UserResult<?> message) {

        if (isNull(message,OptLog.USER_ID, optLog.getUserId())) {
            return false;
        }

        if (isNull(message,OptLog.OPT_TYPE, optLog.getOptType())) {
            return false;
        }
        if (isEmptyOrMoreThan(message, OptLog.OPT_VALUE, optLog.getOptValue(), 1000)) {
            return false;
        }
        return true;
    }
    
    public static boolean validateForUpdate(OptLog optLog, UserResult<?> message) {
        if (isNull(message,OptLog.ID, optLog.getId())) {
            return false;
        }
        if (isMoreThan(message, OptLog.OPT_VALUE, optLog.getOptValue(), 1000)) {
            return false;
        }    
        return true;
    }
}