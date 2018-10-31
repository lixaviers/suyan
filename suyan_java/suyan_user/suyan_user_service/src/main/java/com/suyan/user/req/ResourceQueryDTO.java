package com.suyan.user.req;

import com.suyan.user.req.base.QueryDTO;

import java.util.Date;
import java.util.List;

public class ResourceQueryDTO extends QueryDTO {
    
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
    private String name;
            
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    private String nameLike;

    public String getNameLike(){
        return nameLike;
    }
    public void setNameLike(String nameLike){
        this.nameLike = nameLike;
    }
    private String resourceCode;
            
    public String getResourceCode(){
        return resourceCode;
    }
    public void setResourceCode(String resourceCode){
        this.resourceCode = resourceCode;
    }
    private String resourceCodeLike;

    public String getResourceCodeLike(){
        return resourceCodeLike;
    }
    public void setResourceCodeLike(String resourceCodeLike){
        this.resourceCodeLike = resourceCodeLike;
    }
    private Long parentId;
            
    public Long getParentId(){
        return parentId;
    }
    public void setParentId(Long parentId){
        this.parentId = parentId;
    }
    private List<Long> parentIdList;

    public List<Long> getParentIdList(){
        return parentIdList;
    }
    public void setParentIdList(List<Long> parentIdList){
        this.parentIdList = parentIdList;
    }
    private Byte type;
            
    public Byte getType(){
        return type;
    }
    public void setType(Byte type){
        this.type = type;
    }
    private List<Byte> typeList;

    public List<Byte> getTypeList(){
        return typeList;
    }
    public void setTypeList(List<Byte> typeList){
        this.typeList = typeList;
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
    private Boolean isGlobal;
            
    public Boolean getIsGlobal(){
        return isGlobal;
    }
    public void setIsGlobal(Boolean isGlobal){
        this.isGlobal = isGlobal;
    }
    private List<Boolean> isGlobalList;

    public List<Boolean> getIsGlobalList(){
        return isGlobalList;
    }
    public void setIsGlobalList(List<Boolean> isGlobalList){
        this.isGlobalList = isGlobalList;
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

    /**
    * The following custom property definition
    */
}