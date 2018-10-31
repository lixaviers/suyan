package com.suyan.user.dao;

import com.suyan.user.model.Resource;
import com.suyan.user.model.ResourceExample;
import com.suyan.user.req.ResourceQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceMapper {
    
    long countByExample(ResourceExample example);

    int deleteByExample(ResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    int insertSelective(Resource record);

    List<Resource> selectByExample(ResourceExample example);

    Resource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Resource record, @Param("example") ResourceExample example);

    int updateByExample(@Param("record") Resource record, @Param("example") ResourceExample example);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id,
            @Param("updateUser") String updateUser,
            @Param("updateUserName") String updateUserName);

    Resource selectByPrimaryKeyForUpdate(Long id);

    List<Resource> queryResource(ResourceQueryDTO resourceQuery);

    int insertBatch(@Param("modelList") List<Resource> modelList);


    Resource selectByResourceCode(@Param("resourceCode") String resourceCode);


}