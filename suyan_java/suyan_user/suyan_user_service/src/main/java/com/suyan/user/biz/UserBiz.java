package com.suyan.user.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.user.dao.UserMapper;
import com.suyan.user.dao.ext.UserExtMapper;
import com.suyan.user.exception.CommonBizException;
import com.suyan.user.model.User;
import com.suyan.user.model.UserExample;
import com.suyan.user.req.UserQueryDTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResultCode;
import com.suyan.user.util.CodeGeneratorUtil;
import org.apache.commons.collections4.CollectionUtils;
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
 * @Comments: <业务层用户管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-18>
 * @Modify Date: <2018-09-18>
 * @Version: <1.0>
 */
@Service("userBiz")
public class UserBiz {
    private final Logger logger = LoggerFactory.getLogger(UserBiz.class);

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserExtMapper userExtMapper;

    @Autowired
    private UserRoleBiz userRoleBiz;


    /**
     * 删除用户
     *
     * @param idList
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer deleteUser(List<Long> idList) {
        if (CollectionUtils.isNotEmpty(idList)) {
            for (Long id : idList) {
                userMapper.logicalDeleteByPrimaryKey(id);
            }
        }
        return 1;
    }

    /**
     * 创建用户
     *
     * @param user
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Long createUser(User user) {

        User temp = userMapper.selectByUserName(user.getUserName());
        if (temp != null) {
            throw new CommonBizException(UserResultCode.DATA_EXIST, User.USER_NAME);
        }
        String openId = null;
        do {
            openId = CodeGeneratorUtil.generateUserOpenId();
            temp = userMapper.selectByOpenId(openId);
        } while (temp != null);

        temp = new User();
        temp.setUserName(user.getUserName());
        temp.setNickName(user.getNickName());
        temp.setUserPwd(user.getUserPwd());
        temp.setMail(user.getMail());
        temp.setMobile(user.getMobile());
        temp.setOpenId(openId);
        user.setOpenId(openId);

        temp.setCreateUser(user.getCreateUser());
        temp.setCreateUserName(user.getCreateUserName());
        temp.setUpdateUser(user.getUpdateUser());
        temp.setUpdateUserName(user.getUpdateUserName());

        userMapper.insertSelective(temp);

        userRoleBiz.authorize(user);

        return temp.getId();
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer updateUser(User user) {
        Integer result = null;
        User userLast = userMapper.selectByPrimaryKeyForUpdate(user.getId());
        if (userLast == null) {
            throw new CommonBizException(UserResultCode.DATA_NOT_EXIST, "用户");
        }
        User temp = userMapper.selectByUserName(user.getUserName());
        if (temp != null && !temp.getId().equals(user.getId())) {
            throw new CommonBizException(UserResultCode.DATA_EXIST, User.USER_NAME);
        }
        result = userMapper.updateByPrimaryKeySelective(user);
        user.setOpenId(userLast.getOpenId());
        userRoleBiz.authorize(user);
        return result;
    }

    /**
     * 根据ID获取用户信息
     *
     * @param id
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public User getUser(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null || user.getIsDeleted()) {
            throw new CommonBizException(UserResultCode.DATA_NOT_EXIST, "用户");
        }
        user.setRoleIdList(userExtMapper.getRoleIdListByUserOpenId(user.getOpenId()));
        return user;
    }

    /**
     * 分页查询用户信息
     *
     * @param userQuery
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public QueryResultODTO<User> queryUser(UserQueryDTO userQuery) {
        QueryResultODTO<User> queryResult = new QueryResultODTO<User>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(userQuery.getPageNo(), userQuery.getPageSize());
        List<User> userList = userMapper.queryUser(userQuery);
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(userList);
        return queryResult;
    }


    /**
     * 根据userName获取用户信息
     *
     * @param userName
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public User getUserByUserName(String userName) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(userName);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList != null && !userList.isEmpty()) {
            return userList.get(0);
        }
        return null;
    }

    /**
     * 根据openId获取用户信息
     *
     * @param openId
     * @return
     * @author lixavier
     * @version 1.0.0
     */
    @Transactional(readOnly = true)
    public User getUserByOpenId(String openId) {
        return userMapper.selectByOpenId(openId);
    }


}