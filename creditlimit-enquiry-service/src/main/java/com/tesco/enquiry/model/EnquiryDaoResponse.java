package com.tesco.enquiry.model;

import lombok.Data;

@Data
public class EnquiryDaoResponse {

	private String respCode;
	private String respMsg;
	
	private String cardNum;
	private String cvv;
	private long availableAmount;
	private long increaseAmount;
	private float increasePer;	
}
