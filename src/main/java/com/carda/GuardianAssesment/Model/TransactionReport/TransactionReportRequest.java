package com.carda.GuardianAssesment.Model.TransactionReport;

import java.time.LocalDate;

public class TransactionReportRequest {
	
	private LocalDate fromDate;
	private LocalDate toDate;
	private int merchantId;
	private int acquirerId;
	
	TransactionReportRequest(){
		
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public int getAcquirerId() {
		return acquirerId;
	}

	public void setAcquirerId(int acquirerId) {
		this.acquirerId = acquirerId;
	}
	
}
