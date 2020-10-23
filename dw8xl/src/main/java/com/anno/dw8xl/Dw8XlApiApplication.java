package com.anno.dw8xl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication (scanBasePackages = {
		"com.anno.dw8xl.attribute.controller", "com.anno.dw8xl.attribute.facade", "com.anno.dw8xl.attribute.dao",
		"com.anno.dw8xl.character.controller", "com.anno.dw8xl.character.dao",
		"com.anno.dw8xl.kingdom.controller", "com.anno.dw8xl.kingdom.facade", "com.anno.dw8xl.kingdom.dao",
}, exclude = {DataSourceAutoConfiguration.class})
public class Dw8XlApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Dw8XlApiApplication.class, args);
	}

}
