package com.taichi.cfm.common.exception;

import java.io.Serializable;

public class ResultDto<T> implements Serializable {

	private static final long serialVersionUID = -2348789809713814217L;

	/** 是否成功 */
	private boolean success;

	/** 错误码，成功时为空 */
	private String errcode;

	/** 错误信息，成功时为空 */
	private String errmsg;

	/** 结果数据 */
	private T data;

	public ResultDto() {
		this.success = true;
	}

	public ResultDto(boolean success) {
		this.success = success;
	}

	public ResultDto(T data) {
		this.success = true;
		this.data = data;
	}

	public ResultDto(ErrorCode error) {
		this.success = false;
		if (error != null) {
			this.errcode = error.getCode();
			this.errmsg = error.getMessage();
		}
	}

	public ResultDto(String errCode, String errMsg) {
		this.success = false;
		this.errcode = errCode;
		this.errmsg = errMsg;
	}

	public void initResult(boolean success,String errCode,String errMsg,T data){
		this.success = success;
		this.errcode = errCode;
		this.errmsg = errMsg;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}