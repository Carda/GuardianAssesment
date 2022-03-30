package com.carda.GuardianAssesment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.carda.GuardianAssesment.Model.TransactionReport.TransactionReportRequest;
import com.carda.GuardianAssesment.Model.TransactionReport.TransactionReportResponse;

/**
 * @author Cagdas Arda
 * @version 1.0 Transaction related services
 * 
 */
@Service
public class TransactionReportService {

	@Value("${config.url.trnxReport}")
	private String url;

	private RestTemplate restOp;

	@Autowired
	public TransactionReportService(RestTemplateBuilder restTempBuild) {
		restOp = restTempBuild.build();
	}
	
	public TransactionReportResponse transactionReport(TransactionReportRequest trnxReq,String authorization) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", authorization);
		HttpEntity<TransactionReportRequest> reqEntity = new HttpEntity<>(trnxReq,headers);
		TransactionReportResponse trnxReportResp = restOp.exchange(url, HttpMethod.POST, reqEntity, TransactionReportResponse.class).getBody();
		return trnxReportResp;
	}

}
