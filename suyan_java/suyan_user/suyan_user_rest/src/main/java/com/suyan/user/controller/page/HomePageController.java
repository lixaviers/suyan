package com.suyan.user.controller.page;

import com.suyan.user.controller.BaseController;
import com.suyan.user.req.RoleQueryDTO;
import com.suyan.user.req.UserQueryDTO;
import com.suyan.user.resp.ResourceODTO;
import com.suyan.user.resp.RoleODTO;
import com.suyan.user.resp.UserODTO;
import com.suyan.user.resp.base.QueryResultODTO;
import com.suyan.user.result.UserResult;
import com.suyan.user.service.IResourceService;
import com.suyan.user.service.IRoleService;
import com.suyan.user.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class HomePageController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(HomePageController.class);

    @Autowired
    private IResourceService resourceService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IUserService userService;

    @GetMapping("/user/index")
    public String userIndex(Authentication authentication) {
        try {
            int pageNo = setPageInfo();

            UserQueryDTO userQueryDTO = new UserQueryDTO();
            userQueryDTO.setPageSize(10);
            userQueryDTO.setPageNo(pageNo);
            UserResult<QueryResultODTO<UserODTO>> result = userService.queryUser(userQueryDTO);
            request.setAttribute("result", result.getDataMap());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "user/index";
    }

    @GetMapping("/user/authorize/{userOpenId}")
    public String userAuthorize(@PathVariable String userOpenId) {
        request.setAttribute("userOpenId", userOpenId);
        return "user/authorize";
    }

    @GetMapping("/role/create")
    public String roleCreate() {
        return "role/create";
    }

    @GetMapping("/role/authorize/{id}")
    public String roleAuthorize(@PathVariable Integer id) {
        request.setAttribute("id", id);
        return "role/authorize";
    }

    @GetMapping("/role/edit/{id}")
    public String roleEdit(@PathVariable Integer id) {
        UserResult<RoleODTO> result = roleService.getRole(id);
        request.setAttribute("bean", result.getDataMap());
        return "role/edit";
    }

    @GetMapping("/role/index")
    public String roleIndex() {
        int pageNo = setPageInfo();

        try {
            RoleQueryDTO roleQueryDTO = new RoleQueryDTO();
            roleQueryDTO.setPageNo(pageNo);
            roleQueryDTO.setPageSize(10);
            roleQueryDTO.setOrder("asc");
            roleQueryDTO.setOrderBy("sort_number");
            UserResult<QueryResultODTO<RoleODTO>> result = roleService.queryRole(roleQueryDTO);
            request.setAttribute("result", result.getDataMap());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "role/index";
    }

    @GetMapping("/resource/index")
    public String resourceIndex() {
        try {
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "resource/index";
    }

    @GetMapping("/resource/create")
    public String resourceCreate() {
        request.setAttribute("id", request.getParameter("id"));
        return "resource/create";
    }

    @GetMapping("/resource/edit/{id}")
    public String resourceEdit(@PathVariable Long id) {
        try {
            UserResult<ResourceODTO> resource = resourceService.getResource(id);
            if (resource.isSuccess() && resource.getDataMap() != null) {
                request.setAttribute("bean", resource.getDataMap());
                return "resource/edit";
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return "resource/create";
    }


}
