package com.suyan.user.service;

import com.suyan.user.req.UserDTO;
import com.suyan.user.req.UserQueryDTO;
import com.suyan.user.resp.UserODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;

import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <对外API 用户管理接口>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-18>
 * @Modify Date: <2018-09-18>
 * @Version: <1.0>
 */
public interface IUserService {

    /**
     * 
     * 删除用户
     * 
     * @author lixavier
     * @version 1.0.0
    * @param idList
     * @return
     */
    UserResult<Integer> deleteUser(List<Long> idList);
    
    /**
     * 
     * 创建用户
     * 
     * @author lixavier
     * @version 1.0.0
     * @param userDTO
     * @return
     */
    UserResult<Long> createUser(UserDTO userDTO);

    /**
     * 
     * 更新用户
     * 
     * @author lixavier
     * @version 1.0.0
     * @param userDTO
     * @return
     */
    UserResult<Integer> updateUser(UserDTO userDTO);
    
    /**
     * 
     * 根据ID获取用户信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @return
     */
    UserResult<UserODTO> getUser(Long id);

    /**
     * 
     * 分页查询用户信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param userQueryDTO
     * @return
     */
    UserResult<QueryResultODTO<UserODTO>> queryUser(UserQueryDTO userQueryDTO);

    /**
    * The following custom service interface about dubbo
    */

    /**
     *
     * 根据ID获取用户信息
     *
     * @author lixavier
     * @version 1.0.0
     * @param userName
     * @return
     */
    UserResult<UserODTO> getUserByUserName(String userName);

    UserResult<UserODTO> getUserByOpenId(String openId);


}