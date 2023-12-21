package com.medina.sisgetion.infracciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InfraccionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfraccionesApplication.class, args);
	}

}
