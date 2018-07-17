package com.egiants.mrkt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.egiants.mrkt"})
public class MarketingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketingServiceApplication.class, args);
	}
}
