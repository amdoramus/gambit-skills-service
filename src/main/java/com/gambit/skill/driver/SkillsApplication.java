package com.gambit.skill.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableEurekaClient
@EnableCircuitBreaker
public class SkillsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkillsApplication.class, args);
	}
	
	@RequestMapping(value="/")
	public String test() {
		return "test";
	}
}
