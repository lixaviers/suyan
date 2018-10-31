package com.suyan.user.model;

import java.util.Date;
import java.util.List;

public class User {

    public static final String ID = "主键id";
    public static final String OPEN_ID = " 用户openId";
    public static final String USER_NAME = "用户名";
    public static final String NICK_NAME = "昵称";
    public static final String USER_PWD = "密码";
    public static final String MOBILE = "手机号";
    public static final String MAIL = "邮箱";
    public static final String HEAD_IMG = "头像";
    public static final String USER_STATUS = "状态";
    public static final String BIRTHDAY = "生日";
    public static final String SEX = "性别 0.男 1.女";
    public static final String IS_ADMIN = "是否管理员 1.是 0.否";
    public static final String CREATE_TIME = "创建时间";
    public static final String CREATE_USER = "创建人";
    public static final String CREATE_USER_NAME = "创建人名称";
    public static final String UPDATE_TIME = "更新时间";
    public static final String UPDATE_USER = "修改人";
    public static final String UPDATE_USER_NAME = "修改人名称";
    public static final String IS_DELETED = "是否删除：0.未删除，1.已删除";


    /**
     * 主键id
     */
    private Long id;

    /**
     *  用户openId
     */
    private String openId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 密码
     */
    private String userPwd;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 头像
     */
    private String headImg;

    /**
     * 状态
     */
    private Byte userStatus;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 性别 0.男 1.女
     */
    private Boolean sex;

    /**
     * 是否管理员 1.是 0.否
     */
    private Boolean isAdmin;

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

    public String getOpenId(){
        return openId;
    }
    
    public void setOpenId(String openId){
        this.openId = openId;
    }

    public String getUserName(){
        return userName;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getNickName(){
        return nickName;
    }
    
    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    public String getUserPwd(){
        return userPwd;
    }
    
    public void setUserPwd(String userPwd){
        this.userPwd = userPwd;
    }

    public String getMobile(){
        return mobile;
    }
    
    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    public String getMail(){
        return mail;
    }
    
    public void setMail(String mail){
        this.mail = mail;
    }

    public String getHeadImg(){
        return headImg;
    }
    
    public void setHeadImg(String headImg){
        this.headImg = headImg;
    }

    public Byte getUserStatus(){
        return userStatus;
    }
    
    public void setUserStatus(Byte userStatus){
        this.userStatus = userStatus;
    }

    public Date getBirthday(){
        return birthday;
    }
    
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }

    public Boolean getSex(){
        return sex;
    }
    
    public void setSex(Boolean sex){
        this.sex = sex;
    }

    public Boolean getIsAdmin(){
        return isAdmin;
    }
    
    public void setIsAdmin(Boolean isAdmin){
        this.isAdmin = isAdmin;
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

    public Boolean getIsDeleted(){
        return isDeleted;
    }
    
    public void setIsDeleted(Boolean isDeleted){
        this.isDeleted = isDeleted;
    }

    /**
    * The following custom property definition
    */

    private List<Integer> roleIdList;

    public List<Integer> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Integer> roleIdList) {
        this.roleIdList = roleIdList;
    }
}