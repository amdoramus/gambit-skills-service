package com.revature.gambit.skill.driver;

import org.springframework.cloud.openfeign.FeignClient;

import feign.RequestLine;


/**
 * PUT IN THE SERVICE WE ARE CONNECTING TO 
 * @author Delano
 *
 */
@FeignClient("")
public interface EurekaClient {
	
	@RequestLine("GET")
	public String getTestMessage();

}
