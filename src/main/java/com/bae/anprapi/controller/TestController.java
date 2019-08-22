package com.bae.anprapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bae.anprapi.service.CallRecordsService;

@RestController
@RequestMapping("/Test")
public class TestController {

	private CallRecordsService callRecordsService;

	@Autowired
	public TestController(CallRecordsService callRecordsService) {
		this.callRecordsService = callRecordsService;
	}

	@GetMapping("/getRecordsDTO")
	public ResponseEntity<Object> getRecordsDTO(
			@RequestParam(value = "phoneNumber", required = false) String phoneNumber) {
		return new ResponseEntity<>(callRecordsService.getRecordsDTO(phoneNumber), HttpStatus.OK);
	}
}