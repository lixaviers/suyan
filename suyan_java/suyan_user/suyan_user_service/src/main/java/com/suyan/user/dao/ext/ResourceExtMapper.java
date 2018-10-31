package com.suyan.user.dao.ext;

import com.suyan.user.model.Resource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceExtMapper {

    /**
     * 根据用户openId获取资源列表
     * @param userOpenId
     * @return
     */
    List<Resource> getResourcesByUserOpenId(
            @Param("userOpenId") String userOpenId,
            @Param("type") Byte type);
    List<Resource> getResourcesByAdmin(
            @Param("type") Byte type);
    /**
     * 根据用户权限列表
     * @param userOpenId
     * @return
     */
    List<String> getUserPermissions(
            @Param("userOpenId") String userOpenId
    );

    List<Resource> getTreeResource();

    /**
     * 根据角色id获取资源列表
     * @param roleId
     * @return
     */
    List<Resource> getResourcesByRoleId(@Param("roleId") Integer roleId);

    List<Long> getResourceIdListByRoleId(@Param("roleId") Integer roleId);

    List<String> getResourceUrlByUserOpenId(
            @Param("userOpenId") String userOpenId,
            @Param("type") Byte type
    );


}