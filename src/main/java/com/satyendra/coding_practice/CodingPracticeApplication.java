package com.satyendra.coding_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CodingPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingPracticeApplication.class, args);
	}

}
