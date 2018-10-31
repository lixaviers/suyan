package com.suyan.user.vo;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel("角色资源")
public class RoleResourceVO implements Serializable {
    /**
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;

        
    @ApiModelProperty("主键id")
    private Long id;
        
    @ApiModelProperty("角色id")
    private Integer roleId;
        
    @ApiModelProperty("资源id")
    private Integer resourceId;
        
    @ApiModelProperty("状态")
    private Byte commonStatus;
        
    @ApiModelProperty("创建人")
    private String createUser;
        
    @ApiModelProperty("创建人名称")
    private String createUserName;
        
    @ApiModelProperty("创建时间")
    private Date createTime;
        
    @ApiModelProperty("修改人")
    private String updateUser;
        
    @ApiModelProperty("修改人名称")
    private String updateUserName;
        
    @ApiModelProperty("更新时间")
    private Date updateTime;
    

    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }

    public Integer getRoleId(){
        return roleId;
    }
    
    public void setRoleId(Integer roleId){
        this.roleId = roleId;
    }

    public Integer getResourceId(){
        return resourceId;
    }
    
    public void setResourceId(Integer resourceId){
        this.resourceId = resourceId;
    }

    public Byte getCommonStatus(){
        return commonStatus;
    }
    
    public void setCommonStatus(Byte commonStatus){
        this.commonStatus = commonStatus;
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

    public Date getCreateTime(){
        return createTime;
    }
    
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
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

    public Date getUpdateTime(){
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }

    //-----------------------------------------------------------------------
    // custom property definition
}