package com.keerthi.tamilSchool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TamilSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(TamilSchoolApplication.class, args);
	}

}
