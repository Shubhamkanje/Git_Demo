 package com.tesco.enquiry.model;

import lombok.Data;

@Data
public class CreditLimitRequest {

	private String promocode;
	private String clientId;
	private String channelId;
	private String messageTs;
	private String requestId;
}
