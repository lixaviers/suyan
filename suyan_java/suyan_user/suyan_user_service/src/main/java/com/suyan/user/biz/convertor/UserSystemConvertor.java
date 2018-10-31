package com.suyan.user.biz.convertor;

import com.suyan.user.model.UserSystem;
import com.suyan.user.req.UserSystemDTO;
import com.suyan.user.resp.UserSystemODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <Dubbo层用户系统转换类 Dubbo层的Info对象与dal层的model对象相互转换>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
public abstract class UserSystemConvertor {

    private static final BeanCopier beanCopierForUserSystemODTO = BeanCopier.create(UserSystem.class, UserSystemODTO.class, false);
    private static final BeanCopier beanCopierForUserSystem = BeanCopier.create(UserSystemDTO.class, UserSystem.class, false);

    public static UserSystemODTO toUserSystemODTO(UserSystem userSystem) {
        if (userSystem == null) {
            return null;
        }
        UserSystemODTO userSystemODTO = new UserSystemODTO();
        beanCopierForUserSystemODTO.copy(userSystem, userSystemODTO, null);
        return userSystemODTO;
    }

    public static UserSystem toUserSystem(UserSystemDTO userSystemDTO) {
        UserSystem userSystem = new UserSystem();
        beanCopierForUserSystem.copy(userSystemDTO, userSystem, null);
        return userSystem;
    }

    public static List<UserSystemODTO> toUserSystemODTOList(List<UserSystem> userSystemList) {
        if (userSystemList == null || userSystemList.isEmpty()) {
            return null;
        }
        List<UserSystemODTO> userSystemInfoList = new ArrayList<UserSystemODTO>(userSystemList.size());
        for (UserSystem userSystem : userSystemList) {
            userSystemInfoList.add(toUserSystemODTO(userSystem));
        }
        return userSystemInfoList;
    }

    public static List<UserSystem> toUserSystemList(List<UserSystemDTO> userSystemDTOList) {
        if (userSystemDTOList == null || userSystemDTOList.isEmpty()) {
            return null;
        }
        List<UserSystem> userSystemList = new ArrayList<UserSystem>(userSystemDTOList.size());
        for (UserSystemDTO userSystemDTO : userSystemDTOList) {
            userSystemList.add(toUserSystem(userSystemDTO));
        }
        return userSystemList;
    }

    public static QueryResultODTO<UserSystemODTO> toQueryResult(QueryResultODTO<UserSystem> queryResult) {
        QueryResultODTO<UserSystemODTO> queryResultInfo = new QueryResultODTO<UserSystemODTO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toUserSystemODTOList(queryResult.getRecords()));
        return queryResultInfo;
        }
}