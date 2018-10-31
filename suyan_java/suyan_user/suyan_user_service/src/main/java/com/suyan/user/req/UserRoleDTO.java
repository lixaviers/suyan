package com.suyan.user.req;

import java.io.Serializable;
import java.util.Date;

public class UserRoleDTO implements Serializable {
    /**
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;

            
    /**
     * 主键id
     */
    private Long id;
            
    /**
     * 用户openId
     */
    private String userOpenId;
            
    /**
     * 角色id
     */
    private Integer roleId;
            
    /**
     * 状态
     */
    private Byte commonStatus;
            
    /**
     * 创建时间
     */
    private Date createTime;
            
    /**
     * 创建人
     */
    private String createUser;
            
    /**
     * 创建人名称
     */
    private String createUserName;
            
    /**
     * 更新时间
     */
    private Date updateTime;
            
    /**
     * 修改人
     */
    private String updateUser;
            
    /**
     * 修改人名称
     */
    private String updateUserName;
        
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public String getUserOpenId(){
        return userOpenId;
    }
    
    public void setUserOpenId(String userOpenId){
        this.userOpenId = userOpenId;
    }
    
    public Integer getRoleId(){
        return roleId;
    }
    
    public void setRoleId(Integer roleId){
        this.roleId = roleId;
    }
    
    public Byte getCommonStatus(){
        return commonStatus;
    }
    
    public void setCommonStatus(Byte commonStatus){
        this.commonStatus = commonStatus;
    }
    
    public Date getCreateTime(){
        return createTime;
    }
    
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
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
    
    public Date getUpdateTime(){
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
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
    
    /**
    * The following custom property definition
    */
}