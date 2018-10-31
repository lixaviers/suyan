package com.suyan.user.req;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserDTO implements Serializable {
    /**
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;

            
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

    private List<RoleDTO> roleList;
    private List<Integer> roleIdList;

    public List<RoleDTO> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleDTO> roleList) {
        this.roleList = roleList;
    }

    public List<Integer> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Integer> roleIdList) {
        this.roleIdList = roleIdList;
    }
}