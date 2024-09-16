package com.tesco.enquiry.validator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tesco.enquiry.exception.CreditLimitEnquiryRequestInvalidException;
import com.tesco.enquiry.model.CreditLimitRequest;

public class CreditLimitEnquiryValidatorTest {
	
	CreditLimitEnquiryValidator creditLimitEnquiryValidator;
	
	CreditLimitRequest creditLimitRequest;

	@Before
	public void setUp() throws Exception {
		creditLimitEnquiryValidator = new CreditLimitEnquiryValidator();
		
		creditLimitRequest = buildCreditLimitRequest();
	}

	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidateRequest_Promocode_Null_Scenario(){
		
		try {
			creditLimitRequest.setPromocode(null);
			creditLimitEnquiryValidator.validateRequest(creditLimitRequest);
		} catch (CreditLimitEnquiryRequestInvalidException e) {
		
			assertEquals("enq001", e.getRespCode());
		}
	}
	
	private CreditLimitRequest buildCreditLimitRequest() {
		CreditLimitRequest creditLimitRequest = new CreditLimitRequest();
		creditLimitRequest.setPromocode("12121212");
		creditLimitRequest.setChannelId("online");
		creditLimitRequest.setClientId("web");
		creditLimitRequest.setMessageTs("22-may-24");
		creditLimitRequest.setRequestId("abc123xyz");
		return creditLimitRequest;
	}


}
