package com.suyan.user.vo;

import com.suyan.user.vo.base.QueryVO;

import java.util.Date;
import java.util.List;

public class RoleQueryVO extends QueryVO {
    /**
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;

    private Integer id;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    
    private List<Integer> idList;

    public List<Integer> getIdList(){
        return idList;
    }
    public void setIdList(List<Integer> idList){
        this.idList = idList;
    }
    

    private String roleName;

    public String getRoleName(){
        return roleName;
    }
    public void setRoleName(String roleName){
        this.roleName = roleName;
    }
    
    
    private String roleNameLike;

    public String getRoleNameLike(){
        return roleNameLike;
    }
    public void setRoleNameLike(String roleNameLike){
        this.roleNameLike = roleNameLike;
    }

    private String roleCode;

    public String getRoleCode(){
        return roleCode;
    }
    public void setRoleCode(String roleCode){
        this.roleCode = roleCode;
    }
    
    
    private String roleCodeLike;

    public String getRoleCodeLike(){
        return roleCodeLike;
    }
    public void setRoleCodeLike(String roleCodeLike){
        this.roleCodeLike = roleCodeLike;
    }

    private Integer parentId;

    public Integer getParentId(){
        return parentId;
    }
    public void setParentId(Integer parentId){
        this.parentId = parentId;
    }
    
    private List<Integer> parentIdList;

    public List<Integer> getParentIdList(){
        return parentIdList;
    }
    public void setParentIdList(List<Integer> parentIdList){
        this.parentIdList = parentIdList;
    }
    

    private Integer systemId;

    public Integer getSystemId(){
        return systemId;
    }
    public void setSystemId(Integer systemId){
        this.systemId = systemId;
    }
    
    private List<Integer> systemIdList;

    public List<Integer> getSystemIdList(){
        return systemIdList;
    }
    public void setSystemIdList(List<Integer> systemIdList){
        this.systemIdList = systemIdList;
    }
    

    private Integer sortNumber;

    public Integer getSortNumber(){
        return sortNumber;
    }
    public void setSortNumber(Integer sortNumber){
        this.sortNumber = sortNumber;
    }
    
    private List<Integer> sortNumberList;

    public List<Integer> getSortNumberList(){
        return sortNumberList;
    }
    public void setSortNumberList(List<Integer> sortNumberList){
        this.sortNumberList = sortNumberList;
    }
    

    private Boolean isCommon;

    public Boolean getIsCommon(){
        return isCommon;
    }
    public void setIsCommon(Boolean isCommon){
        this.isCommon = isCommon;
    }
    
    private List<Boolean> isCommonList;

    public List<Boolean> getIsCommonList(){
        return isCommonList;
    }
    public void setIsCommonList(List<Boolean> isCommonList){
        this.isCommonList = isCommonList;
    }
    

    
    

    private Byte roleStatus;

    public Byte getRoleStatus(){
        return roleStatus;
    }
    public void setRoleStatus(Byte roleStatus){
        this.roleStatus = roleStatus;
    }
    
    private List<Byte> roleStatusList;

    public List<Byte> getRoleStatusList(){
        return roleStatusList;
    }
    public void setRoleStatusList(List<Byte> roleStatusList){
        this.roleStatusList = roleStatusList;
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
    private Boolean isDeleted;

    public Boolean getIsDeleted(){
        return isDeleted;
    }
    public void setIsDeleted(Boolean isDeleted){
        this.isDeleted = isDeleted;
    }
    
    private List<Boolean> isDeletedList;

    public List<Boolean> getIsDeletedList(){
        return isDeletedList;
    }
    public void setIsDeletedList(List<Boolean> isDeletedList){
        this.isDeletedList = isDeletedList;
    }
    


//-----------------------------------------------------------------------
// custom property definition
}