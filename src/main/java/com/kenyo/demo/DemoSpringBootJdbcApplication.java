package com.kenyo.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemoSpringBootJdbcApplication {
	
	private static final Logger log = LoggerFactory.getLogger(DemoSpringBootJdbcApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootJdbcApplication.class, args);
	}	
	
}
