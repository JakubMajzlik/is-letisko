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
	private String airport;
	
	@NotNull(message="This field is required")
	@Digits(fraction=20, integer=3, message="This field has to contain only digits")
	private double latitude;
	
	@NotNull(message="This field is required")
	@Digits(fraction=20, integer=3, message="This field has to contain only digits")
	private double longitude;
	
	private int distance;
	
	public DestinationModel() {}

	
	
	public DestinationModel(int id, @NotNull(message = "This field is required") String country,
			@NotNull(message = "This field is required") String city,
			@NotNull(message = "This field is required") String airport,
			@NotNull(message = "This field is required") @Digits(fraction = 20, integer = 3, message = "This field has to contain only digits") double latitude,
			@NotNull(message = "This field is required") @Digits(fraction = 20, integer = 3, message = "This field has to contain only digits") double longitude,
			int distance) {
		this.id = id;
		this.country = country;
		this.city = city;
		this.airport = airport;
		this.latitude = latitude;
		this.longitude = longitude;
		this.distance = distance;
	}



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

	
	
	public String getAirport() {
		return airport;
	}



	public void setAirport(String airport) {
		this.airport = airport;
	}



	public double getLatitude() {
		return latitude;
	}



	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}



	public double getLongitude() {
		return longitude;
	}



	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "DestinationModel [id=" + id + ", country=" + country + ", city=" + city + ", airport=" + airport
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", distance=" + distance + "]";
	}
	
}
