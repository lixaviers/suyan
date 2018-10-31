package com.suyan.user.service;

import com.suyan.user.req.OptLogDTO;
import com.suyan.user.req.OptLogQueryDTO;
import com.suyan.user.resp.OptLogODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;

import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <对外API 操作日志管理接口>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-18>
 * @Modify Date: <2018-09-18>
 * @Version: <1.0>
 */
public interface IOptLogService {

    /**
     * 
     * 删除操作日志
     * 
     * @author lixavier
     * @version 1.0.0
    * @param id
     * @return
     */
    UserResult<Integer> deleteOptLog(Long id);
    
    /**
     * 
     * 创建操作日志
     * 
     * @author lixavier
     * @version 1.0.0
     * @param optLogDTO
     * @return
     */
    UserResult<Long> createOptLog(OptLogDTO optLogDTO);

    /**
     *
     * 批量创建操作日志
     *
     * @author lixavier
     * @version 1.0.0
     * @param optLogDTOs
     * @return
     */
    UserResult<Integer> batchCreate(List<OptLogDTO> optLogDTOs);

    /**
     * 
     * 更新操作日志
     * 
     * @author lixavier
     * @version 1.0.0
     * @param optLogDTO
     * @return
     */
    UserResult<Integer> updateOptLog(OptLogDTO optLogDTO);
    
    /**
     * 
     * 根据ID获取操作日志信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @return
     */
    UserResult<OptLogODTO> getOptLog(Long id);

    /**
     * 
     * 分页查询操作日志信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param optLogQueryDTO
     * @return
     */
    UserResult<QueryResultODTO<OptLogODTO>> queryOptLog(OptLogQueryDTO optLogQueryDTO);

    /**
    * The following custom service interface about dubbo
    */
}