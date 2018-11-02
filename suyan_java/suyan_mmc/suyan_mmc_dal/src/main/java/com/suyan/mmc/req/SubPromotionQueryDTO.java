package com.suyan.mmc.req;

import com.suyan.common.req.QueryDTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SubPromotionQueryDTO extends QueryDTO {
    
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
    private Byte promotionStatus;
            
    public Byte getPromotionStatus(){
        return promotionStatus;
    }
    public void setPromotionStatus(Byte promotionStatus){
        this.promotionStatus = promotionStatus;
    }
    private List<Byte> promotionStatusList;

    public List<Byte> getPromotionStatusList(){
        return promotionStatusList;
    }
    public void setPromotionStatusList(List<Byte> promotionStatusList){
        this.promotionStatusList = promotionStatusList;
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

    /**
    * The following custom property definition
    */
}