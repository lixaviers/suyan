package com.suyan.user.dao;

import com.suyan.user.model.UserSystem;
import com.suyan.user.model.UserSystemExample;
import com.suyan.user.req.UserSystemQueryDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserSystemMapper {
    
    long countByExample(UserSystemExample example);

    int deleteByExample(UserSystemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserSystem record);

    int insertSelective(UserSystem record);

    List<UserSystem> selectByExample(UserSystemExample example);

    UserSystem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserSystem record, @Param("example") UserSystemExample example);

    int updateByExample(@Param("record") UserSystem record, @Param("example") UserSystemExample example);

    int updateByPrimaryKeySelective(UserSystem record);

    int updateByPrimaryKey(UserSystem record);

    int logicalDeleteByPrimaryKey(
            @Param("id") Long id,
            @Param("updateUser") String updateUser,
            @Param("updateUserName") String updateUserName
    );

    UserSystem selectByPrimaryKeyForUpdate(Long id);

    List<UserSystem> queryUserSystem(UserSystemQueryDTO userSystemQuery);

    int insertBatch(@Param("modelList") List<UserSystem> modelList);

    
    List<UserSystem> selectByUserOpenId(@Param("userOpenId") String userOpenId);


}