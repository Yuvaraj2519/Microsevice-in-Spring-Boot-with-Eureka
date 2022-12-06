package io.example.Entity;

public class Partner {
	
	private String name;
	private String office;
			
	public Partner(String name, String office) {
		super();
		this.name = name;
		this.office = office;
		}

	public Partner() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
		
}
