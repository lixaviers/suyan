package com.suyan.user.biz.convertor;

import com.suyan.user.model.System;
import com.suyan.user.req.SystemDTO;
import com.suyan.user.resp.SystemODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <Dubbo层系统转换类 Dubbo层的Info对象与dal层的model对象相互转换>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public abstract class SystemConvertor {

    private static final BeanCopier beanCopierForSystemODTO = BeanCopier.create(System.class, SystemODTO.class, false);
    private static final BeanCopier beanCopierForSystem = BeanCopier.create(SystemDTO.class, System.class, false);

    public static SystemODTO toSystemODTO(System system) {
        if (system == null) {
            return null;
        }
        SystemODTO systemODTO = new SystemODTO();
        beanCopierForSystemODTO.copy(system, systemODTO, null);
        return systemODTO;
    }

    public static System toSystem(SystemDTO systemDTO) {
        System system = new System();
        beanCopierForSystem.copy(systemDTO, system, null);
        return system;
    }

    public static List<SystemODTO> toSystemODTOList(List<System> systemList) {
        if (systemList == null || systemList.isEmpty()) {
            return null;
        }
        List<SystemODTO> systemInfoList = new ArrayList<SystemODTO>(systemList.size());
        for (System system : systemList) {
            systemInfoList.add(toSystemODTO(system));
        }
        return systemInfoList;
    }

    public static List<System> toSystemList(List<SystemDTO> systemDTOList) {
        if (systemDTOList == null || systemDTOList.isEmpty()) {
            return null;
        }
        List<System> systemList = new ArrayList<System>(systemDTOList.size());
        for (SystemDTO systemDTO : systemDTOList) {
            systemList.add(toSystem(systemDTO));
        }
        return systemList;
    }

    public static QueryResultODTO<SystemODTO> toQueryResult(QueryResultODTO<System> queryResult) {
        QueryResultODTO<SystemODTO> queryResultInfo = new QueryResultODTO<SystemODTO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toSystemODTOList(queryResult.getRecords()));
        return queryResultInfo;
        }
}