package com.suyan.user.biz.convertor;

import com.suyan.user.model.UserRole;
import com.suyan.user.req.UserRoleDTO;
import com.suyan.user.resp.UserRoleODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <Dubbo层用户角色转换类 Dubbo层的Info对象与dal层的model对象相互转换>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public abstract class UserRoleConvertor {

    private static final BeanCopier beanCopierForUserRoleODTO = BeanCopier.create(UserRole.class, UserRoleODTO.class, false);
    private static final BeanCopier beanCopierForUserRole = BeanCopier.create(UserRoleDTO.class, UserRole.class, false);

    public static UserRoleODTO toUserRoleODTO(UserRole userRole) {
        if (userRole == null) {
            return null;
        }
        UserRoleODTO userRoleODTO = new UserRoleODTO();
        beanCopierForUserRoleODTO.copy(userRole, userRoleODTO, null);
        return userRoleODTO;
    }

    public static UserRole toUserRole(UserRoleDTO userRoleDTO) {
        UserRole userRole = new UserRole();
        beanCopierForUserRole.copy(userRoleDTO, userRole, null);
        return userRole;
    }

    public static List<UserRoleODTO> toUserRoleODTOList(List<UserRole> userRoleList) {
        if (userRoleList == null || userRoleList.isEmpty()) {
            return null;
        }
        List<UserRoleODTO> userRoleInfoList = new ArrayList<UserRoleODTO>(userRoleList.size());
        for (UserRole userRole : userRoleList) {
            userRoleInfoList.add(toUserRoleODTO(userRole));
        }
        return userRoleInfoList;
    }

    public static List<UserRole> toUserRoleList(List<UserRoleDTO> userRoleDTOList) {
        if (userRoleDTOList == null || userRoleDTOList.isEmpty()) {
            return null;
        }
        List<UserRole> userRoleList = new ArrayList<UserRole>(userRoleDTOList.size());
        for (UserRoleDTO userRoleDTO : userRoleDTOList) {
            userRoleList.add(toUserRole(userRoleDTO));
        }
        return userRoleList;
    }

    public static QueryResultODTO<UserRoleODTO> toQueryResult(QueryResultODTO<UserRole> queryResult) {
        QueryResultODTO<UserRoleODTO> queryResultInfo = new QueryResultODTO<UserRoleODTO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toUserRoleODTOList(queryResult.getRecords()));
        return queryResultInfo;
        }
}