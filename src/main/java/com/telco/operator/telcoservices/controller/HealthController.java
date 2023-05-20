package com.telco.operator.telcoservices.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class HealthController {

	@ApiOperation(value = "content", notes = "This controller checks the health of the server", nickname = "content")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public String checkHealth() {
		return "Server is healthy";
	}
}
