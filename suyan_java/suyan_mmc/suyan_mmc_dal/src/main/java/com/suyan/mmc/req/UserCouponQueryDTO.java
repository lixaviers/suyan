package com.suyan.mmc.req;

import com.suyan.mmc.req.base.QueryDTO;

import java.util.Date;
import java.util.List;

public class UserCouponQueryDTO extends QueryDTO {
    
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
    private Long couponId;
            
    public Long getCouponId(){
        return couponId;
    }
    public void setCouponId(Long couponId){
        this.couponId = couponId;
    }
    private List<Long> couponIdList;

    public List<Long> getCouponIdList(){
        return couponIdList;
    }
    public void setCouponIdList(List<Long> couponIdList){
        this.couponIdList = couponIdList;
    }
    private String couponCode;
            
    public String getCouponCode(){
        return couponCode;
    }
    public void setCouponCode(String couponCode){
        this.couponCode = couponCode;
    }
    private List<String> couponCodeList;

    public List<String> getCouponCodeList(){
        return couponCodeList;
    }
    public void setCouponCodeList(List<String> couponCodeList){
        this.couponCodeList = couponCodeList;
    }
    private String couponCodeLike;

    public String getCouponCodeLike(){
        return couponCodeLike;
    }
    public void setCouponCodeLike(String couponCodeLike){
        this.couponCodeLike = couponCodeLike;
    }
    private String userOpenId;
            
    public String getUserOpenId(){
        return userOpenId;
    }
    public void setUserOpenId(String userOpenId){
        this.userOpenId = userOpenId;
    }
    private List<String> userOpenIdList;

    public List<String> getUserOpenIdList(){
        return userOpenIdList;
    }
    public void setUserOpenIdList(List<String> userOpenIdList){
        this.userOpenIdList = userOpenIdList;
    }
    private String userOpenIdLike;

    public String getUserOpenIdLike(){
        return userOpenIdLike;
    }
    public void setUserOpenIdLike(String userOpenIdLike){
        this.userOpenIdLike = userOpenIdLike;
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
    private String orderNo;
            
    public String getOrderNo(){
        return orderNo;
    }
    public void setOrderNo(String orderNo){
        this.orderNo = orderNo;
    }
    private List<String> orderNoList;

    public List<String> getOrderNoList(){
        return orderNoList;
    }
    public void setOrderNoList(List<String> orderNoList){
        this.orderNoList = orderNoList;
    }
    private String orderNoLike;

    public String getOrderNoLike(){
        return orderNoLike;
    }
    public void setOrderNoLike(String orderNoLike){
        this.orderNoLike = orderNoLike;
    }
    private Byte couponStatus;
            
    public Byte getCouponStatus(){
        return couponStatus;
    }
    public void setCouponStatus(Byte couponStatus){
        this.couponStatus = couponStatus;
    }
    private List<Byte> couponStatusList;

    public List<Byte> getCouponStatusList(){
        return couponStatusList;
    }
    public void setCouponStatusList(List<Byte> couponStatusList){
        this.couponStatusList = couponStatusList;
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

    /**
    * The following custom property definition
    */
}