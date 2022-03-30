package com.carda.GuardianAssesment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carda.GuardianAssesment.Auth.Authorization;
import com.carda.GuardianAssesment.Model.TransactionReport.TransactionReportRequest;
import com.carda.GuardianAssesment.Model.TransactionReport.TransactionReportResponse;
import com.carda.GuardianAssesment.Service.TransactionReportService;

@RestController
@RequestMapping("/txn")
public class TransactionReportController {

	@Autowired
	private TransactionReportService trnxReportServ;
	
	public TransactionReportController(TransactionReportService trnxReportServ) {
		this.trnxReportServ=trnxReportServ;
	}
	
	@PostMapping
	@RequestMapping("/getTrnxReport")
	public TransactionReportResponse getTransactionsDetail(@RequestBody TransactionReportRequest trnxReportReq) {
		TransactionReportResponse resp = null;
		if (Authorization.auth.isValid()) {
			resp = trnxReportServ.transactionReport(trnxReportReq, Authorization.auth.getToken()); 
		}
		return resp;
	}
	
}
