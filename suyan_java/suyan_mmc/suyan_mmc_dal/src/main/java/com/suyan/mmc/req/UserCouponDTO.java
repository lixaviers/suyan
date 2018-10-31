package com.suyan.mmc.req;

import java.io.Serializable;
import java.util.Date;

public class UserCouponDTO implements Serializable {
    /**
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;

            
    /**
     * 主键id
     */
    private Long id;
            
    /**
     * 优惠券id
     */
    private Long couponId;
            
    /**
     * 券码
     */
    private String couponCode;
            
    /**
     * 用户openId
     */
    private String userOpenId;
            
    /**
     * 手机号
     */
    private String mobile;
            
    /**
     * 订单号
     */
    private String orderNo;
            
    /**
     * 状态
     */
    private Byte couponStatus;
            
    /**
     * 创建时间
     */
    private Date createTime;
            
    /**
     * 创建人
     */
    private String createUser;
            
    /**
     * 更新时间
     */
    private Date updateTime;
            
    /**
     * 创建人名称
     */
    private String createUserName;
            
    /**
     * 更新人
     */
    private String updateUser;
            
    /**
     * 更新人名称
     */
    private String updateUserName;
        
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public Long getCouponId(){
        return couponId;
    }
    
    public void setCouponId(Long couponId){
        this.couponId = couponId;
    }
    
    public String getCouponCode(){
        return couponCode;
    }
    
    public void setCouponCode(String couponCode){
        this.couponCode = couponCode;
    }
    
    public String getUserOpenId(){
        return userOpenId;
    }
    
    public void setUserOpenId(String userOpenId){
        this.userOpenId = userOpenId;
    }
    
    public String getMobile(){
        return mobile;
    }
    
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    
    public String getOrderNo(){
        return orderNo;
    }
    
    public void setOrderNo(String orderNo){
        this.orderNo = orderNo;
    }
    
    public Byte getCouponStatus(){
        return couponStatus;
    }
    
    public void setCouponStatus(Byte couponStatus){
        this.couponStatus = couponStatus;
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
    
    public Date getUpdateTime(){
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }
    
    public String getCreateUserName(){
        return createUserName;
    }
    
    public void setCreateUserName(String createUserName){
        this.createUserName = createUserName;
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