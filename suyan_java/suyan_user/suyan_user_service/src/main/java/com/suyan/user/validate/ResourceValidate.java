package com.suyan.user.validate;

import com.suyan.user.constant.ResourceTypeEnum;
import com.suyan.user.model.Resource;
import com.suyan.user.result.UserResult;
import com.suyan.user.result.UserResultCode;

import static com.suyan.user.util.ValidationUtil.*;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <service层资源验证类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public class ResourceValidate {

    public static boolean validateForCreate(Resource resource, UserResult<?> message) {
        if (isEmptyOrMoreThan(message, Resource.NAME, resource.getName(), 64)) {
            return false;
        }
        if (isEmptyOrMoreThan(message, Resource.RESOURCE_CODE, resource.getResourceCode(), 64)) {
            return false;
        }

        if (isMoreThan(message, Resource.URL, resource.getUrl(), 255)) {
            return false;
        }

        if (!ResourceTypeEnum.exists(resource.getType())) {
            message.setErrorCode(UserResultCode.COMMON_PARAM_INVALID, Resource.TYPE);
            return false;
        }
        if (resource.getSortNumber() == null) {
            resource.setSortNumber(1);
        }
        return true;
    }
    
    public static boolean validateForUpdate(Resource resource, UserResult<?> message) {
        if (isNull(message,Resource.ID, resource.getId())) {
            return false;
        }
        return validateForCreate(resource, message);
    }
}