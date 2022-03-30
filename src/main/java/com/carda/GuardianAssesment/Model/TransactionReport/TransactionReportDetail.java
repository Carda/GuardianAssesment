package com.carda.GuardianAssesment.Model.TransactionReport;

public class TransactionReportDetail {
	private int count;
	private int total;
	private String currency;
	
	TransactionReportDetail(){
		
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
