package com.suyan.user.req;

import java.io.Serializable;
import java.util.Date;

public class UserSystemDTO implements Serializable {
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
     * 系统id
     */
    private Integer systemId;
            
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
            
    /**
     * 是否删除：0.未删除，1.已删除
     */
    private Boolean isDeleted;
        
    
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
    
    public Integer getSystemId(){
        return systemId;
    }
    
    public void setSystemId(Integer systemId){
        this.systemId = systemId;
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
    
    public Boolean getIsDeleted(){
        return isDeleted;
    }
    
    public void setIsDeleted(Boolean isDeleted){
        this.isDeleted = isDeleted;
    }
    
    /**
    * The following custom property definition
    */
}