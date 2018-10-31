package com.suyan.user.model;

import java.util.Date;

public class System {

    public static final String ID = "主键id";
    public static final String NAME = "名称";
    public static final String SYS_CODE = "编码";
    public static final String SERVICE_ID = "应用id";
    public static final String PATH = "应用链接";
    public static final String LINK = "首页链接";
    public static final String ICON = "图标";
    public static final String SYS_STATUS = "状态";
    public static final String SORT_NUMBER = "排序";
    public static final String CREATE_USER = "创建人";
    public static final String CREATE_USER_NAME = "创建人名称";
    public static final String CREATE_TIME = "创建时间";
    public static final String UPDATE_USER = "修改人";
    public static final String UPDATE_USER_NAME = "修改人名称";
    public static final String UPDATE_TIME = "更新时间";
    public static final String IS_DELETED = "是否删除：0.未删除，1.已删除";


    /**
     * 主键id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 编码
     */
    private String sysCode;

    /**
     * 应用id
     */
    private String serviceId;

    /**
     * 应用链接
     */
    private String path;

    /**
     * 首页链接
     */
    private String link;

    /**
     * 图标
     */
    private String icon;

    /**
     * 状态
     */
    private Byte sysStatus;

    /**
     * 排序
     */
    private Integer sortNumber;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建人名称
     */
    private String createUserName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private String updateUser;

    /**
     * 修改人名称
     */
    private String updateUserName;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除：0.未删除，1.已删除
     */
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

    /**
    * The following custom property definition
    */

}