package com.suyan.mmc.resp;

import java.io.Serializable;
import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel("状态记录")
public class StatusLogODTO implements Serializable {

    /**   
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Long id;

    /**
     * 类型  1.优惠券 2.订单促销
     */
    @ApiModelProperty("类型  1.优惠券 2.订单促销")
    private Byte type;

    /**
     * 实体ID
     */
    @ApiModelProperty("实体ID")
    private Long entityId;

    /**
     * 原状态
     */
    @ApiModelProperty("原状态")
    private Byte oldStatus;

    /**
     * 新状态
     */
    @ApiModelProperty("新状态")
    private Byte newStatus;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;

    /**
     * 操作者ID
     */
    @ApiModelProperty("操作者ID")
    private String operationUser;

    /**
     * 操作者名称
     */
    @ApiModelProperty("操作者名称")
    private String operationUserName;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String comments;


    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public Byte getType(){
        return type;
    }
    public void setType(Byte type){
        this.type = type;
    }

    public Long getEntityId(){
        return entityId;
    }
    public void setEntityId(Long entityId){
        this.entityId = entityId;
    }

    public Byte getOldStatus(){
        return oldStatus;
    }
    public void setOldStatus(Byte oldStatus){
        this.oldStatus = oldStatus;
    }

    public Byte getNewStatus(){
        return newStatus;
    }
    public void setNewStatus(Byte newStatus){
        this.newStatus = newStatus;
    }

    public Date getCreateTime(){
        return createTime;
    }
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Date getUpdateTime(){
        return updateTime;
    }
    public void setUpdateTime(Date updateTime){
        this.updateTime = updateTime;
    }

    public String getOperationUser(){
        return operationUser;
    }
    public void setOperationUser(String operationUser){
        this.operationUser = operationUser;
    }

    public String getOperationUserName(){
        return operationUserName;
    }
    public void setOperationUserName(String operationUserName){
        this.operationUserName = operationUserName;
    }

    public String getComments(){
        return comments;
    }
    public void setComments(String comments){
        this.comments = comments;
    }

    /**
    * The following custom property definition
    */
}