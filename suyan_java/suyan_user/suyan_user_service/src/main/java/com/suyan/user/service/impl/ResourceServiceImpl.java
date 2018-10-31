package com.suyan.user.service.impl;

import com.suyan.user.biz.ResourceBiz;
import com.suyan.user.biz.convertor.ResourceConvertor;
import com.suyan.user.model.Resource;
import com.suyan.user.req.ResourceDTO;
import com.suyan.user.req.ResourceQueryDTO;
import com.suyan.user.resp.NavODTO;
import com.suyan.user.resp.ResourceODTO;
import com.suyan.user.resp.UserPermissionsODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;
import com.suyan.user.service.IResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.suyan.user.validate.ResourceValidate.validateForCreate;
import static com.suyan.user.validate.ResourceValidate.validateForUpdate;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <Dubbo Service 资源管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
@Service("resourceService")
public class ResourceServiceImpl implements IResourceService {
    private final Logger logger = LoggerFactory.getLogger(ResourceServiceImpl.class);

    @Autowired
    private ResourceBiz resourceBiz;

    /**
     * 删除资源
     *
     * @param id
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<Integer> deleteResource(Long id, String updateUser, String updateUserName) {
        UserResult<Integer> result = UserResult.newSuccess();
        result.setDataMap(resourceBiz.deleteResource(id, updateUser, updateUserName));
        return result;
    }

    /**
     * 创建资源
     *
     * @param resourceDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<Long> createResource(ResourceDTO resourceDTO) {
        UserResult<Long> result = UserResult.newSuccess();
        Resource resource = ResourceConvertor.toResource(resourceDTO);
        if (!validateForCreate(resource, result)) {
            return result;
        }
        result.setDataMap(resourceBiz.createResource(resource));
        return result;
    }

    @Override
    public UserResult<Integer> batchCreate(List<ResourceDTO> resourceDTOs) {
        UserResult<Integer> result = UserResult.newSuccess();
        List<Resource> items = ResourceConvertor.toResourceList(resourceDTOs);
        result.setDataMap(resourceBiz.batchCreateResource(items));
        return result;
    }

    /**
     * 更新资源
     *
     * @param resourceDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<Integer> updateResource(ResourceDTO resourceDTO) {
        UserResult<Integer> result = UserResult.newSuccess();
        Resource resource = null;
        resource = ResourceConvertor.toResource(resourceDTO);
        if (!validateForUpdate(resource, result)) {
            return result;
        }
        result.setDataMap(resourceBiz.updateResource(resource));
        return result;
    }

    /**
     * 根据ID获取资源信息
     *
     * @param id
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<ResourceODTO> getResource(Long id) {
        UserResult<ResourceODTO> result = UserResult.newSuccess();
        Resource resource = resourceBiz.getResource(id);
        ResourceODTO resourceODTO = ResourceConvertor.toResourceODTO(resource);
        result.setDataMap(resourceODTO);
        return result;
    }

    /**
     * 分页查询资源信息
     *
     * @param resourceQueryDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<QueryResultODTO<ResourceODTO>> queryResource(ResourceQueryDTO resourceQueryDTO) {
        UserResult<QueryResultODTO<ResourceODTO>> result = UserResult.newSuccess();

        QueryResultODTO<Resource> resultInfo = resourceBiz.queryResource(resourceQueryDTO);
        result.setDataMap(ResourceConvertor.toQueryResult(resultInfo));

        return result;
    }

    /**
     * 根据用户openId获取资源列表
     *
     * @param userOpenId
     * @return
     */
    @Override
    public UserResult<NavODTO> getNav(String userOpenId) {
        UserResult<NavODTO> result = UserResult.newSuccess();
        result.setDataMap(resourceBiz.getNav(userOpenId));
        return result;
    }

    @Override
    public UserResult<List<ResourceODTO>> getTreeResource(Integer systemId) {
        UserResult<List<ResourceODTO>> result = UserResult.newSuccess();
        List<Resource> list = resourceBiz.getTreeResource(systemId);
        result.setDataMap(ResourceConvertor.toResourceODTOList(list));
        return result;
    }

    /**
     * 根据角色id获取资源列表
     *
     * @param roleId
     * @return
     */
    @Override
    public UserResult<List<ResourceODTO>> getResourcesByRoleId(Integer roleId) {
        UserResult<List<ResourceODTO>> result = UserResult.newSuccess();
        List<Resource> list = resourceBiz.getResourcesByRoleId(roleId);
        result.setDataMap(ResourceConvertor.toResourceODTOList(list));
        return result;
    }

    @Override
    public UserResult<UserPermissionsODTO> getResourceUrlByUserOpenId(String userOpenId) {
        UserResult<UserPermissionsODTO> result = UserResult.newSuccess();
        result.setDataMap(resourceBiz.getResourceUrlByUserOpenId(userOpenId));
        return result;
    }

}