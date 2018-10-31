package com.suyan.mmc.req;

import com.suyan.mmc.req.base.QueryDTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CouponQueryDTO extends QueryDTO {
    
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
    private String couponName;
            
    public String getCouponName(){
        return couponName;
    }
    public void setCouponName(String couponName){
        this.couponName = couponName;
    }
    private String couponNameLike;

    public String getCouponNameLike(){
        return couponNameLike;
    }
    public void setCouponNameLike(String couponNameLike){
        this.couponNameLike = couponNameLike;
    }
    private String couponNo;
            
    public String getCouponNo(){
        return couponNo;
    }
    public void setCouponNo(String couponNo){
        this.couponNo = couponNo;
    }
    private List<String> couponNoList;

    public List<String> getCouponNoList(){
        return couponNoList;
    }
    public void setCouponNoList(List<String> couponNoList){
        this.couponNoList = couponNoList;
    }
    private String couponNoLike;

    public String getCouponNoLike(){
        return couponNoLike;
    }
    public void setCouponNoLike(String couponNoLike){
        this.couponNoLike = couponNoLike;
    }
    private Long couponPackageId;
            
    public Long getCouponPackageId(){
        return couponPackageId;
    }
    public void setCouponPackageId(Long couponPackageId){
        this.couponPackageId = couponPackageId;
    }
    private List<Long> couponPackageIdList;

    public List<Long> getCouponPackageIdList(){
        return couponPackageIdList;
    }
    public void setCouponPackageIdList(List<Long> couponPackageIdList){
        this.couponPackageIdList = couponPackageIdList;
    }
    private Byte useType;
            
    public Byte getUseType(){
        return useType;
    }
    public void setUseType(Byte useType){
        this.useType = useType;
    }
    private List<Byte> useTypeList;

    public List<Byte> getUseTypeList(){
        return useTypeList;
    }
    public void setUseTypeList(List<Byte> useTypeList){
        this.useTypeList = useTypeList;
    }
    private BigDecimal priceFrom;

    public BigDecimal getPriceFrom(){
        return priceFrom;
    }
    public void setPriceFrom(BigDecimal priceFrom){
        this.priceFrom = priceFrom;
    }
            
    private BigDecimal priceTo;

    public BigDecimal getPriceTo(){
        return priceTo;
    }
    public void setPriceTo(BigDecimal priceTo){
        this.priceTo = priceTo;
    }
    private Integer personLimit;
            
    public Integer getPersonLimit(){
        return personLimit;
    }
    public void setPersonLimit(Integer personLimit){
        this.personLimit = personLimit;
    }
    private List<Integer> personLimitList;

    public List<Integer> getPersonLimitList(){
        return personLimitList;
    }
    public void setPersonLimitList(List<Integer> personLimitList){
        this.personLimitList = personLimitList;
    }
    private Integer orderLimit;
            
    public Integer getOrderLimit(){
        return orderLimit;
    }
    public void setOrderLimit(Integer orderLimit){
        this.orderLimit = orderLimit;
    }
    private List<Integer> orderLimitList;

    public List<Integer> getOrderLimitList(){
        return orderLimitList;
    }
    public void setOrderLimitList(List<Integer> orderLimitList){
        this.orderLimitList = orderLimitList;
    }
    private Byte typeId;
            
    public Byte getTypeId(){
        return typeId;
    }
    public void setTypeId(Byte typeId){
        this.typeId = typeId;
    }
    private List<Byte> typeIdList;

    public List<Byte> getTypeIdList(){
        return typeIdList;
    }
    public void setTypeIdList(List<Byte> typeIdList){
        this.typeIdList = typeIdList;
    }
    private Date startTimeFrom;

    public Date getStartTimeFrom(){
        return startTimeFrom;
    }
    public void setStartTimeFrom(Date startTimeFrom){
        this.startTimeFrom = startTimeFrom;
    }
            
    private Date startTimeTo;

    public Date getStartTimeTo(){
        return startTimeTo;
    }
    public void setStartTimeTo(Date startTimeTo){
        this.startTimeTo = startTimeTo;
    }
    private Date endTimeFrom;

    public Date getEndTimeFrom(){
        return endTimeFrom;
    }
    public void setEndTimeFrom(Date endTimeFrom){
        this.endTimeFrom = endTimeFrom;
    }
            
    private Date endTimeTo;

    public Date getEndTimeTo(){
        return endTimeTo;
    }
    public void setEndTimeTo(Date endTimeTo){
        this.endTimeTo = endTimeTo;
    }
    private Date pendingTimeFrom;

    public Date getPendingTimeFrom(){
        return pendingTimeFrom;
    }
    public void setPendingTimeFrom(Date pendingTimeFrom){
        this.pendingTimeFrom = pendingTimeFrom;
    }
            
    private Date pendingTimeTo;

    public Date getPendingTimeTo(){
        return pendingTimeTo;
    }
    public void setPendingTimeTo(Date pendingTimeTo){
        this.pendingTimeTo = pendingTimeTo;
    }
    private Integer issueTotalAmount;
            
    public Integer getIssueTotalAmount(){
        return issueTotalAmount;
    }
    public void setIssueTotalAmount(Integer issueTotalAmount){
        this.issueTotalAmount = issueTotalAmount;
    }
    private List<Integer> issueTotalAmountList;

    public List<Integer> getIssueTotalAmountList(){
        return issueTotalAmountList;
    }
    public void setIssueTotalAmountList(List<Integer> issueTotalAmountList){
        this.issueTotalAmountList = issueTotalAmountList;
    }
    private Date issueStartTimeFrom;

    public Date getIssueStartTimeFrom(){
        return issueStartTimeFrom;
    }
    public void setIssueStartTimeFrom(Date issueStartTimeFrom){
        this.issueStartTimeFrom = issueStartTimeFrom;
    }
            
    private Date issueStartTimeTo;

    public Date getIssueStartTimeTo(){
        return issueStartTimeTo;
    }
    public void setIssueStartTimeTo(Date issueStartTimeTo){
        this.issueStartTimeTo = issueStartTimeTo;
    }
    private Date issueEndTimeFrom;

    public Date getIssueEndTimeFrom(){
        return issueEndTimeFrom;
    }
    public void setIssueEndTimeFrom(Date issueEndTimeFrom){
        this.issueEndTimeFrom = issueEndTimeFrom;
    }
            
    private Date issueEndTimeTo;

    public Date getIssueEndTimeTo(){
        return issueEndTimeTo;
    }
    public void setIssueEndTimeTo(Date issueEndTimeTo){
        this.issueEndTimeTo = issueEndTimeTo;
    }
    private BigDecimal promotionAmountFrom;

    public BigDecimal getPromotionAmountFrom(){
        return promotionAmountFrom;
    }
    public void setPromotionAmountFrom(BigDecimal promotionAmountFrom){
        this.promotionAmountFrom = promotionAmountFrom;
    }
            
    private BigDecimal promotionAmountTo;

    public BigDecimal getPromotionAmountTo(){
        return promotionAmountTo;
    }
    public void setPromotionAmountTo(BigDecimal promotionAmountTo){
        this.promotionAmountTo = promotionAmountTo;
    }
    private BigDecimal orderFullAmountFrom;

    public BigDecimal getOrderFullAmountFrom(){
        return orderFullAmountFrom;
    }
    public void setOrderFullAmountFrom(BigDecimal orderFullAmountFrom){
        this.orderFullAmountFrom = orderFullAmountFrom;
    }
            
    private BigDecimal orderFullAmountTo;

    public BigDecimal getOrderFullAmountTo(){
        return orderFullAmountTo;
    }
    public void setOrderFullAmountTo(BigDecimal orderFullAmountTo){
        this.orderFullAmountTo = orderFullAmountTo;
    }
    private BigDecimal promotionMaxAmountFrom;

    public BigDecimal getPromotionMaxAmountFrom(){
        return promotionMaxAmountFrom;
    }
    public void setPromotionMaxAmountFrom(BigDecimal promotionMaxAmountFrom){
        this.promotionMaxAmountFrom = promotionMaxAmountFrom;
    }
            
    private BigDecimal promotionMaxAmountTo;

    public BigDecimal getPromotionMaxAmountTo(){
        return promotionMaxAmountTo;
    }
    public void setPromotionMaxAmountTo(BigDecimal promotionMaxAmountTo){
        this.promotionMaxAmountTo = promotionMaxAmountTo;
    }
    private BigDecimal discountAmountFrom;

    public BigDecimal getDiscountAmountFrom(){
        return discountAmountFrom;
    }
    public void setDiscountAmountFrom(BigDecimal discountAmountFrom){
        this.discountAmountFrom = discountAmountFrom;
    }
            
    private BigDecimal discountAmountTo;

    public BigDecimal getDiscountAmountTo(){
        return discountAmountTo;
    }
    public void setDiscountAmountTo(BigDecimal discountAmountTo){
        this.discountAmountTo = discountAmountTo;
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