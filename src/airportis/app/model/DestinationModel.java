package airportis.app.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class DestinationModel {
	private int id;
	
	@NotNull(message="This field is required")
	private String country;
	
	@NotNull(message="This field is required")
	private String city;
	
	@NotNull(message="This field is required")
	@Digits(fraction=0, integer=5, message="This field has to contain only digits")
	private String distance;
	
	public DestinationModel() {}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DestinationModel [id=" + id + ", country=" + country + ", city=" + city + ", distance=" + distance
				+ "]";
	}
	
	
}
