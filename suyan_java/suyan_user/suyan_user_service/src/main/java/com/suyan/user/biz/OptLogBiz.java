package com.suyan.user.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.user.dao.OptLogMapper;
import com.suyan.user.model.OptLog;
import com.suyan.user.req.OptLogQueryDTO;
import com.suyan.user.resp.base.QueryResultODTO;
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
 * @Comments: <业务层操作日志管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-18>
 * @Modify Date: <2018-09-18>
 * @Version: <1.0>
 */
@Service("optLogBiz")
public class OptLogBiz {
    private final Logger logger = LoggerFactory.getLogger(OptLogBiz.class);

    @Autowired
    OptLogMapper optLogMapper;

    /**
    *
    * 删除操作日志
    *
    * @author lixavier
    * @version 1.0.0
    * @param id
    * @return
    */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteOptLog(Long id){
        // TODO: Describe business logic and implement it
        int result = optLogMapper.deleteByPrimaryKey(id);
        return result;    
    }
    
    /**
     * 
     * 创建操作日志
     * 
     * @author lixavier
     * @version 1.0.0
     * @param optLog
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createOptLog(OptLog optLog){
        // TODO: Describe business logic and implement it
        optLogMapper.insertSelective( optLog );
        return optLog.getId();
    }

    /**
    *
    * 批量创建
    *
    * @author lixavier
    * @version 1.0.0
    * @param optLogList
    * @return
    */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public int batchCreateOptLog(List<OptLog> optLogList){
        // TODO: Describe business logic and implement it
        return optLogMapper.insertBatch( optLogList );
    }

    /**
     * 
     * 更新操作日志
     * 
     * @author lixavier
     * @version 1.0.0
     * @param optLog
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateOptLog(OptLog optLog){
        Integer result = null;
        OptLog optLogLast = optLogMapper.selectByPrimaryKeyForUpdate( optLog.getId() );
        if( optLogLast == null){
            // TODO：这里请写清楚
        }
        // TODO: Describe business logic and implement it
        result = optLogMapper.updateByPrimaryKeySelective( optLog );
        return result;    
    }
    
    /**
     * 
     * 根据ID获取操作日志信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public OptLog getOptLog( Long id ){
        // TODO: Describe business logic and implement it
        OptLog optLog = optLogMapper.selectByPrimaryKey( id );
        return optLog;
    }

    /**
     * 
     * 分页查询操作日志信息
     * 
     * @author lixavier
     * @version 1.0.0
     * @param optLogQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultODTO<OptLog> queryOptLog(OptLogQueryDTO optLogQuery) {
        QueryResultODTO<OptLog> queryResult = new QueryResultODTO<OptLog>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(optLogQuery.getPageNo(), optLogQuery.getPageSize());
        List<OptLog> optLogList = optLogMapper.queryOptLog(optLogQuery);
        PageInfo<OptLog> pageInfo = new PageInfo<OptLog>(optLogList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(optLogList);
        return queryResult;
    }

}