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
import com.telco.operator.telcoservices.dto.RequestServiceCreateDto;
import com.telco.operator.telcoservices.dto.RequestServiceUpdateDto;
import com.telco.operator.telcoservices.dto.ResponseServiceDetailDto;
import com.telco.operator.telcoservices.enums.ServiceType;
import com.telco.operator.telcoservices.service.ServiceService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/service")
public class ServiceController {

	Logger logger = Logger.getLogger(ServiceController.class);

	@Autowired
	private ServiceService serviceService;

	@ApiOperation(value = "content", notes = "This rest service accept <strong>xml or json content </strong>"
			+ " instead of directly sending xml or json file. <br> service field is an enumerator. There are three options."
			+ "Please enter for this field <strong>INTERNET,TELEFON or TELEVIZIJA</strong>", nickname = "content")
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<Integer> serviceSave(@Valid @RequestBody RequestServiceCreateDto requestDto)
			throws Exception {
		logger.info(Constant.SERVICE_CREATE_REQUEST_MESSAGE);
		return new ResponseEntity<Integer>(serviceService.save(requestDto), HttpStatus.CREATED);
	}

	@ApiOperation(value = "content", notes = "This rest service accept <strong>xml or json content </strong>"
			+ " instead of directly sending xml or json file", nickname = "content")
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<ResponseServiceDetailDto> getServiceDetail(@Valid @PathVariable int id) throws Exception {
		return new ResponseEntity<ResponseServiceDetailDto>(serviceService.getServiceDetail(id), HttpStatus.OK);
	}

	@ApiOperation(value = "content", notes = "This rest service accept <strong>xml or json content </strong>"
			+ " instead of directly sending xml or json file. <br> service field is an enumerator. There are three options."
			+ "Please enter for this field <strong>INTERNET,TELEFON or TELEVIZIJA</strong>", nickname = "content")
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<Void> udpateService(@Valid @RequestBody RequestServiceUpdateDto requestDto) throws Exception {
		logger.info(Constant.SERVICE_UPDATE_REQUEST_MESSAGE);
		serviceService.updateService(requestDto);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@DeleteMapping(value = "/deleteService/{Id}")
	@ResponseBody
	public ResponseEntity<Integer> deleteService(@PathVariable int Id) throws Exception {
		return new ResponseEntity<Integer>(serviceService.deleteService(Id), HttpStatus.OK);
	}

	// This method can be use for the client can select service types from a drop
	// down list component.
	@ApiOperation(value = "content", notes = "This rest service accept <strong>xml or json content </strong>"
			+ " instead of directly sending xml or json file", nickname = "content")
	@RequestMapping(value = "/serviceType", method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<List<ServiceType>> getServiceType() {
		return new ResponseEntity<List<ServiceType>>(ServiceType.getList(), HttpStatus.OK);
	}
}
