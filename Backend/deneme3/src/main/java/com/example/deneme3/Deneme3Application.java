package com.example.deneme3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Deneme3Application {
	public static void main(String[] args) {
		SpringApplication.run(Deneme3Application.class, args);
	}
}
