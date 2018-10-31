package com.suyan.user.convertor;

import com.suyan.user.req.RoleResourceDTO;
import com.suyan.user.req.RoleResourceQueryDTO;
import com.suyan.user.vo.RoleResourceQueryVO;
import com.suyan.user.vo.RoleResourceVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <web层角色资源转换类 将Valid的Vo类转换为Dubbo层的Req对象>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public abstract class RoleResourceConvertor {

    private static final BeanCopier beanCopierForRoleResourceDTO = BeanCopier.create(RoleResourceVO.class, RoleResourceDTO.class, false);
    private static final BeanCopier beanCopierForRoleResourceQueryDTO = BeanCopier.create(RoleResourceQueryVO.class, RoleResourceQueryDTO.class, false);

    public static RoleResourceDTO toRoleResourceDTO(RoleResourceVO roleResourceVO) {
        if (roleResourceVO == null) {
            return null;
        }
        RoleResourceDTO roleResourceDTO = new RoleResourceDTO();
        beanCopierForRoleResourceDTO.copy(roleResourceVO, roleResourceDTO, null);
        return roleResourceDTO;
    }

    public static List<RoleResourceDTO> toRoleResourceDTOList(List<RoleResourceVO> roleResourceVOList) {
        if (roleResourceVOList == null || roleResourceVOList.isEmpty()) {
            return null;
        }
        List<RoleResourceDTO> roleResourceDTOList = new ArrayList<RoleResourceDTO>(roleResourceVOList.size());
        for (RoleResourceVO roleResourceVO : roleResourceVOList) {
            roleResourceDTOList.add(toRoleResourceDTO(roleResourceVO));
        }
        return roleResourceDTOList;
    }
    
    public static RoleResourceQueryDTO toRoleResourceQueryDTO(RoleResourceQueryVO roleResourceQueryVO) {
        if (roleResourceQueryVO== null) {
            return null;
        }
        RoleResourceQueryDTO roleResourceQueryDTO = new RoleResourceQueryDTO();
        beanCopierForRoleResourceQueryDTO.copy(roleResourceQueryVO, roleResourceQueryDTO, null);
        return roleResourceQueryDTO;
    }
}