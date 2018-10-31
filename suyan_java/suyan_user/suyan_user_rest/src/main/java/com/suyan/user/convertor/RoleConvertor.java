package com.suyan.user.convertor;

import com.suyan.user.req.RoleDTO;
import com.suyan.user.req.RoleQueryDTO;
import com.suyan.user.vo.RoleQueryVO;
import com.suyan.user.vo.RoleVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <web层角色转换类 将Valid的Vo类转换为Dubbo层的Req对象>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public abstract class RoleConvertor {

    private static final BeanCopier beanCopierForRoleDTO = BeanCopier.create(RoleVO.class, RoleDTO.class, false);
    private static final BeanCopier beanCopierForRoleQueryDTO = BeanCopier.create(RoleQueryVO.class, RoleQueryDTO.class, false);

    public static RoleDTO toRoleDTO(RoleVO roleVO) {
        if (roleVO == null) {
            return null;
        }
        RoleDTO roleDTO = new RoleDTO();
        beanCopierForRoleDTO.copy(roleVO, roleDTO, null);
        roleDTO.setResourceList(ResourceConvertor.toResourceDTOList(roleVO.getResourceList()));
        return roleDTO;
    }

    public static List<RoleDTO> toRoleDTOList(List<RoleVO> roleVOList) {
        if (roleVOList == null || roleVOList.isEmpty()) {
            return null;
        }
        List<RoleDTO> roleDTOList = new ArrayList<RoleDTO>(roleVOList.size());
        for (RoleVO roleVO : roleVOList) {
            roleDTOList.add(toRoleDTO(roleVO));
        }
        return roleDTOList;
    }
    
    public static RoleQueryDTO toRoleQueryDTO(RoleQueryVO roleQueryVO) {
        if (roleQueryVO== null) {
            return null;
        }
        RoleQueryDTO roleQueryDTO = new RoleQueryDTO();
        beanCopierForRoleQueryDTO.copy(roleQueryVO, roleQueryDTO, null);
        return roleQueryDTO;
    }
}