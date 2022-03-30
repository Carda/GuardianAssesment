package com.carda.GuardianAssesment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carda.GuardianAssesment.Auth.Authorization;
import com.carda.GuardianAssesment.Model.Merchant.MerchantRequest;
import com.carda.GuardianAssesment.Model.Merchant.MerchantResponse;
import com.carda.GuardianAssesment.Service.MerchantService;

@RestController
@RequestMapping("/merc")
public class MerchantController {

	@Autowired
	private MerchantService merchServ;
	
	
	public MerchantController(MerchantService merchServ) {
		this.merchServ=merchServ;
	}
	
	@PostMapping
	@RequestMapping("/validate")
	public MerchantResponse validateMerch(@RequestBody MerchantRequest merch) {
		MerchantResponse resp = merchServ.validateMerchant(merch);
		Authorization.auth.setToken(resp.getToken());
		return resp;
	}
}
