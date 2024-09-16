package com.tesco.enquiry.intg.dao;

import org.springframework.stereotype.Component;

import com.tesco.enquiry.exception.BusinessException;
import com.tesco.enquiry.exception.SystemException;
import com.tesco.enquiry.model.EnquiryDaoRequest;
import com.tesco.enquiry.model.EnquiryDaoResponse;

@Component
public class CreditLmitEnquiryDaoImpl implements ICreditLimitEnquiryDao {

	@Override
	public EnquiryDaoResponse enquiry(EnquiryDaoRequest enquiryDaoRequest) throws BusinessException, SystemException {
		// TODO Auto-generated method stub
		
		System.out.println("Entered into dao");
		
		EnquiryDaoResponse enquiryDaoResponse;
		try {
			//1: get the request from service layer
			
			//2: prepare the request for database
			
			//3: call the database and get the response
			
			String dbRespCode = "0";
			String dbRespMsg = "success";
			
			enquiryDaoResponse = new EnquiryDaoResponse();
			
			if("0".equals(dbRespCode)) {
			enquiryDaoResponse.setRespCode("0");
			enquiryDaoResponse.setRespMsg("success");
			enquiryDaoResponse.setCvv("123");
			enquiryDaoResponse.setCardNum("864297531");
			enquiryDaoResponse.setAvailableAmount(500000);
			enquiryDaoResponse.setIncreaseAmount(25000);
			enquiryDaoResponse.setIncreasePer(0.5f);
			
			}else if( "100".equals(dbRespCode) || "101".equals(dbRespCode) || "102".equals(dbRespCode)) {
			
				throw new BusinessException(dbRespCode, dbRespMsg);
			}else {
			    
				throw new SystemException(dbRespCode, dbRespMsg);
			}
		} catch (BusinessException be) {
			
			throw be ;
		} catch (SystemException se) {
			
			throw se ;
		}
		
		
		
	    System.out.println("Exite from dao");
		
		return enquiryDaoResponse;
	}
	
}

	

