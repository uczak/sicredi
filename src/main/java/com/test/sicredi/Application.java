package com.test.sicredi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class Application {
	@PostConstruct
	public void init() {
		// Setting Spring Boot SetTimeZone
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
