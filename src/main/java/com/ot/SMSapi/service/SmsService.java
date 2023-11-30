package com.ot.SMSapi.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SmsService {

	private final RestTemplate restTemplate;

	public SmsService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ResponseEntity<String> sendSms() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization",
				"Basic dURtaHR6SzhDZUF5c08zVnFNTGk6dVdCOE1va0k0SjVndW04cjdZVVpNUmVtWVJTQmtiVFdiajdxS2o0Wg==");

		String url = "https://restapi.smscountry.com/v0.1/Accounts/uDmhtzK8CeAysO3VqMLi/SMSes/";

		String requestBody = "{ \"Text\": \"Dear Customer, Your recent transaction of Rs.100 has been successfully credited. Thank you for choosing us! Account Number: PIGMY123 Agent: Naqiya - ORBITTECHNOLOGYS\", \"Number\": \"918618227093\", \"SenderId\": \"UHCSLT\", \"Tool\": \"API\" }";

		HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			System.out.println("SMS Sent Successfully!");
			return ResponseEntity.ok("SMS send Success "+response);
		} else {
			System.out.println("Failed to send SMS. Response: " + response.getStatusCode().value());
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Your SMS is in Queue");
		}

	}
}
