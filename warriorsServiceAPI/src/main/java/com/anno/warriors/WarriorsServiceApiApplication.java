package com.anno.warriors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anno.warriors.dw8.DynastyWarriors8Application;

@SpringBootApplication
public class WarriorsServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarriorsServiceApiApplication.class, args);
	}
	
	public WarriorsServiceApiApplication() {
		DynastyWarriors8Application.getInstance();
	}

}
