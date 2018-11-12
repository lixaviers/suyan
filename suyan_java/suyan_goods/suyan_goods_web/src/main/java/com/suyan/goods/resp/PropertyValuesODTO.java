package com.suyan.goods.resp;

import java.io.Serializable;
import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel("属性值")
public class PropertyValuesODTO implements Serializable {

    /**   
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;


    /**
     * ID
     */
    @ApiModelProperty("ID")
    private Long id;

    /**
     * 类目id
     */
    @ApiModelProperty("类目id")
    private Long categoryId;

    /**
     * 属性名id
     */
    @ApiModelProperty("属性名id")
    private Long propertyNameId;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private Byte commonStatus;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sortNumber;

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

    public Long getCategoryId(){
        return categoryId;
    }
    public void setCategoryId(Long categoryId){
        this.categoryId = categoryId;
    }

    public Long getPropertyNameId(){
        return propertyNameId;
    }
    public void setPropertyNameId(Long propertyNameId){
        this.propertyNameId = propertyNameId;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Byte getCommonStatus(){
        return commonStatus;
    }
    public void setCommonStatus(Byte commonStatus){
        this.commonStatus = commonStatus;
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