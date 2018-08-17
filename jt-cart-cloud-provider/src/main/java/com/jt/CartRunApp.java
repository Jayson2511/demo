package com.jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
@MapperScan(basePackages="com.jt.mapper")
public class CartRunApp {
	public static void main(String[] args) {
		
		SpringApplication.run(CartRunApp.class, args);
	}
}
