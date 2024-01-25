package com.SmsCallback.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SmsCallback.Repository.callbackRepository;
import com.SmsCallback.Service.SmsCallbackService;
import com.SmsCallback.model.callback;


@RestController
public class SmsCallbackController {

	@Autowired
	SmsCallbackService smscbService;
	
	@Autowired 
	 callbackRepository cbRepository;
	
	@GetMapping("/")
	public String CallBack(@RequestParam Map<String, String> requestdata) {		
			callback cb =	smscbService.saveCallbackData(requestdata);
			if(cb!=null) {
				return "Save Successfully";
			}
			else {
				return "Save Unsuccessfull";
			}
	}
	
	
	
}

