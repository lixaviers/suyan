package com.suyan.user.result;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "Rest result", description = "请求结果")
public class UserResult<T> implements Serializable {
    private static final long serialVersionUID = -4696898674758059398L;

    @ApiModelProperty(value = "结果代码")
    private Integer code;
    @ApiModelProperty(value = "错误说明")
    private String message = "";
    @ApiModelProperty(value = "结果对象")
    private T dataMap;
    @ApiModelProperty(value = "操作标识")
    private boolean success;

    public UserResult(Integer code, String message, boolean success, T dataMap){
	    this.setCode(code);
	    this.setMessage(message);
	    this.setSuccess(success);
	    this.setDataMap(dataMap);
    }

	public UserResult() {
	}

	/**
	 * 
	 * 构建返回对象实例
	 * @param resultCode
	 * @param success
	 * @param value
	 * @return
	 */
	public static <T> UserResult<T> newInstance(UserResultCode resultCode, boolean success, T value) {
		return new UserResult<T>(resultCode.code, resultCode.message, success, value);
	}

	/**
	 * 
	 * 构建成功对象实例
	 * @return
	 */
	public static <T> UserResult<T> newSuccess() {
		return new UserResult<T>(UserResultCode.SUCCESS.code,
				UserResultCode.SUCCESS.message, true, null);
	}

	/**
	 * 
	 * 构建成功对象实例
	 * @return
	 */
	public static <T> UserResult<T> newSuccess(T value) {
		return new UserResult<T>(UserResultCode.SUCCESS.code,
				UserResultCode.SUCCESS.message, true, value);
	}

	public static <T> UserResult<T> newError(String message) {
		UserResult<T> result = new UserResult<>(UserResultCode.COMMON_MESSAGE.code, message, false, null);
		return result;
	}
	
	/**
	 * 
	 *	构建错误对象
	 * @param errorCode
	 * @return
	 */
	public static <T> UserResult<T> newError(UserResultCode errorCode) {
		return new UserResult<T>(errorCode.code, errorCode.message, false, null);
	}
	
	public static <T> UserResult<T> buildError(UserResultCode resultCode, Object... args)
	{
		UserResult<T> r = new UserResult<T>(0, "", false, null);
		r.setCode(resultCode.getCode());
		r.setFormatMessage(resultCode.getMessage(), args);
		
		return r;
	}

	/**
	 * 
	 * 设置错误编码
	 * @param errorCode
	 */
	public UserResult<T> setErrorCode(UserResultCode errorCode){
		if(errorCode ==null ) return null;
		
		this.code = errorCode.code;
		this.message = errorCode.message;
		this.success = false;
		return this;
	}
	
	/**
	 * 设置错误编码
	 * @param errorCode
	 * @param args
	 * @return
	 */
	public UserResult<T> setErrorCode(UserResultCode errorCode, Object... args){
		if(errorCode ==null ) return null;
		
		this.code = errorCode.code;
		setFormatMessage(errorCode.getMessage(), args);
		this.success = false;
		return this;
	}
	
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

	public T getDataMap() {
		return dataMap;
	}

	public void setDataMap(T dataMap) {
		this.dataMap = dataMap;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setMessageStatus(UserResultCode resultCode, Object... args) {
		setCode(resultCode.getCode());
		setFormatMessage(resultCode.getMessage(), args);
	}
	
	public void setFormatMessage(String message, Object... args){
		if (args == null || args.length == 0) {
			this.setMessage(message);
		}else{
			this.setMessage(String.format(message, args));
		}
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
