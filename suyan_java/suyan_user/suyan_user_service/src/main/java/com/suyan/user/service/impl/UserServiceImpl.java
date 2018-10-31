package com.suyan.user.service.impl;

import com.suyan.user.biz.UserBiz;
import com.suyan.user.biz.UserRoleBiz;
import com.suyan.user.biz.convertor.UserConvertor;
import com.suyan.user.model.User;
import com.suyan.user.req.UserDTO;
import com.suyan.user.req.UserQueryDTO;
import com.suyan.user.resp.UserODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;
import com.suyan.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.suyan.user.validate.UserValidate.validateForUpdate;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <Dubbo Service 用户管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-18>
 * @Modify Date: <2018-09-18>
 * @Version: <1.0>
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserBiz userBiz;
    @Autowired
    private UserRoleBiz userRoleBiz;

    /**
     * 删除用户
     *
     * @param idList
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<Integer> deleteUser(List<Long> idList) {
        UserResult<Integer> result = UserResult.newSuccess();
        result.setDataMap(userBiz.deleteUser(idList));
        return result;
    }

    /**
     * 创建用户
     *
     * @param userDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<Long> createUser(UserDTO userDTO) {
        UserResult<Long> result = UserResult.newSuccess();
        User user = UserConvertor.toUser(userDTO);
        result.setDataMap(userBiz.createUser(user));
        return result;
    }

    /**
     * 更新用户
     *
     * @param userDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<Integer> updateUser(UserDTO userDTO) {
        UserResult<Integer> result = UserResult.newSuccess();
        User user = null;
        user = UserConvertor.toUser(userDTO);
        if (!validateForUpdate(user, result)) {
            return result;
        }
        result.setDataMap(userBiz.updateUser(user));
        return result;
    }

    /**
     * 根据ID获取用户信息
     *
     * @param id
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<UserODTO> getUser(Long id) {
        UserResult<UserODTO> result = UserResult.newSuccess();
        User user = userBiz.getUser(id);
        UserODTO userODTO = UserConvertor.toUserODTO(user);
        result.setDataMap(userODTO);
        return result;
    }

    /**
     * 分页查询用户信息
     *
     * @param userQueryDTO
     * @return
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     */
    @Override
    public UserResult<QueryResultODTO<UserODTO>> queryUser(UserQueryDTO userQueryDTO) {
        UserResult<QueryResultODTO<UserODTO>> result = UserResult.newSuccess();

        QueryResultODTO<User> resultInfo = userBiz.queryUser(userQueryDTO);
        result.setDataMap(UserConvertor.toQueryResult(resultInfo));

        return result;
    }

    @Override
    public UserResult<UserODTO> getUserByUserName(String userName) {

        UserResult<UserODTO> result = UserResult.newSuccess();
        UserODTO userODTO = UserConvertor.toUserODTO(userBiz.getUserByUserName(userName));
        result.setDataMap(userODTO);
        return result;
    }

    @Override
    public UserResult<UserODTO> getUserByOpenId(String openId) {

        UserResult<UserODTO> result = UserResult.newSuccess();
        UserODTO userODTO = UserConvertor.toUserODTO(userBiz.getUserByOpenId(openId));
        result.setDataMap(userODTO);
        return result;
    }


}