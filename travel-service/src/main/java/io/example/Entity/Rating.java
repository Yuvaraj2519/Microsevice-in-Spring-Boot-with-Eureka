package io.example.Entity;

public class Rating {
	
	private String partnerName;
	private double rating;
	
	public Rating() {
		super();
	}

	public Rating(String partnerName, double d) {
		super();
		this.partnerName = partnerName;
		this.rating = d;
	}
	
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	
}
