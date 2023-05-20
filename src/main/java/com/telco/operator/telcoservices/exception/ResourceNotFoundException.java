package com.telco.operator.telcoservices.exception;

import com.telco.operator.telcoservices.enums.*;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(TelcoExceptionEnum errorCode) {
		super(errorCode.toString());
	}
}
