package io.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import io.example.Entity.Rating;

@SpringBootApplication
@EnableDiscoveryClient
public class RatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingServiceApplication.class, args);
	}
	
//	@Bean
//	public Rating getRatingIns() {
//		return new Rating("ABC Travels",4.2);
//	}
	
	@Bean
	public List<Rating> getRatingIn() {
		List<Rating> rating = new ArrayList<Rating>();
		Rating r1 = new Rating("ABC Travels",4.5);
		Rating r2 = new Rating("Jeevan Travels",4.0);
		rating.add(r1);
		rating.add(r2);
		
		return rating;
	}
}
