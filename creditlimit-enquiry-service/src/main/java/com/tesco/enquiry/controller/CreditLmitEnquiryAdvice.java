package com.tesco.enquiry.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tesco.enquiry.exception.BusinessException;
import com.tesco.enquiry.exception.CreditLimitEnquiryRequestInvalidException;
import com.tesco.enquiry.exception.SystemException;
import com.tesco.enquiry.model.CreditLimitResponse;
import com.tesco.enquiry.model.StatusBlock;

@ControllerAdvice
public class CreditLmitEnquiryAdvice {

	@ResponseBody
	@ExceptionHandler(value = CreditLimitEnquiryRequestInvalidException.class)
	public ResponseEntity<CreditLimitResponse> handleRequestInvalidException(
			CreditLimitEnquiryRequestInvalidException exception) {

		CreditLimitResponse creditLimitResponse = buildErrorResponse(exception.getRespCode(), exception.getRespMsg());

		return new ResponseEntity<CreditLimitResponse>(creditLimitResponse, HttpStatus.BAD_REQUEST);
	}

	@ResponseBody
	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<CreditLimitResponse> HandleDataError(BusinessException exception) {

		CreditLimitResponse creditLimitResponse = buildErrorResponse(exception.getRespCode(), exception.getRespMsg());

		return new ResponseEntity<CreditLimitResponse>(creditLimitResponse, HttpStatus.BAD_REQUEST);
	}

	@ResponseBody
	@ExceptionHandler(value = SystemException.class)
	public ResponseEntity<CreditLimitResponse> HandleSystemError(SystemException exception) {

		CreditLimitResponse creditLimitResponse = buildErrorResponse(exception.getRespCode(), exception.getRespMsg());

		return new ResponseEntity<CreditLimitResponse>(creditLimitResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<CreditLimitResponse> HandleGenericError(Exception exception) {

		CreditLimitResponse creditLimitResponse = buildErrorResponse("8888", "Unknown error from service");

		return new ResponseEntity<CreditLimitResponse>(creditLimitResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private CreditLimitResponse buildErrorResponse(String respCode, String respMsg) {
		StatusBlock statusBlock = new StatusBlock();

		statusBlock.setRespCode(respCode);
		statusBlock.setRespMsg(respMsg);

		CreditLimitResponse creditLimitResponse = new CreditLimitResponse();

		creditLimitResponse.setStatusBlock(statusBlock);
		return creditLimitResponse;
	}
}
