package com.telco.operator.telcoservices.dto;

import java.util.List;

public class ResponseAddressDetailsByAddressIdDto {

	private AddressDto address;

	private List<ServiceDto> services;

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public List<ServiceDto> getServices() {
		return services;
	}

	public void setServices(List<ServiceDto> services) {
		this.services = services;
	}

}
