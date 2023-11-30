package com.ot.SMSapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ot.SMSapi.service.SmsService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SmsController {
	
	@Autowired
	private SmsService smsService;
	
	@PostMapping("/send-sms")
	public ResponseEntity<String> sendSms() {
		return smsService.sendSms();
	}

}