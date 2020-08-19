package com.org.kapil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FoodBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodBookingApplication.class, args);
	}

}
