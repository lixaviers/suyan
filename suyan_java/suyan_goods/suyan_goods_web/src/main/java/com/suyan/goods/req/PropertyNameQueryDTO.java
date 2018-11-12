package com.suyan.goods.req;

import com.suyan.common.req.QueryDTO;
import com.suyan.common.resp.QueryResultODTO;

import java.util.Date;
import java.util.List;

public class PropertyNameQueryDTO extends QueryDTO {
    
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
    private Long categoryId;
            
    public Long getCategoryId(){
        return categoryId;
    }
    public void setCategoryId(Long categoryId){
        this.categoryId = categoryId;
    }
    private List<Long> categoryIdList;

    public List<Long> getCategoryIdList(){
        return categoryIdList;
    }
    public void setCategoryIdList(List<Long> categoryIdList){
        this.categoryIdList = categoryIdList;
    }
    private String name;
            
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    private List<String> nameList;

    public List<String> getNameList(){
        return nameList;
    }
    public void setNameList(List<String> nameList){
        this.nameList = nameList;
    }
    private String nameLike;

    public String getNameLike(){
        return nameLike;
    }
    public void setNameLike(String nameLike){
        this.nameLike = nameLike;
    }
    private Boolean isAllowAlias;
            
    public Boolean getIsAllowAlias(){
        return isAllowAlias;
    }
    public void setIsAllowAlias(Boolean isAllowAlias){
        this.isAllowAlias = isAllowAlias;
    }
    private List<Boolean> isAllowAliasList;

    public List<Boolean> getIsAllowAliasList(){
        return isAllowAliasList;
    }
    public void setIsAllowAliasList(List<Boolean> isAllowAliasList){
        this.isAllowAliasList = isAllowAliasList;
    }
    private Boolean isColorAttribute;
            
    public Boolean getIsColorAttribute(){
        return isColorAttribute;
    }
    public void setIsColorAttribute(Boolean isColorAttribute){
        this.isColorAttribute = isColorAttribute;
    }
    private List<Boolean> isColorAttributeList;

    public List<Boolean> getIsColorAttributeList(){
        return isColorAttributeList;
    }
    public void setIsColorAttributeList(List<Boolean> isColorAttributeList){
        this.isColorAttributeList = isColorAttributeList;
    }
    private Boolean isEnumAttribute;
            
    public Boolean getIsEnumAttribute(){
        return isEnumAttribute;
    }
    public void setIsEnumAttribute(Boolean isEnumAttribute){
        this.isEnumAttribute = isEnumAttribute;
    }
    private List<Boolean> isEnumAttributeList;

    public List<Boolean> getIsEnumAttributeList(){
        return isEnumAttributeList;
    }
    public void setIsEnumAttributeList(List<Boolean> isEnumAttributeList){
        this.isEnumAttributeList = isEnumAttributeList;
    }
    private Boolean isInputAttribute;
            
    public Boolean getIsInputAttribute(){
        return isInputAttribute;
    }
    public void setIsInputAttribute(Boolean isInputAttribute){
        this.isInputAttribute = isInputAttribute;
    }
    private List<Boolean> isInputAttributeList;

    public List<Boolean> getIsInputAttributeList(){
        return isInputAttributeList;
    }
    public void setIsInputAttributeList(List<Boolean> isInputAttributeList){
        this.isInputAttributeList = isInputAttributeList;
    }
    private Boolean isSalesProperty;
            
    public Boolean getIsSalesProperty(){
        return isSalesProperty;
    }
    public void setIsSalesProperty(Boolean isSalesProperty){
        this.isSalesProperty = isSalesProperty;
    }
    private List<Boolean> isSalesPropertyList;

    public List<Boolean> getIsSalesPropertyList(){
        return isSalesPropertyList;
    }
    public void setIsSalesPropertyList(List<Boolean> isSalesPropertyList){
        this.isSalesPropertyList = isSalesPropertyList;
    }
    private Boolean isSearchField;
            
    public Boolean getIsSearchField(){
        return isSearchField;
    }
    public void setIsSearchField(Boolean isSearchField){
        this.isSearchField = isSearchField;
    }
    private List<Boolean> isSearchFieldList;

    public List<Boolean> getIsSearchFieldList(){
        return isSearchFieldList;
    }
    public void setIsSearchFieldList(List<Boolean> isSearchFieldList){
        this.isSearchFieldList = isSearchFieldList;
    }
    private Boolean isWillChoose;
            
    public Boolean getIsWillChoose(){
        return isWillChoose;
    }
    public void setIsWillChoose(Boolean isWillChoose){
        this.isWillChoose = isWillChoose;
    }
    private List<Boolean> isWillChooseList;

    public List<Boolean> getIsWillChooseList(){
        return isWillChooseList;
    }
    public void setIsWillChooseList(List<Boolean> isWillChooseList){
        this.isWillChooseList = isWillChooseList;
    }
    private Boolean isMultiSelect;
            
    public Boolean getIsMultiSelect(){
        return isMultiSelect;
    }
    public void setIsMultiSelect(Boolean isMultiSelect){
        this.isMultiSelect = isMultiSelect;
    }
    private List<Boolean> isMultiSelectList;

    public List<Boolean> getIsMultiSelectList(){
        return isMultiSelectList;
    }
    public void setIsMultiSelectList(List<Boolean> isMultiSelectList){
        this.isMultiSelectList = isMultiSelectList;
    }
    private Byte commonStatus;
            
    public Byte getCommonStatus(){
        return commonStatus;
    }
    public void setCommonStatus(Byte commonStatus){
        this.commonStatus = commonStatus;
    }
    private List<Byte> commonStatusList;

    public List<Byte> getCommonStatusList(){
        return commonStatusList;
    }
    public void setCommonStatusList(List<Byte> commonStatusList){
        this.commonStatusList = commonStatusList;
    }
    private Integer sortNumber;
            
    public Integer getSortNumber(){
        return sortNumber;
    }
    public void setSortNumber(Integer sortNumber){
        this.sortNumber = sortNumber;
    }
    private List<Integer> sortNumberList;

    public List<Integer> getSortNumberList(){
        return sortNumberList;
    }
    public void setSortNumberList(List<Integer> sortNumberList){
        this.sortNumberList = sortNumberList;
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
    private List<String> createUserNameList;

    public List<String> getCreateUserNameList(){
        return createUserNameList;
    }
    public void setCreateUserNameList(List<String> createUserNameList){
        this.createUserNameList = createUserNameList;
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
    private List<String> updateUserNameList;

    public List<String> getUpdateUserNameList(){
        return updateUserNameList;
    }
    public void setUpdateUserNameList(List<String> updateUserNameList){
        this.updateUserNameList = updateUserNameList;
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