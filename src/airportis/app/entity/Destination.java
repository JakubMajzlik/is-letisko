package airportis.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="destinations")
public class Destination {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="airport")
	private String airport;
	
	@Column(name="city")
	private String city;
	
	@Column(name="country")
	private String country;
	
	
	@Column(name="latitude")
	private double latitude;
	
	@Column(name="longitude")
	private double longitude;
	
	public Destination() {}

	public Destination(String airport, String city, String country, double latitude, double longitude) {
		super();
		this.airport = airport;
		this.city = city;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public int getDistance() {
		final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(latitude - 49.096328);
	    double lonDistance = Math.toRadians(longitude - 19.734064);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(49.096328)) * Math.cos(Math.toRadians(latitude))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    distance = Math.pow(distance, 2);
	    return (int)Math.sqrt(distance);
	}
	
	@Override
	public String toString() {
		return "Destination [id=" + id + ", airport=" + airport + ", city=" + city + ", country=" + country
				+ ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
