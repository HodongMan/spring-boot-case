package com.hodong.eurekaclientprac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
public class EurekaclientpracApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaclientpracApplication.class, args);
	}

}
