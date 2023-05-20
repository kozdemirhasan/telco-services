package com.telco.operator.telcoservices.service;

import java.util.List;

import com.telco.operator.telcoservices.dto.AddressDto;
import com.telco.operator.telcoservices.dto.RequestAddressCreateDto;
import com.telco.operator.telcoservices.dto.RequestAddressFilterDto;
import com.telco.operator.telcoservices.dto.RequestAddressUpdateDto;
import com.telco.operator.telcoservices.dto.ResponseAddressDetailDto;
import com.telco.operator.telcoservices.dto.ResponseAddressDetailsByAddressIdDto;
import com.telco.operator.telcoservices.exception.ResourceNotFoundException;

public interface AddressService {

	/**
	 * Saves new entity for Address
	 * 
	 * @param requestDto
	 * @return created entity Id
	 */
	Integer save(RequestAddressCreateDto requestDto);

	/**
	 * Gets Address details by given parameter.
	 * 
	 * @param addressId
	 * @return ResponseAddressDetailDto
	 * @throws ResourceNotFoundException if the entity with given Id doesn't exist.
	 */
	ResponseAddressDetailDto getAddressDetail(int addressId) throws Exception;

	/**
	 * Updates entity for Address
	 * 
	 * @param requestDto
	 * @throws ResourceNotFoundException if the entity with given Id doesn't exist.
	 */
	void updateAddress(RequestAddressUpdateDto requestDto) throws Exception;

	/**
	 * Method gets list of the Addresses that likes the given fields.
	 * 
	 * @param filter
	 * @return
	 */
	List<AddressDto> filterAddress(RequestAddressFilterDto filter);

	/**
	 * Deletes Address by given Id
	 * 
	 * @param Id
	 * @return
	 * @throws ResourceNotFoundException if the entity with given Id doesn't exist.
	 */
	Integer deleteAddress(int Id) throws Exception;

	/**
	 * Gets Address details with related services by given Id.
	 * 
	 * @param addressId
	 * @return
	 * @throws ResourceNotFoundException if the entity with given Id doesn't exist.
	 */
	ResponseAddressDetailsByAddressIdDto getAddressDetailsByAddressId(int addressId) throws Exception;
}
