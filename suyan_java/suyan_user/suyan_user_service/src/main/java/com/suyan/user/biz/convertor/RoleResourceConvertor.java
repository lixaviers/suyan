package com.suyan.user.biz.convertor;

import com.suyan.user.model.RoleResource;
import com.suyan.user.req.RoleResourceDTO;
import com.suyan.user.resp.RoleResourceODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <Dubbo层角色资源转换类 Dubbo层的Info对象与dal层的model对象相互转换>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public abstract class RoleResourceConvertor {

    private static final BeanCopier beanCopierForRoleResourceODTO = BeanCopier.create(RoleResource.class, RoleResourceODTO.class, false);
    private static final BeanCopier beanCopierForRoleResource = BeanCopier.create(RoleResourceDTO.class, RoleResource.class, false);

    public static RoleResourceODTO toRoleResourceODTO(RoleResource roleResource) {
        if (roleResource == null) {
            return null;
        }
        RoleResourceODTO roleResourceODTO = new RoleResourceODTO();
        beanCopierForRoleResourceODTO.copy(roleResource, roleResourceODTO, null);
        return roleResourceODTO;
    }

    public static RoleResource toRoleResource(RoleResourceDTO roleResourceDTO) {
        RoleResource roleResource = new RoleResource();
        beanCopierForRoleResource.copy(roleResourceDTO, roleResource, null);
        return roleResource;
    }

    public static List<RoleResourceODTO> toRoleResourceODTOList(List<RoleResource> roleResourceList) {
        if (roleResourceList == null || roleResourceList.isEmpty()) {
            return null;
        }
        List<RoleResourceODTO> roleResourceInfoList = new ArrayList<RoleResourceODTO>(roleResourceList.size());
        for (RoleResource roleResource : roleResourceList) {
            roleResourceInfoList.add(toRoleResourceODTO(roleResource));
        }
        return roleResourceInfoList;
    }

    public static List<RoleResource> toRoleResourceList(List<RoleResourceDTO> roleResourceDTOList) {
        if (roleResourceDTOList == null || roleResourceDTOList.isEmpty()) {
            return null;
        }
        List<RoleResource> roleResourceList = new ArrayList<RoleResource>(roleResourceDTOList.size());
        for (RoleResourceDTO roleResourceDTO : roleResourceDTOList) {
            roleResourceList.add(toRoleResource(roleResourceDTO));
        }
        return roleResourceList;
    }

    public static QueryResultODTO<RoleResourceODTO> toQueryResult(QueryResultODTO<RoleResource> queryResult) {
        QueryResultODTO<RoleResourceODTO> queryResultInfo = new QueryResultODTO<RoleResourceODTO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toRoleResourceODTOList(queryResult.getRecords()));
        return queryResultInfo;
        }
}