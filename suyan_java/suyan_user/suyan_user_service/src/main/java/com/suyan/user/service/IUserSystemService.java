package com.suyan.user.service;

import com.suyan.user.req.UserSystemDTO;
import com.suyan.user.req.UserSystemQueryDTO;
import com.suyan.user.resp.UserSystemODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;

import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <对外API 用户系统管理接口>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public interface IUserSystemService {

    /**
     * 
     * 删除用户系统
     * 
     * @author lixavier
     * @version 1.0.0
    * @param id
     * @return
     */
    UserResult<Integer> deleteUserSystem(Long id);
    
    /**
     * 
     * 创建用户系统
     * 
     * @author lixavier
     * @version 1.0.0
     * @param userSystemDTO
     * @return
     */
    UserResult<Long> createUserSystem(UserSystemDTO userSystemDTO);

    /**
     *
     * 批量创建用户系统
     *
     * @author lixavier
     * @version 1.0.0
     * @param userSystemDTOs
     * @return
     */
    UserResult<Integer> batchCreate(List<UserSystemDTO> userSystemDTOs);

    /**
     * 
     * 更新用户系统
     * 
     * @author lixavier
     * @version 1.0.0
     * @param userSystemDTO
     * @return
     */
    UserResult<Integer> updateUserSystem(UserSystemDTO userSystemDTO);
    
    /**
     * 
     * 根据ID获取用户系统信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @return
     */
    UserResult<UserSystemODTO> getUserSystem(Long id);

    /**
     * 
     * 分页查询用户系统信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param userSystemQueryDTO
     * @return
     */
    UserResult<QueryResultODTO<UserSystemODTO>> queryUserSystem(UserSystemQueryDTO userSystemQueryDTO);

    /**
    * The following custom service interface about dubbo
    */
}