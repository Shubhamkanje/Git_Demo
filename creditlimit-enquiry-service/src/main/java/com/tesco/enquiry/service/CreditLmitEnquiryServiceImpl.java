package com.tesco.enquiry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tesco.enquiry.exception.BusinessException;
import com.tesco.enquiry.exception.SystemException;
import com.tesco.enquiry.intg.dao.ICreditLimitEnquiryDao;
import com.tesco.enquiry.model.CreditLimitRequest;
import com.tesco.enquiry.model.CreditLimitResponse;
import com.tesco.enquiry.model.CustomerInfo;
import com.tesco.enquiry.model.EnquiryDaoRequest;
import com.tesco.enquiry.model.EnquiryDaoResponse;
import com.tesco.enquiry.model.StatusBlock;

@Component
public class CreditLmitEnquiryServiceImpl implements ICreditLmitEnquiryService {

	@Autowired
	ICreditLimitEnquiryDao creditLimitDao;

	@Override
	public CreditLimitResponse enquiry(CreditLimitRequest creditLimitRequest) throws BusinessException, SystemException {
		// TODO Auto-generated method stub

		System.out.println("Entered into service");

		// 1: Get the request from controller

		// 2: prepare the request for integration layer

		// 3: call the integration layer and get the respoonse

		EnquiryDaoRequest enquiryDaoRequest = new EnquiryDaoRequest();
		EnquiryDaoResponse daoResp = creditLimitDao.enquiry(enquiryDaoRequest);

		CreditLimitResponse creditLimitResponse = new CreditLimitResponse();

		StatusBlock statusBlock = new StatusBlock();
		statusBlock.setRespCode(daoResp.getRespCode());
		statusBlock.setRespMsg(daoResp.getRespMsg());

		creditLimitResponse.setStatusBlock(statusBlock);

		CustomerInfo customerInfo = new CustomerInfo();

		customerInfo.setCvv(daoResp.getCvv());
		customerInfo.setCardNum(daoResp.getCardNum());
		customerInfo.setAvailableAmount(daoResp.getAvailableAmount());
		customerInfo.setIncreaseAmount(daoResp.getIncreaseAmount());
		customerInfo.setIncreasePer(daoResp.getIncreasePer());

		creditLimitResponse.setCustomerInfo(customerInfo);

		System.out.println("Exit from service");

		return creditLimitResponse;
	}

}
