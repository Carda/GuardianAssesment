package com.carda.GuardianAssesment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.carda.GuardianAssesment.Model.Merchant.MerchantRequest;
import com.carda.GuardianAssesment.Model.Merchant.MerchantResponse;

/**
 * @author Cagdas Arda
 * @version 1.0
 * Merchant related services
 * 
 * */
@Service
public class MerchantService {

	
	
	@Value("${config.url.merchant}")
	private String url;
		
	private RestTemplate restOp;
	
	@Autowired
	public MerchantService(RestTemplateBuilder restTemplateBuilder) {
		 restOp = restTemplateBuilder.build();
	}
	
	/**
	 * Validates Merchant email and password and gets token
	 * */
	
	public MerchantResponse validateMerchant(MerchantRequest merch) {
		HttpEntity<MerchantRequest> reqEntity = new HttpEntity<>(merch);
		MerchantResponse response = restOp.exchange(this.url, HttpMethod.POST, reqEntity,MerchantResponse.class).getBody();
		return response; 
	}
	
}
