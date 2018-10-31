package com.suyan.user.convertor;

import com.suyan.user.req.UserDTO;
import com.suyan.user.req.UserQueryDTO;
import com.suyan.user.vo.UserQueryVO;
import com.suyan.user.vo.UserVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <web层用户转换类 将Valid的Vo类转换为Dubbo层的Req对象>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-18>
 * @Modify Date: <2018-09-18>
 * @Version: <1.0>
 */
public abstract class UserConvertor {

    private static final BeanCopier beanCopierForUserDTO = BeanCopier.create(UserVO.class, UserDTO.class, false);
    private static final BeanCopier beanCopierForUserQueryDTO = BeanCopier.create(UserQueryVO.class, UserQueryDTO.class, false);

    public static UserDTO toUserDTO(UserVO userVO) {
        if (userVO == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        beanCopierForUserDTO.copy(userVO, userDTO, null);
        userDTO.setRoleList(RoleConvertor.toRoleDTOList(userVO.getRoleList()));
        return userDTO;
    }

    public static List<UserDTO> toUserDTOList(List<UserVO> userVOList) {
        if (userVOList == null || userVOList.isEmpty()) {
            return null;
        }
        List<UserDTO> userDTOList = new ArrayList<UserDTO>(userVOList.size());
        for (UserVO userVO : userVOList) {
            userDTOList.add(toUserDTO(userVO));
        }
        return userDTOList;
    }
    
    public static UserQueryDTO toUserQueryDTO(UserQueryVO userQueryVO) {
        if (userQueryVO== null) {
            return null;
        }
        UserQueryDTO userQueryDTO = new UserQueryDTO();
        beanCopierForUserQueryDTO.copy(userQueryVO, userQueryDTO, null);
        return userQueryDTO;
    }
}