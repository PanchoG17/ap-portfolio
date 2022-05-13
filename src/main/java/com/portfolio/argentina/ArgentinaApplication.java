package com.portfolio.argentina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.portfolio.argentina.Model")
@SpringBootApplication
public class ArgentinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArgentinaApplication.class, args);
	}

}
