package io.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import io.example.Entity.Partner;
import io.example.Entity.Rating;

@RestController
@RequestMapping("/partnerService")
public class PartnerController {
	
	@Autowired
	private List<Partner> partner;
	
	@Autowired
	private LoadBalancerClient loadBalanceClient;
	
	@Autowired
	RestTemplate resttemplate;
		
	private String getBaseUrl() {
		ServiceInstance instance = loadBalanceClient.choose("rating-service");
		return instance.getUri().toString();
	}
	
	@GetMapping("/getPartners")
	public List<Partner> getParts(){
		return partner;
	}
	
	@GetMapping("/getPartnerRate")
	public Map<String, Object> getRatePartner(@RequestParam("name") String name) {
		Partner result = new Partner();
		Map<String, Object> response = new HashMap<String,Object>();
		for(Partner p : partner) {
			if(p.getName().equalsIgnoreCase(name))
				result = p;
		}
		response.put("partner", result);
		UriComponentsBuilder build = UriComponentsBuilder
				.fromUriString(getBaseUrl()+"/ratingService/getRating")
				.queryParam("name", name);
		Rating rating = resttemplate.
				getForObject(build.toUriString(), Rating.class);
		response.put("rating", rating);
		return response;
	}
	
}
