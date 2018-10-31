package com.suyan.user.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.user.dao.SystemMapper;
import com.suyan.user.exception.CommonBizException;
import com.suyan.user.model.System;
import com.suyan.user.req.SystemQueryDTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResultCode;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <业务层系统管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
@Service("systemBiz")
public class SystemBiz {
    private final Logger logger = LoggerFactory.getLogger(SystemBiz.class);

    @Autowired
    SystemMapper systemMapper;

    /**
     * 删除系统
     *
     * @param id
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteSystem(Integer id) {
        return systemMapper.logicalDeleteByPrimaryKey(id);
    }

    /**
     * 创建系统
     *
     * @param system
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer createSystem(System system) {

        System systemLast = systemMapper.selectBySysCode(system.getSysCode());
        if (systemLast != null) {
            throw new CommonBizException(UserResultCode.DATA_EXIST, System.SYS_CODE);
        }

        if (StringUtils.isNotEmpty(system.getServiceId())) {
            System temp = systemMapper.selectByServiceId(system.getServiceId());
            if (temp != null) {
                throw new CommonBizException(UserResultCode.DATA_EXIST, System.SERVICE_ID);
            }
        }
        if (StringUtils.isNotEmpty(system.getPath())) {
            System temp = systemMapper.selectByPath(system.getPath());
            if (temp != null) {
                throw new CommonBizException(UserResultCode.DATA_EXIST, System.PATH);
            }
        }


        system.setSortNumber(1);
        systemMapper.insertSelective(system);
        return system.getId();
    }

    /**
     * 批量创建
     *
     * @param systemList
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateSystem(List<System> systemList) {
        // TODO: Describe business logic and implement it
        return systemMapper.insertBatch(systemList);
    }

    /**
     * 更新系统
     *
     * @param system
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateSystem(System system) {
        Integer result = null;
        System systemLast = systemMapper.selectByPrimaryKeyForUpdate(system.getId());
        if (systemLast == null) {
            throw new CommonBizException(UserResultCode.DATA_NOT_EXIST, "系统");
        }


        if (StringUtils.isNotEmpty(system.getServiceId())) {
            System temp = systemMapper.selectByServiceId(system.getServiceId());
            if (temp != null && temp.getId() != system.getId()) {
                throw new CommonBizException(UserResultCode.DATA_EXIST, System.SERVICE_ID);
            }
        }
        if (StringUtils.isNotEmpty(system.getPath())) {
            System temp = systemMapper.selectByPath(system.getPath());
            if (temp != null && temp.getId() != system.getId()) {
                throw new CommonBizException(UserResultCode.DATA_EXIST, System.PATH);
            }
        }

        system.setCreateTime(null);
        system.setCreateUser(null);
        system.setIsDeleted(null);
        result = systemMapper.updateByPrimaryKeySelective(system);
        return result;
    }

    /**
     * 根据ID获取系统信息
     *
     * @param id
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public System getSystem(Integer id) {
        // TODO: Describe business logic and implement it
        System system = systemMapper.selectByPrimaryKey(id);
        return system;
    }

    /**
     * 分页查询系统信息
     *
     * @param systemQuery
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public QueryResultODTO<System> querySystem(SystemQueryDTO systemQuery) {
        QueryResultODTO<System> queryResult = new QueryResultODTO<System>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(systemQuery.getPageNo(), systemQuery.getPageSize());
        List<System> systemList = systemMapper.querySystem(systemQuery);
        PageInfo<System> pageInfo = new PageInfo<System>(systemList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(systemList);
        return queryResult;
    }

}