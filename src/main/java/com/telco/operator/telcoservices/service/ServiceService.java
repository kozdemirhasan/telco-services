package com.telco.operator.telcoservices.service;

import com.telco.operator.telcoservices.dto.RequestServiceCreateDto;
import com.telco.operator.telcoservices.dto.RequestServiceUpdateDto;
import com.telco.operator.telcoservices.dto.ResponseServiceDetailDto;
import com.telco.operator.telcoservices.exception.ResourceNotFoundException;

public interface ServiceService {

	/**
	 * Saves new entity for Service
	 * 
	 * @param requestDto
	 * @return created entity Id
	 * @throws ResourceNotFoundException if the Address doesn't exist.
	 */
	Integer save(RequestServiceCreateDto requestDto) throws Exception;

	/**
	 * Gets Service details by given parameter.
	 * 
	 * @param serviceId
	 * @return
	 * @throws ResourceNotFoundException if the entity with given Id doesn't exist.
	 */
	ResponseServiceDetailDto getServiceDetail(int serviceId) throws Exception;

	/**
	 * Updates entity for Service
	 * 
	 * @param requestDto
	 * @throws ResourceNotFoundException if the entity with given Id doesn't exist.
	 */
	void updateService(RequestServiceUpdateDto requestDto) throws Exception;

	/**
	 * Deletes Service by given Id
	 * 
	 * @param Id
	 * @return
	 * @throws ResourceNotFoundException if the entity with given Id doesn't exist.
	 */
	Integer deleteService(int Id) throws Exception;

}
