package com.suyan.user.convertor;

import com.suyan.user.req.UserRoleDTO;
import com.suyan.user.req.UserRoleQueryDTO;
import com.suyan.user.vo.UserRoleQueryVO;
import com.suyan.user.vo.UserRoleVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <web层用户角色转换类 将Valid的Vo类转换为Dubbo层的Req对象>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public abstract class UserRoleConvertor {

    private static final BeanCopier beanCopierForUserRoleDTO = BeanCopier.create(UserRoleVO.class, UserRoleDTO.class, false);
    private static final BeanCopier beanCopierForUserRoleQueryDTO = BeanCopier.create(UserRoleQueryVO.class, UserRoleQueryDTO.class, false);

    public static UserRoleDTO toUserRoleDTO(UserRoleVO userRoleVO) {
        if (userRoleVO == null) {
            return null;
        }
        UserRoleDTO userRoleDTO = new UserRoleDTO();
        beanCopierForUserRoleDTO.copy(userRoleVO, userRoleDTO, null);
        return userRoleDTO;
    }

    public static List<UserRoleDTO> toUserRoleDTOList(List<UserRoleVO> userRoleVOList) {
        if (userRoleVOList == null || userRoleVOList.isEmpty()) {
            return null;
        }
        List<UserRoleDTO> userRoleDTOList = new ArrayList<UserRoleDTO>(userRoleVOList.size());
        for (UserRoleVO userRoleVO : userRoleVOList) {
            userRoleDTOList.add(toUserRoleDTO(userRoleVO));
        }
        return userRoleDTOList;
    }
    
    public static UserRoleQueryDTO toUserRoleQueryDTO(UserRoleQueryVO userRoleQueryVO) {
        if (userRoleQueryVO== null) {
            return null;
        }
        UserRoleQueryDTO userRoleQueryDTO = new UserRoleQueryDTO();
        beanCopierForUserRoleQueryDTO.copy(userRoleQueryVO, userRoleQueryDTO, null);
        return userRoleQueryDTO;
    }
}