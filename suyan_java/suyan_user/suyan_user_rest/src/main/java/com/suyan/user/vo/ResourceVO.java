package com.suyan.user.vo;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel("资源")
public class ResourceVO implements Serializable {
    /**
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;

        
    @ApiModelProperty("主键id")
    private Long id;
        
    @ApiModelProperty("名称")
    private String name;
        
    @ApiModelProperty("权限码")
    private String resourceCode;
        
    @ApiModelProperty("父类id")
    private Long parentId;
        
    @ApiModelProperty("链接地址")
    private String url;
        
    @ApiModelProperty("类型")
    private Byte type;
        
    @ApiModelProperty("状态")
    private Byte commonStatus;
        
    @ApiModelProperty("系统id")
    private Integer systemId;
        
    @ApiModelProperty("是否全局菜单 0.否 1.是")
    private Boolean isGlobal;
        
    @ApiModelProperty("图标")
    private String icon;
        
    @ApiModelProperty("排序")
    private Integer sortNumber;
        
    @ApiModelProperty("创建时间")
    private Date createTime;
        
    @ApiModelProperty("创建人")
    private String createUser;
        
    @ApiModelProperty("创建人名称")
    private String createUserName;
        
    @ApiModelProperty("更新时间")
    private Date updateTime;
        
    @ApiModelProperty("修改人")
    private String updateUser;
        
    @ApiModelProperty("修改人名称")
    private String updateUserName;
        
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

    public String getResourceCode(){
        return resourceCode;
    }
    
    public void setResourceCode(String resourceCode){
        this.resourceCode = resourceCode;
    }

    public Long getParentId(){
        return parentId;
    }
    
    public void setParentId(Long parentId){
        this.parentId = parentId;
    }

    public String getUrl(){
        return url;
    }
    
    public void setUrl(String url){
        this.url = url;
    }

    public Byte getType(){
        return type;
    }
    
    public void setType(Byte type){
        this.type = type;
    }

    public Byte getCommonStatus(){
        return commonStatus;
    }
    
    public void setCommonStatus(Byte commonStatus){
        this.commonStatus = commonStatus;
    }

    public Integer getSystemId(){
        return systemId;
    }
    
    public void setSystemId(Integer systemId){
        this.systemId = systemId;
    }

    public Boolean getIsGlobal(){
        return isGlobal;
    }
    
    public void setIsGlobal(Boolean isGlobal){
        this.isGlobal = isGlobal;
    }

    public String getIcon(){
        return icon;
    }
    
    public void setIcon(String icon){
        this.icon = icon;
    }

    public Integer getSortNumber(){
        return sortNumber;
    }
    
    public void setSortNumber(Integer sortNumber){
        this.sortNumber = sortNumber;
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

    //-----------------------------------------------------------------------
    // custom property definition
}