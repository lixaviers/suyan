package com.suyan.user.biz.convertor;

import com.suyan.user.model.Resource;
import com.suyan.user.req.ResourceDTO;
import com.suyan.user.resp.ResourceODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <Dubbo层资源转换类 Dubbo层的Info对象与dal层的model对象相互转换>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public abstract class ResourceConvertor {

    private static final BeanCopier beanCopierForResourceODTO = BeanCopier.create(Resource.class, ResourceODTO.class, false);
    private static final BeanCopier beanCopierForResource = BeanCopier.create(ResourceDTO.class, Resource.class, false);

    public static ResourceODTO toResourceODTO(Resource resource) {
        if (resource == null) {
            return null;
        }
        ResourceODTO resourceODTO = new ResourceODTO();
        beanCopierForResourceODTO.copy(resource, resourceODTO, null);
        if (CollectionUtils.isNotEmpty(resource.getChildren())) {
            resourceODTO.setChildren(toResourceODTOList(resource.getChildren()));
        }
        return resourceODTO;
    }

    public static Resource toResource(ResourceDTO resourceDTO) {
        Resource resource = new Resource();
        beanCopierForResource.copy(resourceDTO, resource, null);
        return resource;
    }

    public static List<ResourceODTO> toResourceODTOList(List<Resource> resourceList) {
        if (resourceList == null || resourceList.isEmpty()) {
            return null;
        }
        List<ResourceODTO> resourceInfoList = new ArrayList<ResourceODTO>(resourceList.size());
        for (Resource resource : resourceList) {
            resourceInfoList.add(toResourceODTO(resource));
        }
        return resourceInfoList;
    }

    public static List<Resource> toResourceList(List<ResourceDTO> resourceDTOList) {
        if (resourceDTOList == null || resourceDTOList.isEmpty()) {
            return null;
        }
        List<Resource> resourceList = new ArrayList<Resource>(resourceDTOList.size());
        for (ResourceDTO resourceDTO : resourceDTOList) {
            resourceList.add(toResource(resourceDTO));
        }
        return resourceList;
    }

    public static QueryResultODTO<ResourceODTO> toQueryResult(QueryResultODTO<Resource> queryResult) {
        QueryResultODTO<ResourceODTO> queryResultInfo = new QueryResultODTO<ResourceODTO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toResourceODTOList(queryResult.getRecords()));
        return queryResultInfo;
        }
}