package com.dw8xl.restdw8xl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.dw8xl.restdw8xl.dao", "com.dw8xl.restdw8xl.service"})
public class RestDw8xlApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDw8xlApplication.class, args);
	}

}
