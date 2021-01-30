package com.hodong.zuulprac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@EnableZuulProxy
@SpringBootApplication
public class ZuulpracApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulpracApplication.class, args);
	}

}
