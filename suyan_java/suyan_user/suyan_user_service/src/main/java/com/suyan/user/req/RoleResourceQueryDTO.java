package com.suyan.user.req;

import com.suyan.user.req.base.QueryDTO;

import java.util.Date;
import java.util.List;

public class RoleResourceQueryDTO extends QueryDTO {
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private Long id;
            
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    private List<Long> idList;

    public List<Long> getIdList(){
        return idList;
    }
    public void setIdList(List<Long> idList){
        this.idList = idList;
    }
    private Integer roleId;
            
    public Integer getRoleId(){
        return roleId;
    }
    public void setRoleId(Integer roleId){
        this.roleId = roleId;
    }
    private List<Integer> roleIdList;

    public List<Integer> getRoleIdList(){
        return roleIdList;
    }
    public void setRoleIdList(List<Integer> roleIdList){
        this.roleIdList = roleIdList;
    }
    private Long resourceId;
            
    public Long getResourceId(){
        return resourceId;
    }
    public void setResourceId(Long resourceId){
        this.resourceId = resourceId;
    }
    private List<Long> resourceIdList;

    public List<Long> getResourceIdList(){
        return resourceIdList;
    }
    public void setResourceIdList(List<Long> resourceIdList){
        this.resourceIdList = resourceIdList;
    }
    private Byte commonStatus;
            
    public Byte getCommonStatus(){
        return commonStatus;
    }
    public void setCommonStatus(Byte commonStatus){
        this.commonStatus = commonStatus;
    }
    private List<Byte> commonStatusList;

    public List<Byte> getCommonStatusList(){
        return commonStatusList;
    }
    public void setCommonStatusList(List<Byte> commonStatusList){
        this.commonStatusList = commonStatusList;
    }
    private String createUser;
            
    public String getCreateUser(){
        return createUser;
    }
    public void setCreateUser(String createUser){
        this.createUser = createUser;
    }
    private List<String> createUserList;

    public List<String> getCreateUserList(){
        return createUserList;
    }
    public void setCreateUserList(List<String> createUserList){
        this.createUserList = createUserList;
    }
    private String createUserLike;

    public String getCreateUserLike(){
        return createUserLike;
    }
    public void setCreateUserLike(String createUserLike){
        this.createUserLike = createUserLike;
    }
    private String createUserName;
            
    public String getCreateUserName(){
        return createUserName;
    }
    public void setCreateUserName(String createUserName){
        this.createUserName = createUserName;
    }
    private String createUserNameLike;

    public String getCreateUserNameLike(){
        return createUserNameLike;
    }
    public void setCreateUserNameLike(String createUserNameLike){
        this.createUserNameLike = createUserNameLike;
    }
    private Date createTimeFrom;

    public Date getCreateTimeFrom(){
        return createTimeFrom;
    }
    public void setCreateTimeFrom(Date createTimeFrom){
        this.createTimeFrom = createTimeFrom;
    }
            
    private Date createTimeTo;

    public Date getCreateTimeTo(){
        return createTimeTo;
    }
    public void setCreateTimeTo(Date createTimeTo){
        this.createTimeTo = createTimeTo;
    }
    private String updateUser;
            
    public String getUpdateUser(){
        return updateUser;
    }
    public void setUpdateUser(String updateUser){
        this.updateUser = updateUser;
    }
    private List<String> updateUserList;

    public List<String> getUpdateUserList(){
        return updateUserList;
    }
    public void setUpdateUserList(List<String> updateUserList){
        this.updateUserList = updateUserList;
    }
    private String updateUserLike;

    public String getUpdateUserLike(){
        return updateUserLike;
    }
    public void setUpdateUserLike(String updateUserLike){
        this.updateUserLike = updateUserLike;
    }
    private String updateUserName;
            
    public String getUpdateUserName(){
        return updateUserName;
    }
    public void setUpdateUserName(String updateUserName){
        this.updateUserName = updateUserName;
    }
    private List<String> updateUserNameList;

    public List<String> getUpdateUserNameList(){
        return updateUserNameList;
    }
    public void setUpdateUserNameList(List<String> updateUserNameList){
        this.updateUserNameList = updateUserNameList;
    }
    private String updateUserNameLike;

    public String getUpdateUserNameLike(){
        return updateUserNameLike;
    }
    public void setUpdateUserNameLike(String updateUserNameLike){
        this.updateUserNameLike = updateUserNameLike;
    }
    private Date updateTimeFrom;

    public Date getUpdateTimeFrom(){
        return updateTimeFrom;
    }
    public void setUpdateTimeFrom(Date updateTimeFrom){
        this.updateTimeFrom = updateTimeFrom;
    }
            
    private Date updateTimeTo;

    public Date getUpdateTimeTo(){
        return updateTimeTo;
    }
    public void setUpdateTimeTo(Date updateTimeTo){
        this.updateTimeTo = updateTimeTo;
    }

    /**
    * The following custom property definition
    */
}