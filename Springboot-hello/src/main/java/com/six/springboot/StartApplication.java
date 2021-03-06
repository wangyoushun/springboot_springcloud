package com.six.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAutoConfiguration
@SpringBootApplication
@EnableScheduling
@EnableCaching
public class StartApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

}