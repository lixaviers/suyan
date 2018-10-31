package com.suyan.user.resp;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel("操作日志")
public class OptLogODTO implements Serializable {

    /**   
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;


    /**
     * 
     */
    @ApiModelProperty("")
    private Long id;

    /**
     * 
     */
    @ApiModelProperty("")
    private Long userId;

    /**
     * 
     */
    @ApiModelProperty("")
    private Byte optType;

    /**
     * 
     */
    @ApiModelProperty("")
    private String optValue;

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


    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public Long getUserId(){
        return userId;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }

    public Byte getOptType(){
        return optType;
    }
    public void setOptType(Byte optType){
        this.optType = optType;
    }

    public String getOptValue(){
        return optValue;
    }
    public void setOptValue(String optValue){
        this.optValue = optValue;
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

    /**
    * The following custom property definition
    */
}