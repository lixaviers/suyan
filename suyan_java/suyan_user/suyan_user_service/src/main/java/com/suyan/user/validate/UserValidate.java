package com.suyan.user.validate;

import com.suyan.user.model.User;
import com.suyan.user.result.UserResult;

import static com.suyan.user.util.ValidationUtil.isEmptyOrMoreThan;
import static com.suyan.user.util.ValidationUtil.isNull;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <service层用户验证类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-18>
 * @Modify Date: <2018-09-18>
 * @Version: <1.0>
 */
public class UserValidate {

    public static boolean validateForCreate(User user, UserResult<?> message) {
        if (isEmptyOrMoreThan(message, User.USER_NAME, user.getUserName(), 16)) {
            return false;
        }

        if (isNull(message, User.IS_ADMIN, user.getIsAdmin())) {
            return false;
        }
        /*if (isEmptyOrMoreThan(message, User.MOBILE, user.getMobile(), 16)) {
            return false;
        }
        if (isEmptyOrMoreThan(message, User.MAIL, user.getMail(), 200)) {
            return false;
        }*/
        return true;
    }

    public static boolean validateForUpdate(User user, UserResult<?> message) {
        if (isNull(message, User.ID, user.getId())) {
            return false;
        }
        return validateForCreate(user, message);
    }
}