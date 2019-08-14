package com.taichi.cfm.common.exception;

public class TaiChiException extends Exception {
	private static final long serialVersionUID = 1L;

	private String error;

    private String errmsg;

    public TaiChiException(){
        super();
    }

    public TaiChiException(String error, String errmsg) {
        super(errmsg);
        this.error = error;
        this.errmsg = errmsg;
    }

    public TaiChiException(ErrorCode errorCode, String errmsg) {
        super(errmsg);
        this.error = errorCode.getCode();
        this.errmsg = errorCode.getMessage() + ":" + errmsg;
    }

    public TaiChiException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.error = errorCode.getCode();
        this.errmsg = errorCode.getMessage();
    }

    public TaiChiException(String error, String message, Throwable e) {
        super(message, e);
        this.error = error;
        this.errmsg = e.getMessage();
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}