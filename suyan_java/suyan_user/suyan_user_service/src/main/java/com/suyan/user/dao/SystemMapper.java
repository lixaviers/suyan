package com.suyan.user.dao;

import com.suyan.user.model.System;
import com.suyan.user.model.SystemExample;
import com.suyan.user.req.SystemQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemMapper {
    
    long countByExample(SystemExample example);

    int deleteByExample(SystemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(System record);

    int insertSelective(System record);

    List<System> selectByExample(SystemExample example);

    System selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") System record, @Param("example") SystemExample example);

    int updateByExample(@Param("record") System record, @Param("example") SystemExample example);

    int updateByPrimaryKeySelective(System record);

    int updateByPrimaryKey(System record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Integer id
    );

    System selectByPrimaryKeyForUpdate(Integer id);

    List<System> querySystem(SystemQueryDTO systemQuery);

    int insertBatch(@Param("modelList") List<System> modelList);


    System selectByPath(@Param("path") String path);

    System selectByServiceId(@Param("serviceId") String serviceId);

    System selectBySysCode(@Param("sysCode") String sysCode);


}