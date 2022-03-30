package com.carda.GuardianAssesment.Auth;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class Authorization {

	
	private String apiKey="Authentication";
	
	private String token;
	
	private LocalDateTime tokenTimeStamp;
	
	private boolean isValid;
	
	private long tokenTimeout=600L;

	public static Authorization auth = new Authorization();

	private Authorization() {
		
	}

	public String getToken() {
		if (isValid()) {
			return token;
		} else
			return "";
	}

	public boolean setToken(String token) {
		this.token = token;
		setTokenTimeStamp(LocalDateTime.now());
		return true;
	}

	private LocalDateTime getTokenTimeStamp() {
		return tokenTimeStamp;
	}

	private void setTokenTimeStamp(LocalDateTime tokenTimeStamp) {
		this.tokenTimeStamp = tokenTimeStamp;
	}

	public boolean isValid() {
		isValid = (LocalDateTime.now().compareTo(getTokenTimeStamp().plus(getTokenTimeout(), ChronoUnit.SECONDS)) < 0);
		return isValid;
	}

	public String getApiKey() {
		return apiKey;
	}

	
	private void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public long getTokenTimeout() {
		return tokenTimeout;
	}
	
	
	private void setTokenTimeout(long tokenTimeout) {
		this.tokenTimeout = tokenTimeout;
	}

}
