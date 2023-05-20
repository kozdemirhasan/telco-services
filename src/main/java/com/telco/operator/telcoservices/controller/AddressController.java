package com.telco.operator.telcoservices.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.telco.operator.telcoservices.constants.Constant;
import com.telco.operator.telcoservices.dto.AddressDto;
import com.telco.operator.telcoservices.dto.RequestAddressCreateDto;
import com.telco.operator.telcoservices.dto.RequestAddressFilterDto;
import com.telco.operator.telcoservices.dto.RequestAddressUpdateDto;
import com.telco.operator.telcoservices.dto.ResponseAddressDetailDto;
import com.telco.operator.telcoservices.dto.ResponseAddressDetailsByAddressIdDto;
import com.telco.operator.telcoservices.service.AddressService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

	Logger logger = Logger.getLogger(AddressController.class);

	@Autowired
	private AddressService addressService;

	@ApiOperation(value = "content", notes = "This rest service accept <strong>xml or json content </strong>"
			+ " instead of directly sending xml or json file", nickname = "content")
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<Integer> addressSave(@Valid @RequestBody RequestAddressCreateDto requestDto) {
		logger.info(Constant.ADDRESS_CREATE_REQUEST_MESSAGE);
		return new ResponseEntity<Integer>(addressService.save(requestDto), HttpStatus.CREATED);
	}

	@ApiOperation(value = "content", notes = "This rest service accept <strong>xml or json content </strong>"
			+ " instead of directly sending xml or json file",nickname = "content")
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<ResponseAddressDetailDto> getAddressDetail(@PathVariable int id) throws Exception {
		return new ResponseEntity<ResponseAddressDetailDto>(addressService.getAddressDetail(id), HttpStatus.OK);
	}

	@ApiOperation(value = "content", notes = "This rest service accept <strong>xml or json content </strong>"
			+ " instead of directly sending xml or json file", nickname = "content")
	@RequestMapping(value = "/detailwithserviceinf/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<ResponseAddressDetailsByAddressIdDto> getAddressDetailWithServiceInf(@PathVariable int id)
			throws Exception {
		return new ResponseEntity<ResponseAddressDetailsByAddressIdDto>(addressService.getAddressDetailsByAddressId(id),
				HttpStatus.OK);
	}

	@ApiOperation(value = "content", notes = "This rest service accept <strong>xml or json content </strong>"
			+ " instead of directly sending xml or json file", nickname = "content")
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<Void> udpateAddress(@Valid @RequestBody RequestAddressUpdateDto requestDto) throws Exception {
		logger.info(Constant.ADDRESS_UPDATE_MESSAGE);
		addressService.updateAddress(requestDto);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@ApiOperation(value = "content", notes = "This rest service accept <strong>xml or json content </strong>"
			+ " instead of directly sending xml or json file", nickname = "content")
	@RequestMapping(value = "/filterAddress", method = RequestMethod.POST, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<List<AddressDto>> filterAddress(@Valid @RequestBody RequestAddressFilterDto filter) {
		logger.info(Constant.ADDRESS_FILTER_REQUEST_MESSAGE);
		return new ResponseEntity<List<AddressDto>>(addressService.filterAddress(filter), HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteAddress/{Id}")
	@ResponseBody
	public ResponseEntity<Integer> deleteAddress(@PathVariable int Id) throws Exception {

		return new ResponseEntity<Integer>(addressService.deleteAddress(Id), HttpStatus.OK);
	}
}
