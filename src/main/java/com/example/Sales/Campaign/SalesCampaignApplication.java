package com.example.Sales.Campaign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SalesCampaignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesCampaignApplication.class, args);
		System.out.println("API is Running");
	}

}
