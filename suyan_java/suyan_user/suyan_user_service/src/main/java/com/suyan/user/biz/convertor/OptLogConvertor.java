package com.suyan.user.biz.convertor;

import com.suyan.user.model.OptLog;
import com.suyan.user.req.OptLogDTO;
import com.suyan.user.resp.OptLogODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <Dubbo层操作日志转换类 Dubbo层的Info对象与dal层的model对象相互转换>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-18>
 * @Modify Date: <2018-09-18>
 * @Version: <1.0>
 */
public abstract class OptLogConvertor {

    private static final BeanCopier beanCopierForOptLogODTO = BeanCopier.create(OptLog.class, OptLogODTO.class, false);
    private static final BeanCopier beanCopierForOptLog = BeanCopier.create(OptLogDTO.class, OptLog.class, false);

    public static OptLogODTO toOptLogODTO(OptLog optLog) {
        if (optLog == null) {
            return null;
        }
        OptLogODTO optLogODTO = new OptLogODTO();
        beanCopierForOptLogODTO.copy(optLog, optLogODTO, null);
        return optLogODTO;
    }

    public static OptLog toOptLog(OptLogDTO optLogDTO) {
        OptLog optLog = new OptLog();
        beanCopierForOptLog.copy(optLogDTO, optLog, null);
        return optLog;
    }

    public static List<OptLogODTO> toOptLogODTOList(List<OptLog> optLogList) {
        if (optLogList == null || optLogList.isEmpty()) {
            return null;
        }
        List<OptLogODTO> optLogInfoList = new ArrayList<OptLogODTO>(optLogList.size());
        for (OptLog optLog : optLogList) {
            optLogInfoList.add(toOptLogODTO(optLog));
        }
        return optLogInfoList;
    }

    public static List<OptLog> toOptLogList(List<OptLogDTO> optLogDTOList) {
        if (optLogDTOList == null || optLogDTOList.isEmpty()) {
            return null;
        }
        List<OptLog> optLogList = new ArrayList<OptLog>(optLogDTOList.size());
        for (OptLogDTO optLogDTO : optLogDTOList) {
            optLogList.add(toOptLog(optLogDTO));
        }
        return optLogList;
    }

    public static QueryResultODTO<OptLogODTO> toQueryResult(QueryResultODTO<OptLog> queryResult) {
        QueryResultODTO<OptLogODTO> queryResultInfo = new QueryResultODTO<OptLogODTO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toOptLogODTOList(queryResult.getRecords()));
        return queryResultInfo;
        }
}