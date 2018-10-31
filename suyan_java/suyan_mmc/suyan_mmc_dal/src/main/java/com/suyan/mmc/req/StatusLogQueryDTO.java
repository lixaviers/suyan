package com.suyan.mmc.req;

import com.suyan.mmc.req.base.QueryDTO;

import java.util.Date;
import java.util.List;

public class StatusLogQueryDTO extends QueryDTO {
    
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
    private Byte type;
            
    public Byte getType(){
        return type;
    }
    public void setType(Byte type){
        this.type = type;
    }
    private List<Byte> typeList;

    public List<Byte> getTypeList(){
        return typeList;
    }
    public void setTypeList(List<Byte> typeList){
        this.typeList = typeList;
    }
    private Long entityId;
            
    public Long getEntityId(){
        return entityId;
    }
    public void setEntityId(Long entityId){
        this.entityId = entityId;
    }
    private List<Long> entityIdList;

    public List<Long> getEntityIdList(){
        return entityIdList;
    }
    public void setEntityIdList(List<Long> entityIdList){
        this.entityIdList = entityIdList;
    }
    private Byte oldStatus;
            
    public Byte getOldStatus(){
        return oldStatus;
    }
    public void setOldStatus(Byte oldStatus){
        this.oldStatus = oldStatus;
    }
    private List<Byte> oldStatusList;

    public List<Byte> getOldStatusList(){
        return oldStatusList;
    }
    public void setOldStatusList(List<Byte> oldStatusList){
        this.oldStatusList = oldStatusList;
    }
    private Byte newStatus;
            
    public Byte getNewStatus(){
        return newStatus;
    }
    public void setNewStatus(Byte newStatus){
        this.newStatus = newStatus;
    }
    private List<Byte> newStatusList;

    public List<Byte> getNewStatusList(){
        return newStatusList;
    }
    public void setNewStatusList(List<Byte> newStatusList){
        this.newStatusList = newStatusList;
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
    private String operationUser;
            
    public String getOperationUser(){
        return operationUser;
    }
    public void setOperationUser(String operationUser){
        this.operationUser = operationUser;
    }
    private String operationUserLike;

    public String getOperationUserLike(){
        return operationUserLike;
    }
    public void setOperationUserLike(String operationUserLike){
        this.operationUserLike = operationUserLike;
    }
    private String operationUserName;
            
    public String getOperationUserName(){
        return operationUserName;
    }
    public void setOperationUserName(String operationUserName){
        this.operationUserName = operationUserName;
    }
    private String operationUserNameLike;

    public String getOperationUserNameLike(){
        return operationUserNameLike;
    }
    public void setOperationUserNameLike(String operationUserNameLike){
        this.operationUserNameLike = operationUserNameLike;
    }

    /**
    * The following custom property definition
    */
}