package com.SmsCallback.Service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.SmsCallback.Repository.callbackRepository;
import com.SmsCallback.model.callback;

@Component
public class SchedularClass {
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(SchedularClass.class);

	
	@Autowired
	callbackRepository cbRepository;

	@Autowired
	SmsCallbackService smscbService;
	
	@Scheduled(fixedRate = 1000)
	public void makeCall() {
		boolean schedularStart=true;
		callback cb = cbRepository.findFirstByFlag(0);
		if(schedularStart) {
			try {
				if(cb!=null) {
				String response=	smscbService.getcall(cb);
				if(response!=null)
				{ cb.setFlag(1);
				   cbRepository.save(cb);
				    smscbService.saveCallback_archData(cb, response);}
				}
				else {
					logger.info("No More Callback Left");
					schedularStart=false;
				}
			}catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		
	  
	}

}
