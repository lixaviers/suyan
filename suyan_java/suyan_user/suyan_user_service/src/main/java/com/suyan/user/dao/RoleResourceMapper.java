package com.suyan.user.dao;

import com.suyan.user.model.RoleResource;
import com.suyan.user.model.RoleResourceExample;
import com.suyan.user.req.RoleResourceQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleResourceMapper {
    
    long countByExample(RoleResourceExample example);

    int deleteByExample(RoleResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoleResource record);

    int insertSelective(RoleResource record);

    List<RoleResource> selectByExample(RoleResourceExample example);

    RoleResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RoleResource record, @Param("example") RoleResourceExample example);

    int updateByExample(@Param("record") RoleResource record, @Param("example") RoleResourceExample example);

    int updateByPrimaryKeySelective(RoleResource record);

    int updateByPrimaryKey(RoleResource record);


    RoleResource selectByPrimaryKeyForUpdate(Long id);

    List<RoleResource> queryRoleResource(RoleResourceQueryDTO roleResourceQuery);

    int insertBatch(@Param("modelList") List<RoleResource> modelList);

    
    List<RoleResource> selectByRoleId(@Param("roleId") Integer roleId);


}