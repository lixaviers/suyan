package com.suyan.goods.validate;

import com.suyan.goods.model.Category;
import com.suyan.common.result.Result;

import static com.suyan.common.util.ValidationUtil.*;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <goods>
 * @Comments: <service层类目验证类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-02>
 * @Modify Date: <2018-11-02>
 * @Version: <1.0>
 */
public class CategoryValidate {

    public static boolean validateForCreate(Category category, Result<?> message) {

        if (isMoreThan(message, Category.NAME, category.getName(), 255)) {
            return false;
        }

        if (isMoreThan(message, Category.CREATE_USER, category.getCreateUser(), 16)) {
            return false;
        }

        if (isMoreThan(message, Category.CREATE_USER_NAME, category.getCreateUserName(), 64)) {
            return false;
        }

        if (isMoreThan(message, Category.UPDATE_USER, category.getUpdateUser(), 16)) {
            return false;
        }

        if (isMoreThan(message, Category.UPDATE_USER_NAME, category.getUpdateUserName(), 64)) {
            return false;
        }
        return true;
    }
    
    public static boolean validateForUpdate(Category category, Result<?> message) {
        if (isNull(message,Category.ID, category.getId())) {
            return false;
        }
        return validateForCreate(category, message);
    }
}