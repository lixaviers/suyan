package com.suyan.goods.validate;

import com.suyan.goods.model.PropertyValues;
import com.suyan.common.result.Result;

import static com.suyan.common.util.ValidationUtil.*;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <goods>
 * @Comments: <service层属性值验证类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-12>
 * @Modify Date: <2018-11-12>
 * @Version: <1.0>
 */
public class PropertyValuesValidate {

    public static boolean validateForCreate(PropertyValues propertyValues, Result<?> message) {

        if (isMoreThan(message, PropertyValues.NAME, propertyValues.getName(), 255)) {
            return false;
        }

        if (isMoreThan(message, PropertyValues.CREATE_USER, propertyValues.getCreateUser(), 16)) {
            return false;
        }

        if (isMoreThan(message, PropertyValues.CREATE_USER_NAME, propertyValues.getCreateUserName(), 64)) {
            return false;
        }

        if (isMoreThan(message, PropertyValues.UPDATE_USER, propertyValues.getUpdateUser(), 16)) {
            return false;
        }

        if (isMoreThan(message, PropertyValues.UPDATE_USER_NAME, propertyValues.getUpdateUserName(), 64)) {
            return false;
        }
        return true;
    }
    
    public static boolean validateForUpdate(PropertyValues propertyValues, Result<?> message) {
        if (isNull(message,PropertyValues.ID, propertyValues.getId())) {
            return false;
        }
        return validateForCreate(propertyValues, message);
    }
}