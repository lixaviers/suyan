package com.suyan.common.exception;


import com.suyan.common.result.ResultCode;

public class CommonBizException extends BaseException {
    private static final long serialVersionUID = 1L;

    private ResultCode resultCode;

    public CommonBizException(Integer errorCode, String errorMsg, Throwable caused) {
        super(errorCode, errorMsg, caused);
    }

    public CommonBizException(Integer errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public CommonBizException(Integer errorCode, String errorMsg, Object... args) {
        super(errorCode, errorMsg, args);
    }

    public CommonBizException(ResultCode resultCode) {
        this(resultCode.getCode(), resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public CommonBizException(ResultCode resultCode, Object... args) {
        this(resultCode.getCode(), resultCode.getMessage(), args);
        this.resultCode = resultCode;
    }

    public CommonBizException(Integer errorCode, Throwable caused) {
        super(errorCode, caused);
    }

    public ResultCode getResultCode() {
        return resultCode;
    }


}