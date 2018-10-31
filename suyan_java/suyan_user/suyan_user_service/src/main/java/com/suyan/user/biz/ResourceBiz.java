package com.suyan.user.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.user.biz.convertor.ResourceConvertor;
import com.suyan.user.constant.ResourceTypeEnum;
import com.suyan.user.dao.ResourceMapper;
import com.suyan.user.dao.ext.ResourceExtMapper;
import com.suyan.user.exception.CommonBizException;
import com.suyan.user.model.Resource;
import com.suyan.user.model.ResourceExample;
import com.suyan.user.model.User;
import com.suyan.user.req.ResourceQueryDTO;
import com.suyan.user.resp.NavODTO;
import com.suyan.user.resp.UserPermissionsODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResultCode;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <业务层资源管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
@Service("resourceBiz")
public class ResourceBiz {
    private final Logger logger = LoggerFactory.getLogger(ResourceBiz.class);

    @Autowired
    ResourceMapper resourceMapper;
    @Autowired
    private ResourceExtMapper resourceExtMapper;

    @Autowired
    private UserBiz userBiz;

    /**
     * 删除资源
     *
     * @param id
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteResource(Long id, String updateUser, String updateUserName) {
        resourceMapper.logicalDeleteByPrimaryKey(id, updateUser, updateUserName);

        ResourceExample example = new ResourceExample();
        example.createCriteria().andParentIdEqualTo(id).andIsDeletedEqualTo(false);
        Resource resource = new Resource();
        resource.setUpdateTime(new Date());
        resource.setUpdateUser(updateUser);
        resource.setUpdateUserName(updateUserName);
        resource.setIsDeleted(true);
        resourceMapper.updateByExampleSelective(resource, example);

        return 1;
    }

    /**
     * 创建资源
     *
     * @param resource
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createResource(Resource resource) {

        Resource temp = resourceMapper.selectByResourceCode(resource.getResourceCode());
        if (temp != null) {
            throw new CommonBizException(UserResultCode.DATA_EXIST, Resource.RESOURCE_CODE);
        }
        resource.setCreateTime(null);
        resource.setUpdateTime(null);
        resource.setIsDeleted(false);
        resourceMapper.insertSelective(resource);
        return resource.getId();
    }

    /**
     * 批量创建
     *
     * @param resourceList
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateResource(List<Resource> resourceList) {
        return resourceMapper.insertBatch(resourceList);
    }

    /**
     * 更新资源
     *
     * @param resource
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateResource(Resource resource) {
        Resource resourceLast = resourceMapper.selectByPrimaryKeyForUpdate(resource.getId());
        if (resourceLast == null) {
            throw new CommonBizException(UserResultCode.DATA_NOT_EXIST, "资源");
        }
        Resource temp = resourceMapper.selectByResourceCode(resource.getResourceCode());
        if (temp != null && temp.getId() != resource.getId()) {
            throw new CommonBizException(UserResultCode.DATA_EXIST, Resource.RESOURCE_CODE);
        }
        resource.setCreateTime(null);
        resource.setCreateUser(null);
        resource.setCreateUserName(null);
        resource.setUpdateTime(null);
        resource.setIsDeleted(null);
        return resourceMapper.updateByPrimaryKeySelective(resource);
    }

    /**
     * 根据ID获取资源信息
     *
     * @param id
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public Resource getResource(Long id) {
        // TODO: Describe business logic and implement it
        Resource resource = resourceMapper.selectByPrimaryKey(id);
        return resource;
    }

    /**
     * 分页查询资源信息
     *
     * @param resourceQuery
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public QueryResultODTO<Resource> queryResource(ResourceQueryDTO resourceQuery) {
        QueryResultODTO<Resource> queryResult = new QueryResultODTO<Resource>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(resourceQuery.getPageNo(), resourceQuery.getPageSize());
        List<Resource> resourceList = resourceMapper.queryResource(resourceQuery);
        PageInfo<Resource> pageInfo = new PageInfo<Resource>(resourceList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(resourceList);
        return queryResult;
    }

    /**
     * 根据用户openId获取资源列表
     *
     * @param userOpenId
     * @return
     */
    @Transactional(readOnly = true)
    public NavODTO getNav(String userOpenId) {
        NavODTO nav = new NavODTO();
        User user = userBiz.getUserByOpenId(userOpenId);
        if (user != null && user.getIsAdmin()) {
            nav.setIsAdmin(true);
            nav.setMenuList(ResourceConvertor.toResourceODTOList(resourceExtMapper.getResourcesByAdmin(ResourceTypeEnum.MENU.getValue())));
        } else {
            nav.setIsAdmin(false);
            nav.setMenuList(ResourceConvertor.toResourceODTOList(resourceExtMapper.getResourcesByUserOpenId(userOpenId, ResourceTypeEnum.MENU.getValue())));
            nav.setPermissions(resourceExtMapper.getUserPermissions(userOpenId));
        }
        return nav;
    }

    /**
     * 获取树资源
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<Resource> getTreeResource(Integer systemId) {
        ResourceExample example = new ResourceExample();
        example.createCriteria().andIsDeletedEqualTo(false).andSystemIdEqualTo(systemId);
        example.setOrderByClause("sort_number,id");
        List<Resource> treeResources = resourceMapper.selectByExample(example);
        return treeResources;
//        return setTreeResources(treeResources);
    }

    /**
     * 根据角色id获取资源列表
     *
     * @param roleId
     * @return
     */
    @Transactional(readOnly = true)
    public List<Resource> getResourcesByRoleId(Integer roleId) {
        return resourceExtMapper.getResourcesByRoleId(roleId);
    }

    private List<Resource> setTreeResources(List<Resource> resources) {
        List<Resource> temp = new ArrayList<>();
        HashMap<String, Resource> treeNodesMap = new HashMap<String, Resource>();
        for (Resource resource : resources) {
            treeNodesMap.put(resource.getId().toString(), resource);
        }
        for (Resource resource : resources) {
            if (resource.getParentId() == null) {
                temp.add(resource);
                continue;
            }

            Resource parentResource = treeNodesMap.get(resource.getParentId().toString());
            if (parentResource != null) {
                List<Resource> childResource = new ArrayList<>();
                if (CollectionUtils.isNotEmpty(parentResource.getChildren())) {
                    childResource = parentResource.getChildren();
                }
                childResource.add(resource);
                parentResource.setChildren(childResource);
            }
        }
        return temp;
    }


    @Transactional(readOnly = true)
    public UserPermissionsODTO getResourceUrlByUserOpenId(String userOpenId) {
        UserPermissionsODTO odto = new UserPermissionsODTO();
        User user = userBiz.getUserByOpenId(userOpenId);
        if (user != null && user.getIsAdmin()) {
            odto.setIsAdmin(true);
        } else {
            odto.setIsAdmin(false);
            odto.setUrlList(resourceExtMapper.getResourceUrlByUserOpenId(userOpenId, ResourceTypeEnum.API.getValue()));
        }
        return odto;
    }

}