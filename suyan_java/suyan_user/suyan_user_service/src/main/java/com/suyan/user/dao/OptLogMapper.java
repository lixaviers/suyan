package com.suyan.user.dao;

import com.suyan.user.model.OptLog;
import com.suyan.user.model.OptLogExample;
import com.suyan.user.req.OptLogQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OptLogMapper {
    
    long countByExample(OptLogExample example);

    int deleteByExample(OptLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OptLog record);

    int insertSelective(OptLog record);

    List<OptLog> selectByExample(OptLogExample example);

    OptLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OptLog record, @Param("example") OptLogExample example);

    int updateByExample(@Param("record") OptLog record, @Param("example") OptLogExample example);

    int updateByPrimaryKeySelective(OptLog record);

    int updateByPrimaryKey(OptLog record);


    OptLog selectByPrimaryKeyForUpdate(Long id);

    List<OptLog> queryOptLog(OptLogQueryDTO optLogQuery);

    int insertBatch(@Param("modelList") List<OptLog> modelList);



}