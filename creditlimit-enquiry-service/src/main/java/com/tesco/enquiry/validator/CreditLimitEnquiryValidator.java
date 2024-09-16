package com.tesco.enquiry.validator;

import org.springframework.stereotype.Component;

import com.tesco.enquiry.exception.CreditLimitEnquiryRequestInvalidException;
import com.tesco.enquiry.model.CreditLimitRequest;

@Component
public class CreditLimitEnquiryValidator {

	public void validateRequest(CreditLimitRequest creditLimitRequest) throws CreditLimitEnquiryRequestInvalidException {
		
		//validate the request, if the request is valid return nothing
		//else return user defined exception
		
		if(creditLimitRequest.getPromocode() == null || creditLimitRequest.getPromocode().isEmpty() || creditLimitRequest.getPromocode().length() < 11) {
			
		throw new CreditLimitEnquiryRequestInvalidException("enq001", "invalid promocode");
		}
		
		if(creditLimitRequest.getClientId() == null || "".equals(creditLimitRequest.getClientId())) {
			throw new CreditLimitEnquiryRequestInvalidException("enq02", "invalid clientId");
		}
	}
}
