package com.suyan.user.dao.ext;

import com.suyan.user.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleExtMapper {

    List<Role> getRolesByUserOpenId(@Param("userOpenId") String userOpenId);


}