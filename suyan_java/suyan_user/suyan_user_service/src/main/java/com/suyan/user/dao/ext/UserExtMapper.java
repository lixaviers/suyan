package com.suyan.user.dao.ext;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserExtMapper {

    List<Integer> getRoleIdListByUserOpenId(@Param("openId") String openId);


}