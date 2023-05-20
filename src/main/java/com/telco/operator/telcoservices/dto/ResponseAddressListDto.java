package com.telco.operator.telcoservices.dto;

import java.util.List;

public class ResponseAddressListDto {

	private List<AddressListDto> addressList;

	public List<AddressListDto> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<AddressListDto> addressList) {
		this.addressList = addressList;
	}

}
