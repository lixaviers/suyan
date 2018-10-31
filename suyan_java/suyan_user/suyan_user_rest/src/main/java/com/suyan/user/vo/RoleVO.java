package com.suyan.user.vo;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel("角色")
public class RoleVO implements Serializable {
    /**
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;

        
    @ApiModelProperty("主键id")
    private Integer id;
        
    @ApiModelProperty("角色名")
    private String roleName;
        
    @ApiModelProperty("角色编码")
    private String roleCode;
        
    @ApiModelProperty("父类id")
    private Integer parentId;
        
    @ApiModelProperty("系统id")
    private Integer systemId;
        
    @ApiModelProperty("排序数")
    private Integer sortNumber;
        
    @ApiModelProperty("是否通用 1.是 0.否")
    private Boolean isCommon;
        
    @ApiModelProperty("描述")
    private String description;
        
    @ApiModelProperty("角色状态")
    private Byte roleStatus;
        
    @ApiModelProperty("创建人")
    private String createUser;
        
    @ApiModelProperty("创建人名称")
    private String createUserName;
        
    @ApiModelProperty("修改人")
    private String updateUser;
        
    @ApiModelProperty("更新人名称")
    private String updateUserName;
        

    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }

    public String getRoleName(){
        return roleName;
    }
    
    public void setRoleName(String roleName){
        this.roleName = roleName;
    }

    public String getRoleCode(){
        return roleCode;
    }
    
    public void setRoleCode(String roleCode){
        this.roleCode = roleCode;
    }

    public Integer getParentId(){
        return parentId;
    }
    
    public void setParentId(Integer parentId){
        this.parentId = parentId;
    }

    public Integer getSystemId(){
        return systemId;
    }
    
    public void setSystemId(Integer systemId){
        this.systemId = systemId;
    }

    public Integer getSortNumber(){
        return sortNumber;
    }
    
    public void setSortNumber(Integer sortNumber){
        this.sortNumber = sortNumber;
    }

    public Boolean getIsCommon(){
        return isCommon;
    }
    
    public void setIsCommon(Boolean isCommon){
        this.isCommon = isCommon;
    }

    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }

    public Byte getRoleStatus(){
        return roleStatus;
    }
    
    public void setRoleStatus(Byte roleStatus){
        this.roleStatus = roleStatus;
    }

    public String getCreateUser(){
        return createUser;
    }
    
    public void setCreateUser(String createUser){
        this.createUser = createUser;
    }

    public String getCreateUserName(){
        return createUserName;
    }
    
    public void setCreateUserName(String createUserName){
        this.createUserName = createUserName;
    }

    public String getUpdateUser(){
        return updateUser;
    }
    
    public void setUpdateUser(String updateUser){
        this.updateUser = updateUser;
    }

    public String getUpdateUserName(){
        return updateUserName;
    }
    
    public void setUpdateUserName(String updateUserName){
        this.updateUserName = updateUserName;
    }


    //-----------------------------------------------------------------------
    // custom property definition

    private List<ResourceVO> resourceList;
    private List<Long> resourceIdList;

    public List<ResourceVO> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<ResourceVO> resourceList) {
        this.resourceList = resourceList;
    }

    public List<Long> getResourceIdList() {
        return resourceIdList;
    }

    public void setResourceIdList(List<Long> resourceIdList) {
        this.resourceIdList = resourceIdList;
    }
}