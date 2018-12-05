package com.carbook;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class CarbookApplication{

	private static final Logger logger = LoggerFactory.getLogger(CarbookApplication.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CarbookApplication.class, args);
		logger.info("CarBook applications: started...");
	}
}
