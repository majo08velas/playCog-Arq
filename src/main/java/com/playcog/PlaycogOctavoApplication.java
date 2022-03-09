package com.playcog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.playcog"})
public class PlaycogOctavoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaycogOctavoApplication.class, args);
		System.out.println("***** Servidor Arriba *****");
	}

}
