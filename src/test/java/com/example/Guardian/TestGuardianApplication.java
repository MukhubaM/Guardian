package com.example.Guardian;

import org.springframework.boot.SpringApplication;

public class TestGuardianApplication {

	public static void main(String[] args) {
		SpringApplication.from(GuardianApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
