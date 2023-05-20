package com.telco.operator.telcoservices.service;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telco.operator.telcoservices.constants.Constant;
import com.telco.operator.telcoservices.dto.RequestServiceCreateDto;
import com.telco.operator.telcoservices.dto.RequestServiceUpdateDto;
import com.telco.operator.telcoservices.dto.ResponseServiceDetailDto;
import com.telco.operator.telcoservices.enums.ServiceType;
import com.telco.operator.telcoservices.enums.TelcoExceptionEnum;
import com.telco.operator.telcoservices.exception.ResourceNotFoundException;
import com.telco.operator.telcoservices.model.Address;
import com.telco.operator.telcoservices.repository.AddressRepository;
import com.telco.operator.telcoservices.repository.ServiceRepository;

@Service
public class ServiceServiceImpl implements ServiceService {

	Logger logger = Logger.getLogger(ServiceServiceImpl.class);
	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	@Transactional
	public Integer save(RequestServiceCreateDto requestDto) throws Exception {
		com.telco.operator.telcoservices.model.Service service = new com.telco.operator.telcoservices.model.Service();
		Address address = addressRepository.findById(requestDto.getAddressId())
				.orElseThrow(() -> new ResourceNotFoundException(TelcoExceptionEnum.ADDRESS_NOT_FOUND));
		service.setAddress(address);
		service.setComment(requestDto.getComment());
		if (requestDto.getService() != null)
			service.setService(ServiceType.valueOf(requestDto.getService().toUpperCase()));
		service.setValue(requestDto.isValue());
		serviceRepository.save(service);
		logger.info(String.format(Constant.SERVICE_CREATE_MESSAGE, service.getServiceId()));
		return service.getServiceId();
	}

	@Override
	@Transactional
	public ResponseServiceDetailDto getServiceDetail(int serviceId) throws Exception {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		com.telco.operator.telcoservices.model.Service service = serviceRepository.findById(serviceId)
				.orElseThrow(() -> new ResourceNotFoundException(TelcoExceptionEnum.SERVICE_NOT_FOUND));
		ResponseServiceDetailDto response = new ResponseServiceDetailDto();
		response.setServiceId(serviceId);
		response.setAddressId(service.getAddress().getAddressId());
		response.setComment(service.getComment());
		response.setService(service.getService());
		response.setValue(service.isValue());

		logger.info(String.format(Constant.SERVICE_INFOWITH_ID_MESSAGE, service.getServiceId()));
		return response;
	}

	@Override
	@Transactional
	public void updateService(RequestServiceUpdateDto requestDto) throws Exception {

		com.telco.operator.telcoservices.model.Service service = serviceRepository.findById(requestDto.getServiceId())
				.orElseThrow(() -> new ResourceNotFoundException(TelcoExceptionEnum.SERVICE_NOT_FOUND));
		service.setComment(requestDto.getComment());
		service.setValue(requestDto.isValue());
		Address address = addressRepository.findById(requestDto.getAddressId())
				.orElseThrow(() -> new ResourceNotFoundException(TelcoExceptionEnum.ADDRESS_NOT_FOUND));
		service.setAddress(address);
		service.setService(ServiceType.valueOf(requestDto.getService().toUpperCase()));
		serviceRepository.save(service);
		logger.info(String.format(Constant.SERVICE_UPDATE_MESSAGE, service.getServiceId()));

	}

	@Override
	public Integer deleteService(int Id) throws Exception {
		com.telco.operator.telcoservices.model.Service service = serviceRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException(TelcoExceptionEnum.SERVICE_NOT_FOUND));
		serviceRepository.delete(service);
		logger.info(String.format(Constant.SERVICE_DELETE_MESSAGE, service.getServiceId()));
		return service.getServiceId();
	}

}
