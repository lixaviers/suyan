package com.suyan.goods.resp;

import java.io.Serializable;
import java.util.Date;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel("属性名")
public class PropertyNameODTO implements Serializable {

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
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 是否允许别名
     */
    @ApiModelProperty("是否允许别名")
    private Boolean isAllowAlias;

    /**
     * 是否颜色属性
     */
    @ApiModelProperty("是否颜色属性")
    private Boolean isColorAttribute;

    /**
     * 是否枚举属性
     */
    @ApiModelProperty("是否枚举属性")
    private Boolean isEnumAttribute;

    /**
     * 是否输入属性
     */
    @ApiModelProperty("是否输入属性")
    private Boolean isInputAttribute;

    /**
     * 是否销售属性
     */
    @ApiModelProperty("是否销售属性")
    private Boolean isSalesProperty;

    /**
     * 是否搜索字段
     */
    @ApiModelProperty("是否搜索字段")
    private Boolean isSearchField;

    /**
     * 是否必选
     */
    @ApiModelProperty("是否必选")
    private Boolean isWillChoose;

    /**
     * 是否多选
     */
    @ApiModelProperty("是否多选")
    private Boolean isMultiSelect;

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

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Boolean getIsAllowAlias(){
        return isAllowAlias;
    }
    public void setIsAllowAlias(Boolean isAllowAlias){
        this.isAllowAlias = isAllowAlias;
    }

    public Boolean getIsColorAttribute(){
        return isColorAttribute;
    }
    public void setIsColorAttribute(Boolean isColorAttribute){
        this.isColorAttribute = isColorAttribute;
    }

    public Boolean getIsEnumAttribute(){
        return isEnumAttribute;
    }
    public void setIsEnumAttribute(Boolean isEnumAttribute){
        this.isEnumAttribute = isEnumAttribute;
    }

    public Boolean getIsInputAttribute(){
        return isInputAttribute;
    }
    public void setIsInputAttribute(Boolean isInputAttribute){
        this.isInputAttribute = isInputAttribute;
    }

    public Boolean getIsSalesProperty(){
        return isSalesProperty;
    }
    public void setIsSalesProperty(Boolean isSalesProperty){
        this.isSalesProperty = isSalesProperty;
    }

    public Boolean getIsSearchField(){
        return isSearchField;
    }
    public void setIsSearchField(Boolean isSearchField){
        this.isSearchField = isSearchField;
    }

    public Boolean getIsWillChoose(){
        return isWillChoose;
    }
    public void setIsWillChoose(Boolean isWillChoose){
        this.isWillChoose = isWillChoose;
    }

    public Boolean getIsMultiSelect(){
        return isMultiSelect;
    }
    public void setIsMultiSelect(Boolean isMultiSelect){
        this.isMultiSelect = isMultiSelect;
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