package com.tracker.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EntityScan("com.tracker.app.model*")
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan({ "com.tracker.app","service", "configuration","controller","repository","model" })
public class TickettrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TickettrackerApplication.class, args);
	}

}
