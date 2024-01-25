package com.SmsCallback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SmsCallback.model.callback;

@Repository
public interface callbackRepository extends JpaRepository<callback, Long> {

	public callback findFirstByFlag(int flag);
	
	
}
