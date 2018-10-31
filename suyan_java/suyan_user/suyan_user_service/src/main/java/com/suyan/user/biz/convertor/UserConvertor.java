package com.suyan.user.biz.convertor;

import com.suyan.user.constant.UserStatusEnum;
import com.suyan.user.model.User;
import com.suyan.user.req.UserDTO;
import com.suyan.user.resp.UserODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <Dubbo层用户转换类 Dubbo层的Info对象与dal层的model对象相互转换>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-18>
 * @Modify Date: <2018-09-18>
 * @Version: <1.0>
 */
public abstract class UserConvertor {

    private static final BeanCopier beanCopierForUserODTO = BeanCopier.create(User.class, UserODTO.class, false);
    private static final BeanCopier beanCopierForUser = BeanCopier.create(UserDTO.class, User.class, false);

    public static UserODTO toUserODTO(User user) {
        if (user == null) {
            return null;
        }
        UserODTO userODTO = new UserODTO();
        beanCopierForUserODTO.copy(user, userODTO, null);
        userODTO.setUserStatusDesc(UserStatusEnum.getDescByValue(user.getUserStatus()));
        return userODTO;
    }

    public static User toUser(UserDTO userDTO) {
        User user = new User();
        beanCopierForUser.copy(userDTO, user, null);
        return user;
    }

    public static List<UserODTO> toUserODTOList(List<User> userList) {
        if (userList == null || userList.isEmpty()) {
            return null;
        }
        List<UserODTO> userInfoList = new ArrayList<UserODTO>(userList.size());
        for (User user : userList) {
            userInfoList.add(toUserODTO(user));
        }
        return userInfoList;
    }

    public static List<User> toUserList(List<UserDTO> userDTOList) {
        if (userDTOList == null || userDTOList.isEmpty()) {
            return null;
        }
        List<User> userList = new ArrayList<User>(userDTOList.size());
        for (UserDTO userDTO : userDTOList) {
            userList.add(toUser(userDTO));
        }
        return userList;
    }

    public static QueryResultODTO<UserODTO> toQueryResult(QueryResultODTO<User> queryResult) {
        QueryResultODTO<UserODTO> queryResultInfo = new QueryResultODTO<UserODTO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toUserODTOList(queryResult.getRecords()));
        return queryResultInfo;
        }
}