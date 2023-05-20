package com.telco.operator.telcoservices.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RequestAddressCreateDto {

	@NotBlank(message = "Street is required")
	private String street;

	@NotBlank(message = "Street no is required")
	private String streetNo;

	@NotBlank(message = "City is required")
	private String city;

	@NotBlank(message = "Post is required")
	private String post;

	@NotNull(message = "Post no is required")
	private Integer postNo;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
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

}
