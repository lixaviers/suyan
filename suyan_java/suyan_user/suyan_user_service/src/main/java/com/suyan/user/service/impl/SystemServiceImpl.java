package com.suyan.user.service.impl;

import com.suyan.user.biz.SystemBiz;
import com.suyan.user.biz.convertor.SystemConvertor;
import com.suyan.user.model.System;
import com.suyan.user.req.SystemDTO;
import com.suyan.user.req.SystemQueryDTO;
import com.suyan.user.resp.SystemODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;
import com.suyan.user.service.ISystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.suyan.user.validate.SystemValidate.validateForCreate;
import static com.suyan.user.validate.SystemValidate.validateForUpdate;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <Dubbo Service 系统管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
@Service("systemService")
public class SystemServiceImpl implements ISystemService {
    private final Logger logger = LoggerFactory.getLogger(SystemServiceImpl.class);

    @Autowired
    private SystemBiz systemBiz;

    /**
     * 删除系统
     *
     * @param id
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<Integer> deleteSystem(Integer id) {
        UserResult<Integer> result = UserResult.newSuccess();
        result.setDataMap(systemBiz.deleteSystem(id));
        return result;
    }

    /**
     * 创建系统
     *
     * @param systemDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<Integer> createSystem(SystemDTO systemDTO) {
        UserResult<Integer> result = UserResult.newSuccess();
        System system = SystemConvertor.toSystem(systemDTO);
        if (!validateForCreate(system, result)) {
            return result;
        }
        result.setDataMap(systemBiz.createSystem(system));
        return result;
    }

    @Override
    public UserResult<Integer> batchCreate(List<SystemDTO> systemDTOs) {
        UserResult<Integer> result = UserResult.newSuccess();
        List<System> items = SystemConvertor.toSystemList(systemDTOs);
        result.setDataMap(systemBiz.batchCreateSystem(items));
        return result;
    }

    /**
     * 更新系统
     *
     * @param systemDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<Integer> updateSystem(SystemDTO systemDTO) {
        UserResult<Integer> result = UserResult.newSuccess();
        System system = null;
        system = SystemConvertor.toSystem(systemDTO);
        if (!validateForUpdate(system, result)) {
            return result;
        }
        result.setDataMap(systemBiz.updateSystem(system));
        return result;
    }

    /**
     * 根据ID获取系统信息
     *
     * @param id
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<SystemODTO> getSystem(Integer id) {
        UserResult<SystemODTO> result = UserResult.newSuccess();
        System system = systemBiz.getSystem(id);
        SystemODTO systemODTO = SystemConvertor.toSystemODTO(system);
        result.setDataMap(systemODTO);
        return result;
    }

    /**
     * 分页查询系统信息
     *
     * @param systemQueryDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<QueryResultODTO<SystemODTO>> querySystem(SystemQueryDTO systemQueryDTO) {
        UserResult<QueryResultODTO<SystemODTO>> result = UserResult.newSuccess();

        QueryResultODTO<System> resultInfo = systemBiz.querySystem(systemQueryDTO);
        result.setDataMap(SystemConvertor.toQueryResult(resultInfo));

        return result;
    }
}