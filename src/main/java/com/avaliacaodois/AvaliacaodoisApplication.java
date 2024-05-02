package com.avaliacaodois;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class AvaliacaodoisApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvaliacaodoisApplication.class, args);
	}

}
