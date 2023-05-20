package com.telco.operator.telcoservices.exception;

import com.telco.operator.telcoservices.enums.*;

public abstract class AbstractException extends RuntimeException {
	private CommonExceptionMessage commonExceptionMessage;

	public AbstractException(TelcoExceptionEnum errorCode, String message) {
		super(message);
		this.commonExceptionMessage = new CommonExceptionMessage(errorCode, message);
	}

	public AbstractException(TelcoExceptionEnum errorCode) {
		this(errorCode, "");
	}

	public CommonExceptionMessage getCommonExceptionMessage() {
		return commonExceptionMessage;
	}

	public void setCommonExceptionMessage(CommonExceptionMessage commonExceptionMessage) {
		this.commonExceptionMessage = commonExceptionMessage;
	}
}