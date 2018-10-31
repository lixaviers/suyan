package com.suyan.user.exception;


import com.suyan.user.result.UserResultCode;

public class CommonBizException extends BaseException {
    private static final long serialVersionUID = 1L;

    private UserResultCode userResultCode;

    public CommonBizException(Integer errorCode, String errorMsg, Throwable caused) {
        super(errorCode, errorMsg, caused);
    }

    public CommonBizException(Integer errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public CommonBizException(Integer errorCode, String errorMsg, Object... args) {
        super(errorCode, errorMsg, args);
    }

    public CommonBizException(UserResultCode userResultCode) {
        this(userResultCode.getCode(), userResultCode.getMessage());
        this.userResultCode = userResultCode;
    }

    public CommonBizException(UserResultCode userResultCode, Object... args) {
        this(userResultCode.getCode(), userResultCode.getMessage(), args);
        this.userResultCode = userResultCode;
    }

    public CommonBizException(Integer errorCode, Throwable caused) {
        super(errorCode, caused);
    }

    public UserResultCode getUserResultCode() {
        return userResultCode;
    }
}