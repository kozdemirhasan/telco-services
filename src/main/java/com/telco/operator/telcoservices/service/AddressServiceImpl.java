package com.telco.operator.telcoservices.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telco.operator.telcoservices.constants.Constant;
import com.telco.operator.telcoservices.dto.AddressDto;
import com.telco.operator.telcoservices.dto.RequestAddressCreateDto;
import com.telco.operator.telcoservices.dto.RequestAddressFilterDto;
import com.telco.operator.telcoservices.dto.RequestAddressUpdateDto;
import com.telco.operator.telcoservices.dto.ResponseAddressDetailDto;
import com.telco.operator.telcoservices.dto.ResponseAddressDetailsByAddressIdDto;
import com.telco.operator.telcoservices.dto.ServiceDto;
import com.telco.operator.telcoservices.enums.TelcoExceptionEnum;
import com.telco.operator.telcoservices.exception.ResourceNotFoundException;
import com.telco.operator.telcoservices.model.Address;
import com.telco.operator.telcoservices.repository.AddressRepository;
import com.telco.operator.telcoservices.repository.ServiceRepository;

@Service
public class AddressServiceImpl implements AddressService {

	Logger logger = Logger.getLogger(AddressServiceImpl.class);

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Integer save(RequestAddressCreateDto requestDto) {

		Address address = modelMapper.map(requestDto, Address.class);
		addressRepository.save(address);
		logger.info(String.format(Constant.ADDRESS_CREATE_MESSAGE, address.getAddressId()));
		return address.getAddressId();
	}

	@Override
	@Transactional
	public ResponseAddressDetailDto getAddressDetail(int addressId) throws Exception {

		Address address = addressRepository.findById(addressId)
				.orElseThrow(() -> new ResourceNotFoundException(TelcoExceptionEnum.ADDRESS_NOT_FOUND));
		ResponseAddressDetailDto response = modelMapper.map(address, ResponseAddressDetailDto.class);
		logger.info(String.format(Constant.ADDRESS_INFOWITH_ID_MESSAGE, address.getAddressId()));
		return response;
	}

	@Override
	@Transactional
	public void updateAddress(RequestAddressUpdateDto requestDto) throws Exception {

		Address address = addressRepository.findById(requestDto.getAddressId())
				.orElseThrow(() -> new ResourceNotFoundException(TelcoExceptionEnum.ADDRESS_NOT_FOUND));
		address = modelMapper.map(requestDto, Address.class);
		addressRepository.save(address);
		logger.info(String.format(Constant.ADDRESS_UPDATE_MESSAGE, address.getAddressId()));
	}

	@Override
	@Transactional
	public List<AddressDto> filterAddress(RequestAddressFilterDto filter) {

		List<AddressDto> dtolist = new ArrayList<AddressDto>();
		/*
		 * List<Address> addressList = addressRepository
		 * .findByStreetNoIgnoreCaseContainingAndStreetIgnoreCaseContainingAndCityIgnoreCaseContainingAndPostIgnoreCaseContainingAndPostNo(
		 * filter.getStreetNo(), filter.getStreet(), filter.getCity(), filter.getPost(),
		 * filter.getPostNo());
		 */
		List<Address> addressList = addressRepository.findByAddressFilter(filter.getStreetNo(), filter.getStreet(),
				filter.getCity(), filter.getPost(), filter.getPostNo());
		logger.info(String.format(Constant.ADDRESS_INFOWITH_FIELDS_MESSAGE, filter.getStreetNo()));
		for (Address address : addressList) {
			List<com.telco.operator.telcoservices.model.Service> serviceList = serviceRepository
					.findByAddressId(address.getAddressId());
			AddressDto addressDto = modelMapper.map(address, AddressDto.class);
			List<ServiceDto> serviceListDto = new ArrayList<ServiceDto>();
			for (com.telco.operator.telcoservices.model.Service service : serviceList) {
				ServiceDto serviceDto = new ServiceDto();
				serviceDto.setComment(service.getComment());
				serviceDto.setService(service.getService());
				serviceDto.setValue(service.isValue());
				serviceListDto.add(serviceDto);
			}
			addressDto.setServiceList(serviceListDto);
			dtolist.add(addressDto);
		}
		return dtolist;
	}

	@Override
	@Transactional
	public Integer deleteAddress(int Id) throws Exception {
		Address address = addressRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException(TelcoExceptionEnum.ADDRESS_NOT_FOUND));
		addressRepository.delete(address);
		logger.info(String.format(Constant.ADDRESS_DELETE_MESSAGE, address.getAddressId()));
		return Id;
	}

	@Override
	@Transactional
	public ResponseAddressDetailsByAddressIdDto getAddressDetailsByAddressId(int addressId) throws Exception {
		Address address = addressRepository.findById(addressId)
				.orElseThrow(() -> new ResourceNotFoundException(TelcoExceptionEnum.ADDRESS_NOT_FOUND));
		ResponseAddressDetailsByAddressIdDto response = new ResponseAddressDetailsByAddressIdDto();
		AddressDto addressDto = modelMapper.map(address, AddressDto.class);
		response.setAddress(addressDto);

		List<com.telco.operator.telcoservices.model.Service> serviceList = serviceRepository.findByAddressId(addressId);
		List<ServiceDto> serviceDtoList = new ArrayList<ServiceDto>();
		for (com.telco.operator.telcoservices.model.Service service : serviceList) {
			ServiceDto serviceDto = modelMapper.map(service, ServiceDto.class);
			serviceDtoList.add(serviceDto);
		}
		response.setServices(serviceDtoList);
		logger.info(String.format(Constant.ADDRESS_DETAILWITHSERVICES_MESSAGE, address.getAddressId()));
		return response;
	}

}
