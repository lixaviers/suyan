package com.suyan.mmc.req;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CouponDTO implements Serializable {
    /**
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;

            
    /**
     * 主键id
     */
    private Long id;
            
    /**
     * 优惠券名称
     */
    private String couponName;
            
    /**
     * 优惠券编码
     */
    private String couponNo;
            
    /**
     * 券包id
     */
    private Long couponPackageId;
            
    /**
     * 使用类型 1.免费 2.付费
     */
    private Byte useType;
            
    /**
     * 价格
     */
    private BigDecimal price;
            
    /**
     * 每人可领张数/券包包含数量
     */
    private Integer personLimit;
            
    /**
     * 订单可以使用张数
     */
    private Integer orderLimit;
            
    /**
     * 优惠券类型
     */
    private Byte typeId;
            
    /**
     * 生效时间
     */
    private Date startTime;
            
    /**
     * 失效时间
     */
    private Date endTime;
            
    /**
     * 预热时间
     */
    private Date pendingTime;
            
    /**
     * 发券总数量
     */
    private Integer issueTotalAmount;
            
    /**
     * 发券开始时间
     */
    private Date issueStartTime;
            
    /**
     * 发券结束时间
     */
    private Date issueEndTime;
            
    /**
     * 促销金额
     */
    private BigDecimal promotionAmount;
            
    /**
     * 订单满金额
     */
    private BigDecimal orderFullAmount;
            
    /**
     * 促销封顶金额
     */
    private BigDecimal promotionMaxAmount;
            
    /**
     * 折扣金额
     */
    private BigDecimal discountAmount;
            
    /**
     * 优惠券状态
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
     * 创建人名称
     */
    private String createUserName;
            
    /**
     * 更新时间
     */
    private Date updateTime;
            
    /**
     * 更新人
     */
    private String updateUser;
            
    /**
     * 更新人名称
     */
    private String updateUserName;
            
    /**
     * 删除：1.已删除，0.未删除
     */
    private Boolean isDeleted;
        
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public String getCouponName(){
        return couponName;
    }
    
    public void setCouponName(String couponName){
        this.couponName = couponName;
    }
    
    public String getCouponNo(){
        return couponNo;
    }
    
    public void setCouponNo(String couponNo){
        this.couponNo = couponNo;
    }
    
    public Long getCouponPackageId(){
        return couponPackageId;
    }
    
    public void setCouponPackageId(Long couponPackageId){
        this.couponPackageId = couponPackageId;
    }
    
    public Byte getUseType(){
        return useType;
    }
    
    public void setUseType(Byte useType){
        this.useType = useType;
    }
    
    public BigDecimal getPrice(){
        return price;
    }
    
    public void setPrice(BigDecimal price){
        this.price = price;
    }
    
    public Integer getPersonLimit(){
        return personLimit;
    }
    
    public void setPersonLimit(Integer personLimit){
        this.personLimit = personLimit;
    }
    
    public Integer getOrderLimit(){
        return orderLimit;
    }
    
    public void setOrderLimit(Integer orderLimit){
        this.orderLimit = orderLimit;
    }
    
    public Byte getTypeId(){
        return typeId;
    }
    
    public void setTypeId(Byte typeId){
        this.typeId = typeId;
    }
    
    public Date getStartTime(){
        return startTime;
    }
    
    public void setStartTime(Date startTime){
        this.startTime = startTime;
    }
    
    public Date getEndTime(){
        return endTime;
    }
    
    public void setEndTime(Date endTime){
        this.endTime = endTime;
    }
    
    public Date getPendingTime(){
        return pendingTime;
    }
    
    public void setPendingTime(Date pendingTime){
        this.pendingTime = pendingTime;
    }
    
    public Integer getIssueTotalAmount(){
        return issueTotalAmount;
    }
    
    public void setIssueTotalAmount(Integer issueTotalAmount){
        this.issueTotalAmount = issueTotalAmount;
    }
    
    public Date getIssueStartTime(){
        return issueStartTime;
    }
    
    public void setIssueStartTime(Date issueStartTime){
        this.issueStartTime = issueStartTime;
    }
    
    public Date getIssueEndTime(){
        return issueEndTime;
    }
    
    public void setIssueEndTime(Date issueEndTime){
        this.issueEndTime = issueEndTime;
    }
    
    public BigDecimal getPromotionAmount(){
        return promotionAmount;
    }
    
    public void setPromotionAmount(BigDecimal promotionAmount){
        this.promotionAmount = promotionAmount;
    }
    
    public BigDecimal getOrderFullAmount(){
        return orderFullAmount;
    }
    
    public void setOrderFullAmount(BigDecimal orderFullAmount){
        this.orderFullAmount = orderFullAmount;
    }
    
    public BigDecimal getPromotionMaxAmount(){
        return promotionMaxAmount;
    }
    
    public void setPromotionMaxAmount(BigDecimal promotionMaxAmount){
        this.promotionMaxAmount = promotionMaxAmount;
    }
    
    public BigDecimal getDiscountAmount(){
        return discountAmount;
    }
    
    public void setDiscountAmount(BigDecimal discountAmount){
        this.discountAmount = discountAmount;
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
}