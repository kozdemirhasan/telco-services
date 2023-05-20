package com.telco.operator.telcoservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.telco.operator.telcoservices.enums.ServiceType;

@Entity
@Table(name = "tbl_service")
public class Service {

	@Id
	@Column(name = "SERVICE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serviceId;

	@Enumerated(EnumType.STRING)
	@Column(name = "SERVICE")
	private ServiceType service;

	@Column(name = "VALUE")
	private boolean value;

	@Column(name = "COMMENT")
	private String comment;

	@JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Address address;

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

}
