package com.suyan.user.model;

import java.util.Date;

public class RoleResource {

    public static final String ID = "主键id";
    public static final String ROLE_ID = "角色id";
    public static final String RESOURCE_ID = "资源id";
    public static final String COMMON_STATUS = "状态";
    public static final String CREATE_USER = "创建人";
    public static final String CREATE_USER_NAME = "创建人名称";
    public static final String CREATE_TIME = "创建时间";
    public static final String UPDATE_USER = "修改人";
    public static final String UPDATE_USER_NAME = "修改人名称";
    public static final String UPDATE_TIME = "更新时间";


    /**
     * 主键id
     */
    private Long id;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 资源id
     */
    private Long resourceId;

    /**
     * 状态
     */
    private Byte commonStatus;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建人名称
     */
    private String createUserName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 修改人名称
     */
    private String updateUserName;

    /**
     * 更新时间
     */
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

    public Long getResourceId(){
        return resourceId;
    }
    
    public void setResourceId(Long resourceId){
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

    /**
    * The following custom property definition
    */

}