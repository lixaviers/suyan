package com.suyan.user.service.impl;

import com.suyan.user.biz.OptLogBiz;
import com.suyan.user.biz.convertor.OptLogConvertor;
import com.suyan.user.model.OptLog;
import com.suyan.user.req.OptLogDTO;
import com.suyan.user.req.OptLogQueryDTO;
import com.suyan.user.resp.OptLogODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;
import com.suyan.user.service.IOptLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.suyan.user.validate.OptLogValidate.validateForCreate;
import static com.suyan.user.validate.OptLogValidate.validateForUpdate;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <Dubbo Service 操作日志管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-18>
 * @Modify Date: <2018-09-18>
 * @Version: <1.0>
 */
@Service("optLogService")
public class OptLogServiceImpl implements IOptLogService {
    private final Logger logger = LoggerFactory.getLogger(OptLogServiceImpl.class);

    @Autowired
    private OptLogBiz optLogBiz;

    /**
     * 
     * 删除操作日志
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param id
     * @return
     */
    @Override
    public UserResult<Integer> deleteOptLog(Long id ){
        UserResult<Integer> result = UserResult.newSuccess();
        result.setDataMap(optLogBiz.deleteOptLog(id ));
        return result;
    }
    
    /**
     * 
     * 创建操作日志
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param optLogDTO
     * @return
     */
    @Override
    public UserResult<Long> createOptLog(OptLogDTO optLogDTO){
        UserResult<Long> result = UserResult.newSuccess();
        OptLog optLog = OptLogConvertor.toOptLog(optLogDTO);
        if (!validateForCreate(optLog, result)) {
            return result;
        }
        result.setDataMap(optLogBiz.createOptLog( optLog ));
        return  result;
    }

    @Override
    public UserResult<Integer> batchCreate(List<OptLogDTO> optLogDTOs ) {
            UserResult<Integer> result = UserResult.newSuccess();
        List<OptLog> items = OptLogConvertor.toOptLogList(optLogDTOs);
        result.setDataMap(optLogBiz.batchCreateOptLog(items));
        return result;
    }

    /**
     * 
     * 更新操作日志
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param optLogDTO
     * @return
     */
    @Override
    public UserResult<Integer> updateOptLog(OptLogDTO optLogDTO){
        UserResult<Integer> result = UserResult.newSuccess();
        OptLog optLog = null;
        optLog = OptLogConvertor.toOptLog(optLogDTO);
        if (!validateForUpdate(optLog, result)) {
            return result;
        }
        result.setDataMap(optLogBiz.updateOptLog( optLog ));
        return result;
    }
    
    /**
     * 
     * 根据ID获取操作日志信息
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param id
     * @return
     */
    @Override
    public UserResult<OptLogODTO> getOptLog(Long id ){
        UserResult<OptLogODTO> result  = UserResult.newSuccess();
        OptLog optLog = optLogBiz.getOptLog( id );
        OptLogODTO optLogODTO = OptLogConvertor.toOptLogODTO(optLog);
        result.setDataMap(optLogODTO);
        return result;
    }

    /**
     * 
     * 分页查询操作日志信息
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param optLogQueryDTO
     * @return
     */
    @Override
    public UserResult<QueryResultODTO<OptLogODTO>> queryOptLog(OptLogQueryDTO optLogQueryDTO) {
        UserResult<QueryResultODTO<OptLogODTO>> result = UserResult.newSuccess();

        QueryResultODTO<OptLog> resultInfo = optLogBiz.queryOptLog(optLogQueryDTO);
        result.setDataMap(OptLogConvertor.toQueryResult(resultInfo));

        return result;
    }
}