package com.suyan.goods.validate;

import com.suyan.goods.model.PropertyName;
import com.suyan.common.result.Result;

import static com.suyan.common.util.ValidationUtil.*;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <goods>
 * @Comments: <service层属性名验证类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-12>
 * @Modify Date: <2018-11-12>
 * @Version: <1.0>
 */
public class PropertyNameValidate {

    public static boolean validateForCreate(PropertyName propertyName, Result<?> message) {

        if (isMoreThan(message, PropertyName.NAME, propertyName.getName(), 255)) {
            return false;
        }

        if (isMoreThan(message, PropertyName.CREATE_USER, propertyName.getCreateUser(), 16)) {
            return false;
        }

        if (isMoreThan(message, PropertyName.CREATE_USER_NAME, propertyName.getCreateUserName(), 64)) {
            return false;
        }

        if (isMoreThan(message, PropertyName.UPDATE_USER, propertyName.getUpdateUser(), 16)) {
            return false;
        }

        if (isMoreThan(message, PropertyName.UPDATE_USER_NAME, propertyName.getUpdateUserName(), 64)) {
            return false;
        }
        return true;
    }
    
    public static boolean validateForUpdate(PropertyName propertyName, Result<?> message) {
        if (isNull(message,PropertyName.ID, propertyName.getId())) {
            return false;
        }
        return validateForCreate(propertyName, message);
    }
}