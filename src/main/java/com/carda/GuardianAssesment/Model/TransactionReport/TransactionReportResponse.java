package com.carda.GuardianAssesment.Model.TransactionReport;

import java.util.List;

public class TransactionReportResponse {
	private String status;
	private List<TransactionReportDetail> response;
	
	TransactionReportResponse(){
		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<TransactionReportDetail> getResponse() {
		return response;
	}

	public void setResponse(List<TransactionReportDetail> response) {
		this.response = response;
	}
}
