package com.tesco.enquiry.service;

import org.springframework.stereotype.Service;

import com.tesco.enquiry.exception.BusinessException;
import com.tesco.enquiry.exception.SystemException;
import com.tesco.enquiry.model.CreditLimitRequest;
import com.tesco.enquiry.model.CreditLimitResponse;

@Service
public interface ICreditLmitEnquiryService {

	public CreditLimitResponse enquiry(CreditLimitRequest creditLimitRequest) throws BusinessException, SystemException;
}
