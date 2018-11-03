package com.suyan.goods.validate;

import com.suyan.goods.model.Brand;
import com.suyan.common.result.Result;

import static com.suyan.common.util.ValidationUtil.*;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <goods>
 * @Comments: <service层品牌验证类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-11-02>
 * @Modify Date: <2018-11-02>
 * @Version: <1.0>
 */
public class BrandValidate {

    public static boolean validateForCreate(Brand brand, Result<?> message) {

        if (isMoreThan(message, Brand.NAME, brand.getName(), 255)) {
            return false;
        }

        if (isMoreThan(message, Brand.NAME_EN, brand.getNameEn(), 255)) {
            return false;
        }

        if (isMoreThan(message, Brand.LOGO, brand.getLogo(), 255)) {
            return false;
        }

        if (isMoreThan(message, Brand.DESCRIPTION, brand.getDescription(), 500)) {
            return false;
        }

        if (isMoreThan(message, Brand.CREATE_USER, brand.getCreateUser(), 16)) {
            return false;
        }

        if (isMoreThan(message, Brand.CREATE_USER_NAME, brand.getCreateUserName(), 64)) {
            return false;
        }

        if (isMoreThan(message, Brand.UPDATE_USER, brand.getUpdateUser(), 16)) {
            return false;
        }

        if (isMoreThan(message, Brand.UPDATE_USER_NAME, brand.getUpdateUserName(), 64)) {
            return false;
        }
        return true;
    }

    public static boolean validateForUpdate(Brand brand, Result<?> message) {
        if (isNull(message, Brand.ID, brand.getId())) {
            return false;
        }
        return validateForCreate(brand, message);
    }
}