package com.suyan.mmc.resp;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel("订单促销")
public class SubPromotionODTO implements Serializable {

    /**   
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;


    /**
     * 订单促销id
     */
    @ApiModelProperty("订单促销id")
    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private Byte typeId;

    /**
     * 开始时间
     */
    @ApiModelProperty("开始时间")
    private Date startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    private Date endTime;

    /**
     * 促销金额
     */
    @ApiModelProperty("促销金额")
    private BigDecimal promotionAmount;

    /**
     * 订单满金额
     */
    @ApiModelProperty("订单满金额")
    private BigDecimal orderFullAmount;

    /**
     * 促销封顶金额
     */
    @ApiModelProperty("促销封顶金额")
    private BigDecimal promotionMaxAmount;

    /**
     * 折扣金额
     */
    @ApiModelProperty("折扣金额")
    private BigDecimal discountAmount;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private Byte promotionStatus;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String createUser;

    /**
     * 创建人名称
     */
    @ApiModelProperty("创建人名称")
    private String createUserName;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 修改人
     */
    @ApiModelProperty("修改人")
    private String updateUser;

    /**
     * 更新人名称
     */
    @ApiModelProperty("更新人名称")
    private String updateUserName;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 是否删除：0.未删除，1.已删除
     */
    @ApiModelProperty("是否删除：0.未删除，1.已删除")
    private Boolean isDeleted;


    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
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

    public Byte getPromotionStatus(){
        return promotionStatus;
    }
    public void setPromotionStatus(Byte promotionStatus){
        this.promotionStatus = promotionStatus;
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

    public Date getCreateTime(){
        return createTime;
    }
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
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

    public Date getUpdateTime(){
        return updateTime;
    }
    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
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




    /**
     * 状态描述
     */
    @ApiModelProperty("状态描述")
    private String promotionStatusDesc;

    /**
     * 类型描述
     */
    @ApiModelProperty("类型描述")
    private String typeDesc;

    public String getPromotionStatusDesc() {
        return promotionStatusDesc;
    }

    public void setPromotionStatusDesc(String promotionStatusDesc) {
        this.promotionStatusDesc = promotionStatusDesc;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }
}