package com.telco.operator.telcoservices.dto;

import com.telco.operator.telcoservices.enums.ServiceType;

public class ServiceDto {

	private ServiceType service;

	private boolean value;

	private String comment;

	public ServiceType getService() {
		return service;
	}

	public void setService(ServiceType service) {
		this.service = service;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
