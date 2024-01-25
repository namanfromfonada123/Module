package com.SmsCallback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * createdOn:: 2023-04-01
 * @author Rahul
 *
 */
@SpringBootApplication
@EnableScheduling
public class SmsCallbackRecordApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsCallbackRecordApplication.class, args);
	}

}
