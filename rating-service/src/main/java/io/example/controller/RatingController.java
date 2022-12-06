package io.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.example.Entity.Rating;

@RestController
@RequestMapping("/ratingService")
public class RatingController {
	
	@Autowired
	private List<Rating> rating;
	
	private Rating response;
	
	@GetMapping("/getRating")
	public Rating getRating(@RequestParam("name") String name) {
		for(Rating r : rating) {
			if(r.getPartnerName().equalsIgnoreCase(name)) {
				response = r;
			} 
		}
		return response;
	}
	
	@GetMapping("/getRatings")
	public List<Rating> getRatings() {
		
		return rating;
	}
}
