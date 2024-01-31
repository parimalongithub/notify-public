package com.example.notify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NotifyApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(NotifyApplication.class, args);
	}


}
