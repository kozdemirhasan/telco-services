package com.telco.operator.telcoservices.dto;

import java.util.List;

public class AddressListDto {

	private int addressId;

	private String streetNo;

	private String street;

	private String city;

	private String post;

	private Integer postNo;

	private List<ServiceDto> serviceList;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Integer getPostNo() {
		return postNo;
	}

	public void setPostNo(Integer postNo) {
		this.postNo = postNo;
	}

	public List<ServiceDto> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<ServiceDto> serviceList) {
		this.serviceList = serviceList;
	}

}
