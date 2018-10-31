package com.suyan.user.req;

import com.suyan.user.req.base.QueryDTO;

import java.util.Date;
import java.util.List;

public class UserQueryDTO extends QueryDTO {
    
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
    private String openId;
            
    public String getOpenId(){
        return openId;
    }
    public void setOpenId(String openId){
        this.openId = openId;
    }
    private List<String> openIdList;

    public List<String> getOpenIdList(){
        return openIdList;
    }
    public void setOpenIdList(List<String> openIdList){
        this.openIdList = openIdList;
    }
    private String openIdLike;

    public String getOpenIdLike(){
        return openIdLike;
    }
    public void setOpenIdLike(String openIdLike){
        this.openIdLike = openIdLike;
    }
    private String userName;
            
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    private List<String> userNameList;

    public List<String> getUserNameList(){
        return userNameList;
    }
    public void setUserNameList(List<String> userNameList){
        this.userNameList = userNameList;
    }
    private String userNameLike;

    public String getUserNameLike(){
        return userNameLike;
    }
    public void setUserNameLike(String userNameLike){
        this.userNameLike = userNameLike;
    }
    private String nickName;
            
    public String getNickName(){
        return nickName;
    }
    public void setNickName(String nickName){
        this.nickName = nickName;
    }
    private String nickNameLike;

    public String getNickNameLike(){
        return nickNameLike;
    }
    public void setNickNameLike(String nickNameLike){
        this.nickNameLike = nickNameLike;
    }
    private String userPwd;
            
    public String getUserPwd(){
        return userPwd;
    }
    public void setUserPwd(String userPwd){
        this.userPwd = userPwd;
    }
    private String mobile;
            
    public String getMobile(){
        return mobile;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    private List<String> mobileList;

    public List<String> getMobileList(){
        return mobileList;
    }
    public void setMobileList(List<String> mobileList){
        this.mobileList = mobileList;
    }
    private String mobileLike;

    public String getMobileLike(){
        return mobileLike;
    }
    public void setMobileLike(String mobileLike){
        this.mobileLike = mobileLike;
    }
    private Byte userStatus;
            
    public Byte getUserStatus(){
        return userStatus;
    }
    public void setUserStatus(Byte userStatus){
        this.userStatus = userStatus;
    }
    private List<Byte> userStatusList;

    public List<Byte> getUserStatusList(){
        return userStatusList;
    }
    public void setUserStatusList(List<Byte> userStatusList){
        this.userStatusList = userStatusList;
    }
    private Date birthday;
            
    public Date getBirthday(){
        return birthday;
    }
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }
    private Boolean sex;
            
    public Boolean getSex(){
        return sex;
    }
    public void setSex(Boolean sex){
        this.sex = sex;
    }
    private List<Boolean> sexList;

    public List<Boolean> getSexList(){
        return sexList;
    }
    public void setSexList(List<Boolean> sexList){
        this.sexList = sexList;
    }
    private Boolean isAdmin;
            
    public Boolean getIsAdmin(){
        return isAdmin;
    }
    public void setIsAdmin(Boolean isAdmin){
        this.isAdmin = isAdmin;
    }
    private List<Boolean> isAdminList;

    public List<Boolean> getIsAdminList(){
        return isAdminList;
    }
    public void setIsAdminList(List<Boolean> isAdminList){
        this.isAdminList = isAdminList;
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