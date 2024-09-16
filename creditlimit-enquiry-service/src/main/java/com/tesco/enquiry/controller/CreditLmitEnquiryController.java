package com.tesco.enquiry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesco.enquiry.exception.BusinessException;
import com.tesco.enquiry.exception.SystemException;
import com.tesco.enquiry.model.CreditLimitRequest;
import com.tesco.enquiry.model.CreditLimitResponse;
import com.tesco.enquiry.service.ICreditLmitEnquiryService;
import com.tesco.enquiry.validator.CreditLimitEnquiryValidator;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/v1")
public class CreditLmitEnquiryController {

	@Autowired
	CreditLimitEnquiryValidator creditLimitEnquiryValidator;
	
	@Autowired
	ICreditLmitEnquiryService creditLimitService;
	
	@GetMapping("/enquiry/{promocode}")
	public ResponseEntity<CreditLimitResponse> enquiry(@PathVariable("promocode") String promocode,
			                            @RequestHeader("client_Id") String clientId,
			                            @RequestHeader("channel_Id") String channelId,
			                            @RequestHeader("message_ts") String messageTimeStamp,
			                            @RequestHeader("request_Id") String requestId) throws BusinessException, SystemException {
		
	    System.out.println("Entered into controller");
		
		// 1: get the request from consumer/client
	    
	  
		CreditLimitRequest creditLimitRequest = new CreditLimitRequest();
		
		creditLimitRequest.setPromocode(promocode);
		creditLimitRequest.setClientId(clientId);
		creditLimitRequest.setChannelId(channelId);
		creditLimitRequest.setMessageTs(messageTimeStamp);
		creditLimitRequest.setRequestId(requestId);
		
		// 2: validate the request
		
		creditLimitEnquiryValidator.validateRequest(creditLimitRequest);
		
		// 3: prepare the request for service class
		
		// 4: call service class and get response
		
		CreditLimitResponse enquiryResponse  = creditLimitService.enquiry(creditLimitRequest);
		
		System.out.println("Exit from controller");
		
		return new ResponseEntity<CreditLimitResponse>(enquiryResponse, HttpStatus.OK);
	}
}
