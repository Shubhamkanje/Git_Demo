package com.tesco.enquiry.intg.dao;

import org.springframework.stereotype.Service;

import com.tesco.enquiry.exception.BusinessException;
import com.tesco.enquiry.exception.SystemException;
import com.tesco.enquiry.model.EnquiryDaoRequest;
import com.tesco.enquiry.model.EnquiryDaoResponse;

@Service
public interface ICreditLimitEnquiryDao {

	public EnquiryDaoResponse enquiry(EnquiryDaoRequest enquiryDaoRequest) throws BusinessException, SystemException;
}
