package com.suyan.user.service;

import com.suyan.user.req.SystemDTO;
import com.suyan.user.req.SystemQueryDTO;
import com.suyan.user.resp.SystemODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;

import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <对外API 系统管理接口>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public interface ISystemService {

    /**
     * 
     * 删除系统
     * 
     * @author lixavier
     * @version 1.0.0
    * @param id
     * @return
     */
    UserResult<Integer> deleteSystem(Integer id);
    
    /**
     * 
     * 创建系统
     * 
     * @author lixavier
     * @version 1.0.0
     * @param systemDTO
     * @return
     */
    UserResult<Integer> createSystem(SystemDTO systemDTO);

    /**
     *
     * 批量创建系统
     *
     * @author lixavier
     * @version 1.0.0
     * @param systemDTOs
     * @return
     */
    UserResult<Integer> batchCreate(List<SystemDTO> systemDTOs);

    /**
     * 
     * 更新系统
     * 
     * @author lixavier
     * @version 1.0.0
     * @param systemDTO
     * @return
     */
    UserResult<Integer> updateSystem(SystemDTO systemDTO);
    
    /**
     * 
     * 根据ID获取系统信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @return
     */
    UserResult<SystemODTO> getSystem(Integer id);

    /**
     * 
     * 分页查询系统信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param systemQueryDTO
     * @return
     */
    UserResult<QueryResultODTO<SystemODTO>> querySystem(SystemQueryDTO systemQueryDTO);

    /**
    * The following custom service interface about dubbo
    */
}