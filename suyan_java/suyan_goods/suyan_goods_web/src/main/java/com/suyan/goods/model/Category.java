package com.suyan.goods.model;

import java.util.Date;

public class Category {

    public static final String ID = "ID";
    public static final String NAME = "名称";
    public static final String PARENT_ID = "父类id";
    public static final String SORT_NUMBER = "排序";
    public static final String SORT_NUMBER_WEB = "网站排序";
    public static final String LEVEL_TYPE = "层级";
    public static final String URL = "地址";
    public static final String CREATE_USER = "创建人";
    public static final String CREATE_USER_NAME = "创建人名称";
    public static final String CREATE_TIME = "创建时间";
    public static final String UPDATE_USER = "修改人";
    public static final String UPDATE_USER_NAME = "更新人名称";
    public static final String UPDATE_TIME = "更新时间";
    public static final String IS_DELETED = "是否删除：0.未删除，1.已删除";


    /**
     * ID
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 父类id
     */
    private Long parentId;

    /**
     * 排序
     */
    private Integer sortNumber;

    /**
     * 网站排序
     */
    private Integer sortNumberWeb;

    /**
     * 层级
     */
    private Byte levelType;

    /**
     * 地址
     */
    private String url;

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
     * 更新人名称
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

    public Long getParentId(){
        return parentId;
    }
    
    public void setParentId(Long parentId){
        this.parentId = parentId;
    }

    public Integer getSortNumber(){
        return sortNumber;
    }
    
    public void setSortNumber(Integer sortNumber){
        this.sortNumber = sortNumber;
    }

    public Integer getSortNumberWeb(){
        return sortNumberWeb;
    }
    
    public void setSortNumberWeb(Integer sortNumberWeb){
        this.sortNumberWeb = sortNumberWeb;
    }

    public Byte getLevelType(){
        return levelType;
    }
    
    public void setLevelType(Byte levelType){
        this.levelType = levelType;
    }

    public String getUrl(){
        return url;
    }
    
    public void setUrl(String url){
        this.url = url;
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