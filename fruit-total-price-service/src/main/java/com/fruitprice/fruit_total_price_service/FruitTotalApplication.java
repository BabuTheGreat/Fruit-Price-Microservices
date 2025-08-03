package com.fruitprice.fruit_total_price_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FruitTotalApplication {

	public static void main(String[] args) {
		SpringApplication.run(FruitTotalApplication.class, args);
	}

}
