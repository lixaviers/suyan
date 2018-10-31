package com.suyan.user.service.impl;

import com.suyan.user.biz.UserSystemBiz;
import com.suyan.user.biz.convertor.UserSystemConvertor;
import com.suyan.user.model.UserSystem;
import com.suyan.user.req.UserSystemDTO;
import com.suyan.user.req.UserSystemQueryDTO;
import com.suyan.user.resp.UserSystemODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;
import com.suyan.user.service.IUserSystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.suyan.user.validate.UserSystemValidate.validateForCreate;
import static com.suyan.user.validate.UserSystemValidate.validateForUpdate;

/**
 * @CopyRright (c)2008-2017: <素焉信息技术有限公司>
 * @Project: <user>
 * @Comments: <Dubbo Service 用户系统管理类>
 * @jdk 1.8
 * @Author: <lixavier>
 * @email : <lixavier@163.com>
 * @Create Date: <2018-09-28>
 * @Modify Date: <2018-09-28>
 * @Version: <1.0>
 */
@Service("userSystemService")
public class UserSystemServiceImpl implements IUserSystemService {
    private final Logger logger = LoggerFactory.getLogger(UserSystemServiceImpl.class);

    @Autowired
    private UserSystemBiz userSystemBiz;

    /**
     * 
     * 删除用户系统
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param id
     * @return
     */
    @Override
    public UserResult<Integer> deleteUserSystem(Long id ){
        UserResult<Integer> result = UserResult.newSuccess();
        result.setDataMap(userSystemBiz.deleteUserSystem(id ));
        return result;
    }
    
    /**
     * 
     * 创建用户系统
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param userSystemDTO
     * @return
     */
    @Override
    public UserResult<Long> createUserSystem(UserSystemDTO userSystemDTO){
        UserResult<Long> result = UserResult.newSuccess();
        UserSystem userSystem = UserSystemConvertor.toUserSystem(userSystemDTO);
        if (!validateForCreate(userSystem, result)) {
            return result;
        }
        result.setDataMap(userSystemBiz.createUserSystem( userSystem ));
        return  result;
    }

    @Override
    public UserResult<Integer> batchCreate(List<UserSystemDTO> userSystemDTOs ) {
            UserResult<Integer> result = UserResult.newSuccess();
        List<UserSystem> items = UserSystemConvertor.toUserSystemList(userSystemDTOs);
        result.setDataMap(userSystemBiz.batchCreateUserSystem(items));
        return result;
    }

    /**
     * 
     * 更新用户系统
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param userSystemDTO
     * @return
     */
    @Override
    public UserResult<Integer> updateUserSystem(UserSystemDTO userSystemDTO){
        UserResult<Integer> result = UserResult.newSuccess();
        UserSystem userSystem = null;
        userSystem = UserSystemConvertor.toUserSystem(userSystemDTO);
        if (!validateForUpdate(userSystem, result)) {
            return result;
        }
        result.setDataMap(userSystemBiz.updateUserSystem( userSystem ));
        return result;
    }
    
    /**
     * 
     * 根据ID获取用户系统信息
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param id
     * @return
     */
    @Override
    public UserResult<UserSystemODTO> getUserSystem(Long id ){
        UserResult<UserSystemODTO> result  = UserResult.newSuccess();
        UserSystem userSystem = userSystemBiz.getUserSystem( id );
        UserSystemODTO userSystemODTO = UserSystemConvertor.toUserSystemODTO(userSystem);
        result.setDataMap(userSystemODTO);
        return result;
    }

    /**
     * 
     * 分页查询用户系统信息
     * 
     * @Author: <lixavier@163.com>
     * @Version: <1.0>
     * @param userSystemQueryDTO
     * @return
     */
    @Override
    public UserResult<QueryResultODTO<UserSystemODTO>> queryUserSystem(UserSystemQueryDTO userSystemQueryDTO) {
        UserResult<QueryResultODTO<UserSystemODTO>> result = UserResult.newSuccess();

        QueryResultODTO<UserSystem> resultInfo = userSystemBiz.queryUserSystem(userSystemQueryDTO);
        result.setDataMap(UserSystemConvertor.toQueryResult(resultInfo));

        return result;
    }
}