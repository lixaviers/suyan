package com.suyan.user.resp;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.List;

public class NavODTO {
    @ApiModelProperty("菜单列表")
    private List<ResourceODTO> menuList;

    private Boolean isAdmin;

    @ApiModelProperty("权限列表")
    private List<String> permissions;

    public List<ResourceODTO> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<ResourceODTO> menuList) {
        this.menuList = menuList;
    }

    public Boolean getIsAdmin(){
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin){
        this.isAdmin = isAdmin;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
