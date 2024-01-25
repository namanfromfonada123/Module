package com.SmsCallback.Service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SmsCallback.InternalRestRequest.RestRequestClass;
import com.SmsCallback.Repository.callbackRepository;
import com.SmsCallback.Repository.callback_archRepository;
import com.SmsCallback.model.callback;
import com.SmsCallback.model.callback_arch;

@Service
public class SmsCallbackService {
	
	@Autowired
	callbackRepository cbRepository;
	
	@Autowired
	RestRequestClass requestClass;
	
	@Autowired
	callback_archRepository  cbaRepository;

	public callback saveCallbackData(Map<String, String> callBackData){
		callback cb = new callback();
		cb.setCorelationid(Long.parseLong(callBackData.get("corelationid" )));
		cb.setTxid(Long.parseLong(callBackData.get("txid" )));
		cb.setTok(callBackData.get("to"));
		cb.setFromk(callBackData.get("from"));
		cb.setDescription(callBackData.get("description"));
		cb.setPdu(Integer.parseInt(callBackData.get("pdu")));
		cb.setText(callBackData.get("text"));
		cb.setDeliverystatus(Boolean.parseBoolean(callBackData.get("deliverystatus")));
		cb.setDeliverydt(callBackData.get("deliverydt"));
		cb.setFlag(0);
		try {
			 return cbRepository.save(cb);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	public String getcall(callback cb)
	{
		return requestClass.getRequest(cb);
	}
	
	public callback_arch saveCallback_archData(callback cb, String Response) {
		
		callback_arch cba = new callback_arch();
		cba.setCorelationid(cb.getCorelationid());
		cba.setTxid(cb.getTxid());
		cba.setTok(cb.getTok());
		cba.setFromk(cb.getFromk());
		cba.setDescription(cb.getDescription());
		cba.setPdu(cb.getPdu());
		cba.setText(cb.getText());
		cba.setDeliverystatus(cb.isDeliverystatus());
		cba.setDeliverydt(cb.getDeliverydt());
		cba.setResponse(Response);
		
		 return cbaRepository.save(cba);
	}
}
