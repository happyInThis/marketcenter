package com.zhao.marketcenter.common.exception;

import com.zhao.marketcenter.common.ResponseCode;

public class ServerException extends Exception {
    private static final long serialVersionUID = 4065133016321980497L;
    private ResponseCode responseCode;

    public ServerException() {
        super();
        this.responseCode = ResponseCode.PARAM_E_ACTION_NOT_EXIST;
    }

    public ServerException(String message) {
        super(message);
        this.responseCode = ResponseCode.SYSTEM_EXCEPTION;
    }

    public ServerException(Throwable cause) {
        super(cause);
        this.responseCode = ResponseCode.SYSTEM_EXCEPTION;
    }

    public ServerException(String message, Throwable cause) {
        super(message, cause);
        this.responseCode = ResponseCode.SYSTEM_EXCEPTION;
    }

    public ServerException(ResponseCode responseCode) {
        super(responseCode.getComment());
        this.responseCode = responseCode;
    }

    public ServerException(ResponseCode responseCode, String message) {
        super(message);
        this.responseCode = responseCode;
    }

    public ServerException(ResponseCode responseCode, Throwable cause) {
        super(responseCode.getComment(), cause);
        this.responseCode = responseCode;
    }

    public ServerException(ResponseCode responseCode, String message, Throwable cause) {
        super(message, cause);
        this.responseCode = responseCode;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }
}
