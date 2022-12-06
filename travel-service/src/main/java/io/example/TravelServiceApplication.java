package io.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.example.Entity.Partner;

@SpringBootApplication
@EnableDiscoveryClient
public class TravelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelServiceApplication.class, args);
	}
	
	@Bean
	public List<Partner> partners(){
		
		Partner p1 = new Partner("ABC Travels","Chennai");
		Partner p2 = new Partner("Jeevan Travels","Kochi");

		List<Partner> partners = new ArrayList<Partner>();
		partners.add(p1);
		partners.add(p2);
		return partners;
	}
	
	@Bean
	public RestTemplate getIns() {
		return new RestTemplate();
	}
	
}
