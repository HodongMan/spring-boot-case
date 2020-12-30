package com.hodong.eurekaprac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class EurekapracApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekapracApplication.class, args);
	}

}
