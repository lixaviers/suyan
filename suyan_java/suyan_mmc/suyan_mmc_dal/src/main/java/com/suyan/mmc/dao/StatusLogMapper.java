package com.suyan.mmc.dao;

import com.suyan.mmc.model.StatusLog;
import com.suyan.mmc.model.StatusLogExample;
import com.suyan.mmc.req.StatusLogQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface StatusLogMapper {
    
    long countByExample(StatusLogExample example);

    int deleteByExample(StatusLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StatusLog record);

    int insertSelective(StatusLog record);

    List<StatusLog> selectByExample(StatusLogExample example);

    StatusLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StatusLog record, @Param("example") StatusLogExample example);

    int updateByExample(@Param("record") StatusLog record, @Param("example") StatusLogExample example);

    int updateByPrimaryKeySelective(StatusLog record);

    int updateByPrimaryKey(StatusLog record);


    StatusLog selectByPrimaryKeyForUpdate(Long id);

    List<StatusLog> queryStatusLog(StatusLogQueryDTO statusLogQuery);

    int insertBatch(@Param("modelList") List<StatusLog> modelList);



}