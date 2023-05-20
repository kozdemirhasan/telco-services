package com.telco.operator.telcoservices.exception;

import com.telco.operator.telcoservices.enums.TelcoExceptionEnum;

public class CommonExceptionMessage {

	private TelcoExceptionEnum errorCode;
	private String message;

	public CommonExceptionMessage(TelcoExceptionEnum errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TelcoExceptionEnum getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(TelcoExceptionEnum errorCode) {
		this.errorCode = errorCode;
	}
}
