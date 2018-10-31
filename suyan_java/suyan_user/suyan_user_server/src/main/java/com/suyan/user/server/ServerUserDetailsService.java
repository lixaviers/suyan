package com.suyan.user.server;

import com.suyan.user.constant.UserStatusEnum;
import com.suyan.user.resp.RoleODTO;
import com.suyan.user.resp.UserODTO;
import com.suyan.user.result.UserResult;
import com.suyan.user.service.IRoleService;
import com.suyan.user.service.IUserService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServerUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserResult<UserODTO> result = userService.getUserByUserName(username);
        if (result == null || !result.isSuccess() || result.getDataMap() == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        UserODTO user = result.getDataMap();

        // 账户没有过期
        boolean accountNonExpired = true;
        // 账户没被锁定 （是否冻结）
        boolean accountNonLocked = UserStatusEnum.NORMAL.equal(user.getUserStatus()) ? true : false;
        // 密码没有过期
        boolean credentialsNonExpired = true;
        // 账户是否可用（是否被删除）
        boolean enabled = !user.getIsDeleted();

        UserResult<List<RoleODTO>> roleResult = roleService.getRolesByUserOpenId(user.getOpenId());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (roleResult != null && roleResult.isSuccess() && CollectionUtils.isNotEmpty(roleResult.getDataMap())) {
            for (RoleODTO role : roleResult.getDataMap()) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleCode()));
            }
        }


        return new User(user.getOpenId(), user.getUserPwd(),
                accountNonExpired, accountNonLocked, credentialsNonExpired, enabled, authorities);
    }
}
