package com.wizeline.maven.learningjava;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LearningJavaApplication {

	private static final Logger LOGGER = Logger.getLogger(LearningJavaApplication.class.getName());

	public static void main(String[] args) throws IOException {
		SpringApplication.run(LearningJavaApplication.class, args);
		LOGGER.info("LearningJava - Iniciado servicio REST ...");
	}

}
