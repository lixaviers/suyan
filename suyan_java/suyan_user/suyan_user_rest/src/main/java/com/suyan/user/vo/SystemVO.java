package com.suyan.user.vo;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel("系统")
public class SystemVO implements Serializable {
    /**
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;

        
    @ApiModelProperty("主键id")
    private Integer id;
        
    @ApiModelProperty("名称")
    private String name;
        
    @ApiModelProperty("编码")
    private String sysCode;
        
    @ApiModelProperty("应用id")
    private String serviceId;
        
    @ApiModelProperty("应用链接")
    private String path;
        
    @ApiModelProperty("首页链接")
    private String link;
        
    @ApiModelProperty("图标")
    private String icon;
        
    @ApiModelProperty("状态")
    private Byte sysStatus;
        
    @ApiModelProperty("排序")
    private Integer sortNumber;
        
    @ApiModelProperty("创建人")
    private String createUser;
        
    @ApiModelProperty("创建人名称")
    private String createUserName;
        
    @ApiModelProperty("创建时间")
    private Date createTime;
        
    @ApiModelProperty("修改人")
    private String updateUser;
        
    @ApiModelProperty("修改人名称")
    private String updateUserName;
        
    @ApiModelProperty("更新时间")
    private Date updateTime;
        
    @ApiModelProperty("是否删除：0.未删除，1.已删除")
    private Boolean isDeleted;
    

    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String getSysCode(){
        return sysCode;
    }
    
    public void setSysCode(String sysCode){
        this.sysCode = sysCode;
    }

    public String getServiceId(){
        return serviceId;
    }
    
    public void setServiceId(String serviceId){
        this.serviceId = serviceId;
    }

    public String getPath(){
        return path;
    }
    
    public void setPath(String path){
        this.path = path;
    }

    public String getLink(){
        return link;
    }
    
    public void setLink(String link){
        this.link = link;
    }

    public String getIcon(){
        return icon;
    }
    
    public void setIcon(String icon){
        this.icon = icon;
    }

    public Byte getSysStatus(){
        return sysStatus;
    }
    
    public void setSysStatus(Byte sysStatus){
        this.sysStatus = sysStatus;
    }

    public Integer getSortNumber(){
        return sortNumber;
    }
    
    public void setSortNumber(Integer sortNumber){
        this.sortNumber = sortNumber;
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

    //-----------------------------------------------------------------------
    // custom property definition
}