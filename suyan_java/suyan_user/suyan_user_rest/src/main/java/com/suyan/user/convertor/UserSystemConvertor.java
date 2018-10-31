package com.suyan.user.convertor;

import com.suyan.user.req.UserSystemDTO;
import com.suyan.user.req.UserSystemQueryDTO;
import com.suyan.user.vo.UserSystemQueryVO;
import com.suyan.user.vo.UserSystemVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <web层用户系统转换类 将Valid的Vo类转换为Dubbo层的Req对象>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public abstract class UserSystemConvertor {

    private static final BeanCopier beanCopierForUserSystemDTO = BeanCopier.create(UserSystemVO.class, UserSystemDTO.class, false);
    private static final BeanCopier beanCopierForUserSystemQueryDTO = BeanCopier.create(UserSystemQueryVO.class, UserSystemQueryDTO.class, false);

    public static UserSystemDTO toUserSystemDTO(UserSystemVO userSystemVO) {
        if (userSystemVO == null) {
            return null;
        }
        UserSystemDTO userSystemDTO = new UserSystemDTO();
        beanCopierForUserSystemDTO.copy(userSystemVO, userSystemDTO, null);
        return userSystemDTO;
    }

    public static List<UserSystemDTO> toUserSystemDTOList(List<UserSystemVO> userSystemVOList) {
        if (userSystemVOList == null || userSystemVOList.isEmpty()) {
            return null;
        }
        List<UserSystemDTO> userSystemDTOList = new ArrayList<UserSystemDTO>(userSystemVOList.size());
        for (UserSystemVO userSystemVO : userSystemVOList) {
            userSystemDTOList.add(toUserSystemDTO(userSystemVO));
        }
        return userSystemDTOList;
    }
    
    public static UserSystemQueryDTO toUserSystemQueryDTO(UserSystemQueryVO userSystemQueryVO) {
        if (userSystemQueryVO== null) {
            return null;
        }
        UserSystemQueryDTO userSystemQueryDTO = new UserSystemQueryDTO();
        beanCopierForUserSystemQueryDTO.copy(userSystemQueryVO, userSystemQueryDTO, null);
        return userSystemQueryDTO;
    }
}