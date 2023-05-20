package com.telco.operator.telcoservices.enums;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ServiceType {

	INTERNET(1, "INTERNET"), TELEFON(2, "TELEFON"), TELEVIZIJA(3, "TELEVIZIJA");

	private int id;
	private String message;

	private ServiceType(int id, String message) {
		this.id = id;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	@JsonValue
	public String getMessage() {
		return message;
	}

	@JsonCreator
	public static ServiceType fromText(String text) {
		try {
			return valueOf(text);
		} catch (Exception e) {
			return null;
		}
	}

	@JsonCreator
	public static List<ServiceType> getList() {
		try {
			List<ServiceType> list = Arrays.asList(ServiceType.INTERNET, ServiceType.TELEFON, ServiceType.TELEVIZIJA);
			return list;
		} catch (Exception e) {
			return null;
		}
	}
}
