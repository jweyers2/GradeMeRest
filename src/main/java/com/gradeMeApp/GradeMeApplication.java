package com.gradeMeApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gradeMeApp.controller.mapper.UserMapper;

@SpringBootApplication
public class GradeMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradeMeApplication.class, args);

	}

}
