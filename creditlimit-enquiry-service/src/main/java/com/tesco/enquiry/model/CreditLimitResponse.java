package com.tesco.enquiry.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class CreditLimitResponse {

	private StatusBlock statusBlock;
    private CustomerInfo customerInfo;
	
}
