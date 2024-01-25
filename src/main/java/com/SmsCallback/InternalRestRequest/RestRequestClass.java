package com.SmsCallback.InternalRestRequest;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.SmsCallback.model.callback;


@Component
public class RestRequestClass {

	Logger logger = LoggerFactory.getLogger(RestRequestClass.class);

	@Autowired
	Properties properties;
	
	RestTemplate restTemplate = new RestTemplate();
	
	@Value("${urlString}")
	private String ClientUrl;


	public String getRequest(callback cb) {

					UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(ClientUrl);
					this.setpathVariables(builder);

					Map<String, String> queryParam= properties.getQuery();
					
						builder.queryParam(queryParam.get("corelationid"), cb.getCorelationid());
						builder.queryParam(queryParam.get("txid"), cb.getTxid());
						builder.queryParam(queryParam.get("to"), cb.getTok());
						builder.queryParam(queryParam.get("from"), cb.getFromk());
						builder.queryParam(queryParam.get("description"), cb.getDescription());
						builder.queryParam(queryParam.get("pdu"), cb.getPdu());
						builder.queryParam(queryParam.get("text"), cb.getText());
						builder.queryParam(queryParam.get("deliverystatus"), cb.isDeliverystatus());
						builder.queryParam(queryParam.get("deliverydt"), cb.getDeliverydt());

						
					// final url arfter setting path variable and query parameter
					String finalUrlString = builder.build().toUriString();
					
					// Making Request
					try {
						
						logger.info("Requested Url:"+ finalUrlString);
						ResponseEntity<String> responseEntity =this.restTemplate.exchange(finalUrlString, HttpMethod.GET, this.getHttpEntity(this.setHeaders()), String.class);
											
						// Empty the String for next call
						finalUrlString = "";
						return responseEntity.getBody();

					} catch (Exception e) {
						logger.warn(e.getMessage());
						return null;
					}

		}
	
	//7.  used to set the header of the request
		public HttpHeaders setHeaders() {
			HttpHeaders headers = new HttpHeaders();

			if (properties.getHeader() != null) {
				for (Map.Entry<String, String> entry : properties.getHeader().entrySet()) {
					if (!entry.getValue().isEmpty()) {
						headers.add(entry.getKey(), entry.getValue());
					}
				}
			}
			return headers;
		}

		//8.  method used to set the pathvariable of the request
		public void setpathVariables(UriComponentsBuilder builder) {
			if (properties.getPathVariable() != null) {
				for (Map.Entry<String, String> entry : properties.getPathVariable().entrySet()) {
					if (!entry.getValue().isEmpty())
						builder.path("/" + entry.getValue());
				}
			}
		}
		
		public HttpEntity<Object> getHttpEntity(HttpHeaders headers) {
			return new HttpEntity<>(headers);
		}
}
