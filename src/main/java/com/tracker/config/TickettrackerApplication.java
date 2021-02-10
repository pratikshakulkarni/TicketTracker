package com.tracker.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan({ "com.tracker", "controller","config","entity" })
public class TickettrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TickettrackerApplication.class, args);
	}

}
