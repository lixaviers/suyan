package com.suyan.user.vo;

import com.suyan.user.vo.base.QueryVO;

import java.util.Date;
import java.util.List;

public class SystemQueryVO extends QueryVO {
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

    private String sysCode;

    public String getSysCode(){
        return sysCode;
    }
    public void setSysCode(String sysCode){
        this.sysCode = sysCode;
    }
    
    private List<String> sysCodeList;

    public List<String> getSysCodeList(){
        return sysCodeList;
    }
    public void setSysCodeList(List<String> sysCodeList){
        this.sysCodeList = sysCodeList;
    }
    
    private String sysCodeLike;

    public String getSysCodeLike(){
        return sysCodeLike;
    }
    public void setSysCodeLike(String sysCodeLike){
        this.sysCodeLike = sysCodeLike;
    }

    private String serviceId;

    public String getServiceId(){
        return serviceId;
    }
    public void setServiceId(String serviceId){
        this.serviceId = serviceId;
    }
    
    private List<String> serviceIdList;

    public List<String> getServiceIdList(){
        return serviceIdList;
    }
    public void setServiceIdList(List<String> serviceIdList){
        this.serviceIdList = serviceIdList;
    }
    
    private String serviceIdLike;

    public String getServiceIdLike(){
        return serviceIdLike;
    }
    public void setServiceIdLike(String serviceIdLike){
        this.serviceIdLike = serviceIdLike;
    }

    private String path;

    public String getPath(){
        return path;
    }
    public void setPath(String path){
        this.path = path;
    }
    
    private List<String> pathList;

    public List<String> getPathList(){
        return pathList;
    }
    public void setPathList(List<String> pathList){
        this.pathList = pathList;
    }
    
    private String pathLike;

    public String getPathLike(){
        return pathLike;
    }
    public void setPathLike(String pathLike){
        this.pathLike = pathLike;
    }

    
    

    
    

    private Byte sysStatus;

    public Byte getSysStatus(){
        return sysStatus;
    }
    public void setSysStatus(Byte sysStatus){
        this.sysStatus = sysStatus;
    }
    
    private List<Byte> sysStatusList;

    public List<Byte> getSysStatusList(){
        return sysStatusList;
    }
    public void setSysStatusList(List<Byte> sysStatusList){
        this.sysStatusList = sysStatusList;
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