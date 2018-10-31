package com.suyan.mmc.result;

public enum MmcResultCode {
	// 操作成功标识
	SUCCESS(200, "Success"),
	// 系统异常标识
	SYS_ERROR(500, "服务器异常，请稍后再试"),

	USER_NOT_EXIST(401, "用户不存在"),
	NO_PERMISSION(402, "没有此操作权限"),
	NO_LOGGED_IN(403, "用户未登录"),
	LOGIN_ERROR(404, "用户名和密码不匹配"),
	PWSSWORD_ERROR(405, "密码不正确"),
	NEW_PWSSWORD_ERROR(406, "新密码不能与原密码相同"),
	NEW_MOBILE_PHONE_ERROR(407, "新手机不能与原手机相同"),
	NEW_MAIL_ERROR(408, "新邮箱不能与原邮箱相同"),

	SESSION_INVALID_ERROR(501, "登录失效，请重新登录"),
	USER_DELETE_ERROR(502, "您的账号已经被删除，请联系管理员"),

	COMMON_PARAM_NULL(1001, "必要参数[%s]为空"),
	COMMON_PARAM_INVALID(1002, "参数[%s]无效"),
	CONTAINS_ILLEGAL_CHARACTERS(1003, "%s含有非法字符"),
	DATA_NOT_EXIST(1004, "%s不存在"),
	CAN_NOT_BE_OPERATE(1005, "%s不能%s"),
	FIELD_NOT_ALLOWED_EMPTY(1006, "%s不能为空"),
	FIELD_VALUE_MUST_LARGE_THAN(1007, "%s必须大于%s"),
	FIELD_VALUE_MUST_LESS_THAN(1008, "%s必须小于%s"),
	DATA_EXIST(1009, "%s已存在"),
	FIELD_NOT_EMAIL(1010, "%s格式错误"),
	FIELD_NOT_MOBILE(1011, "%s格式错误"),
	FIELD_NOT_ID_NUM(1012, "%s格式错误"),
	FIELD_NOT_DATE(1013, "%s格式错误"),
	FIELD_LENGTH_MUST_LESS(1014, "%s必须小于%d"),
	FIELD_LENGTH_MUST_MORE(1015, "%s必须大于%d"),
	FIELD_LENGTH_MUST_BETWEEN(1016, "%s长度必须大于%d和小于%d"),
	FILED_NOT_IN_ENUM_VALUES(1017, "不支持的%s"),
	FIELD_NOT_BOTH_BE_EMPTY(1018, "%s不能同时为空"),
	MUST_BE_INTEGER_MULTIPLE(1019, "%s必须是%s的整数倍"),
	UPLOAD_PICTURES_ERROR(1020, "上传图片出错，%s"),

	FIELD_VALUE_MUST_GE_THAN(1021, "%s必须大于等于%s"),
	FIELD_VALUE_MUST_LE_THAN(1022, "%s必须小于等于%s"),
	TIME_MUST_LARGE_THAN(1023, "%s必须晚于%s"),
	TIME_VALUE_MUST_LESS_THAN(1024, "%s必须早于%s"),
	INVALID_CHANGE_STATUS(1025, "%s更新状态非法"),
	LENGTH_MUST_LESS(1026, "%s必须小于%s"),
	LENGTH_MUST_MORE(1027, "%s必须大于%s"),
	NO_DATA_FOUND(1028, "暂无数据"),
	COMMON_MESSAGE(1029, "%s"),


	API_INVLID_SIGN(1500, "签名错误"),
	API_INVLID_FROM(1501, "没有权限访问"),
	API_INVLID_DATA(1502, "请求数据错误"),
	API_NOT_SUPPORT_METHOD(1503, "只接受Post请求"),
	API_INVLID_DATA_FORMAT(1504, "数据格式不符合要求"),
	API_INVLID_API(1505, "api【%s】不存在"),



	;


	public Integer code;
	public String message;

	MmcResultCode(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
