package com.tesco.enquiry.exception;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BusinessException extends Exception{

	private String respCode;
	private String respMsg;
	
	public BusinessException(String respCode, String respMsg) {
		this.respCode = respCode;
		this.respMsg = respMsg;
		
	}
}
