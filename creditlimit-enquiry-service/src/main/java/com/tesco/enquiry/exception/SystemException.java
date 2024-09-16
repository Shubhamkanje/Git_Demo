package com.tesco.enquiry.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SystemException extends Exception{

	private String respCode;
	private String respMsg;
	
	public SystemException(String respCode, String respMsg) {
		this.respCode = respCode;
		this.respMsg = respMsg;
		
	}
}
