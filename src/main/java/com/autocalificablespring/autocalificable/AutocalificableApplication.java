package com.autocalificablespring.autocalificable;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication

public class AutocalificableApplication {

	private static final Logger logger = LoggerFactory.getLogger(AutocalificableApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AutocalificableApplication.class, args);

		logger.info("Aplicación iniciada. Probando conexión a PostgreSQL.");
	}


}
