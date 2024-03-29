package com.coding.springbootrestmechanismsystemexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MechanismApplication {
	public static void main(String[] args) {
		SpringApplication.run(MechanismApplication.class, args);
	}

}
