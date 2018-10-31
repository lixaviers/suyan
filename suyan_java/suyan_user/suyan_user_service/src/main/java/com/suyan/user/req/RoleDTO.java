package com.suyan.user.req;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RoleDTO implements Serializable {
    /**
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;

            
    /**
     * 主键id
     */
    private Integer id;
            
    /**
     * 角色名
     */
    private String roleName;
            
    /**
     * 角色编码
     */
    private String roleCode;
            
    /**
     * 父类id
     */
    private Integer parentId;
            
    /**
     * 系统id
     */
    private Integer systemId;
            
    /**
     * 排序数
     */
    private Integer sortNumber;
            
    /**
     * 是否通用 1.是 0.否
     */
    private Boolean isCommon;
            
    /**
     * 描述
     */
    private String description;
            
    /**
     * 角色状态
     */
    private Byte roleStatus;
            
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
        
    
    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getRoleName(){
        return roleName;
    }
    
    public void setRoleName(String roleName){
        this.roleName = roleName;
    }
    
    public String getRoleCode(){
        return roleCode;
    }
    
    public void setRoleCode(String roleCode){
        this.roleCode = roleCode;
    }
    
    public Integer getParentId(){
        return parentId;
    }
    
    public void setParentId(Integer parentId){
        this.parentId = parentId;
    }
    
    public Integer getSystemId(){
        return systemId;
    }
    
    public void setSystemId(Integer systemId){
        this.systemId = systemId;
    }
    
    public Integer getSortNumber(){
        return sortNumber;
    }
    
    public void setSortNumber(Integer sortNumber){
        this.sortNumber = sortNumber;
    }
    
    public Boolean getIsCommon(){
        return isCommon;
    }
    
    public void setIsCommon(Boolean isCommon){
        this.isCommon = isCommon;
    }
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public Byte getRoleStatus(){
        return roleStatus;
    }
    
    public void setRoleStatus(Byte roleStatus){
        this.roleStatus = roleStatus;
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

    private List<ResourceDTO> resourceList;
    private List<Long> resourceIdList;

    public List<ResourceDTO> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<ResourceDTO> resourceList) {
        this.resourceList = resourceList;
    }

    public List<Long> getResourceIdList() {
        return resourceIdList;
    }

    public void setResourceIdList(List<Long> resourceIdList) {
        this.resourceIdList = resourceIdList;
    }
}